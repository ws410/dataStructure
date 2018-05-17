package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 5.��д��³˹�����㷨������С��������
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_5 {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static Object[][] KRUSKAL(MGraph G) throws Exception {
		Object[][] tree = new Object[G.getVexNum() - 1][2];// �洢��С�������ı�
		EqualClass A = new EqualClass(G);// �ȼ�������
		MinHeap H = new MinHeap(G);// ��ͼG�ı߹���һ����С��
		int count = 0;
		while (count < G.getVexNum() - 1) {// ��G.vexnum �C 1���߹�����С������
			Object[] vexs = H.removeMin();// ȡ������С��
			Object u = vexs[0];
			Object v = vexs[1];
			if (A.differ(u, v)) {// ���u,v����ͬһ�ȼ�����
				A.union(u, v);// �ϲ���ͬһ�ȼ���
				tree[count][0] = u;// �������ı߷���������
				tree[count][1] = v;
				count++;
			}
		}

		return tree;
	}

	static class MinHeapNode {
		private Object[] vexs;// �ߵ���������

		private int key;// �ߵ�Ȩֵ

		public MinHeapNode(Object[] vexs, int key) {
			this.vexs = vexs;
			this.key = key;
		}

		public Object[] getVexs() {
			return vexs;
		}

		public int getKey() {
			return key;
		}

	}

	static class MinHeap {

		private MinHeapNode[] heapArray;; // ������

		private int maxSize; // �ѵ�����С

		private int currentSize; // �Ѵ�С

		public MinHeap(MGraph G) throws Exception {
			maxSize = G.getVexNum() * G.getVexNum();
			heapArray = new MinHeapNode[maxSize];
			currentSize = 0;
			for (int i = 0; i < G.getVexNum(); i++) {
				for (int j = i + 1; j < G.getVexNum(); j++) {
					Object[] vexs = { G.getVex(i), G.getVex(j) };
					MinHeapNode newNode = new MinHeapNode(vexs,
							G.getArcs()[i][j]);
					insert(newNode);
				}
			}
		}

		// ���϶��µ���
		public void filterDown(int start, int endOfHeap) {
			int i = start;
			int j = 2 * i + 1; // j��i������Ůλ��
			MinHeapNode temp = heapArray[i];

			while (j <= endOfHeap) { // ����Ƿ����λ��
				if (j < endOfHeap // ��jָ������Ů�е�С��
						&& heapArray[j].getKey() > heapArray[j + 1].getKey()) {
					j++;
				}
				if (temp.getKey() <= heapArray[j].getKey()) { // С��������
					break;
				} else { // ����С�����ƣ�i��j�½�
					heapArray[i] = heapArray[j];
					i = j;
					j = 2 * j + 1;
				}
			}
			heapArray[i] = temp;
		}

		// ���¶��ϵĵ���:�ӽ��start��ʼ��0Ϊֹ���������ϱȽϣ������Ů��ֵС��˫�׽���ֵ���ཻ��
		public void filterUp(int start) {
			int j = start;
			int i = (j - 1) / 2;
			MinHeapNode temp = heapArray[j];

			while (j > 0) { // ��˫�׽��·������ֱ����ڵ�
				if (heapArray[i].getKey() <= temp.getKey()) {// ˫�׽��ֵС��������
					break;
				} else {// ˫�׽��ֵ�󣬵���
					heapArray[j] = heapArray[i];
					j = i;
					i = (i - 1) / 2;
				}
				heapArray[j] = temp; // ����
			}
		}

		// ���в�����
		public void insert(MinHeapNode newNode) {
			heapArray[currentSize] = newNode;
			filterUp(currentSize);
			currentSize++;
		}

		// ɾ�����е���Сֵ
		public Object[] removeMin() {
			MinHeapNode root = heapArray[0];
			heapArray[0] = heapArray[currentSize - 1];
			currentSize--;
			filterDown(0, currentSize - 1);
			return root.getVexs();
		}

	}

	static class EqualClass {
		private Object[] S;// ����Ѿ�ѡ����Ķ���

		private Object[] V;// ���δѡ��Ķ���

		EqualClass(MGraph G) {
			S = new Object[G.getVexNum()];
			V = new Object[G.getVexNum()];
			System.arraycopy(G.getVexs(), 0, V, 0, G.getVexs().length);
		}

		public boolean differ(Object u, Object v) {
			boolean isDiffer = false;
			int count = 0;
			for (int i = 0; i < V.length; i++) {
				if (V[i] != null && (V[i].equals(u) || V[i].equals(v)))
					++count;
			}

			if (count == 0 || count == 2)
				isDiffer = true;

			return isDiffer;
		}

		public void union(Object u, Object v) {
			boolean isHaveU = false;// u���Ƿ��Ѿ���ѡ��
			boolean isHaveV = false;
			int i = 0;
			for (; i < S.length && S[i] != null; i++) {
				if (S[i].equals(u))
					isHaveU = true;
				else if (S[i].equals(v))
					isHaveV = true;

			}

			if (!isHaveU)
				S[i] = u;

			if (!isHaveV)
				S[i] = v;

		}
	}

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, 7, 1, 5, INFINITY, INFINITY },
				{ 7, 0, 6, INFINITY, 3, INFINITY }, { 1, 6, 0, 7, 6, 4 },
				{ 5, INFINITY, 7, 0, INFINITY, 2 },
				{ INFINITY, 3, 6, INFINITY, 0, 7 },
				{ INFINITY, INFINITY, 4, 2, 7, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);
		Object[][] T = Exercise6_4_5.KRUSKAL(G);
		for (int i = 0; i < T.length; i++)
			System.out.println(T[i][0] + " - " + T[i][1]);
	}
}


//���Խ����
//v0 - v2
//v3 - v5
//v1 - v4
//v2 - v5
//v0 - v3