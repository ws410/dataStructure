package ch06Exercise;

import ch06.GenerateGraph;
import ch06.MGraph;
import ch06.ShortestPath_DIJ;

/**
 * @author zouyimin
 *
 */
public class Exercise6_5_2 {
	private boolean[][] P;// v0�����ඥ������·��, ��P[v][w]Ϊtrue����w�Ǵ�v0��v��ǰ������·���ϵĶ���

	private int[] D;// v0�����ඥ��Ĵ�Ȩ����

	public final static int INFINITY = Integer.MAX_VALUE;

	// ��Dijkstra�㷨��������G��v0���㵽���ඥ��v�����·��P[v]����ȨֵD[v]
	public void DIJ(MGraph G, int v0) {
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]Ϊtrue���ҽ���v����S,���Ѿ���ô�v0��v�����·��
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			for (int w = 0; w < vexNum; w++)
				P[v][w] = false;// ���·��
			if (D[v] < INFINITY) {
				P[v][v0] = true;
				P[v][v] = true;
			}
		}

		D[v0] = 0;// ��ʼ����v0��������S��
		finish[v0] = true;
		int v = -1;

		// ��ʼ��ѭ����ÿ�����v0��ĳ��v��������·��������v��S��
		for (int i = 1; i < vexNum; i++) {// ����G.getVexNum-1������
			int min = INFINITY;// ��ǰ��֪��v0������������
			for (int w = 0; w < vexNum; w++)
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			finish[v] = true;// ��v0���������v����S��

			for (int w = 0; w < vexNum; w++)
				// ���µ�ǰ���·��������
				if (!finish[w] && G.getArcs()[v][w] < INFINITY
						&& (min + G.getArcs()[v][w] < D[w])) { // �޸�D[w]��P[w],w����V-S
					D[w] = min + G.getArcs()[v][w];
					System.arraycopy(P[v], 0, P[w], 0, P[v].length);
					P[w][w] = true;
				}
		}
	}

	public int[] getD() {
		return D;
	}

	public boolean[][] getP() {
		return P;
	}

	public static void main(String[] args) throws Exception {
		MGraph G = GenerateGraph.generateMGraph();
		ShortestPath_DIJ dij = new ShortestPath_DIJ();
		dij.DIJ(G, 0);
		dij.display(G);
	}

	// ����������·���ϵĸ������㼰Ȩֵ
	public void display(MGraph G) throws Exception {
		if (D != null) {
			System.out.println("�������㵽v0�����·���ϵĵ㼰��̾���ֱ��ǣ�");
			for (int i = 0; i < P.length; i++) {
				System.out.print("v0 - " + G.getVex(i) + ": ");
				for (int j = 0; j < P[i].length; j++) {
					if (P[i][j])
						System.out.print(G.getVex(j) + "\t");
				}
				System.out.println("��̾���Ϊ�� " + D[i]);
			}
		}
	}

}

// ���Խ����
// �������㵽v0�����·���ϵĵ㼰��̾���ֱ��ǣ�
// v0 - v0: v0 ��̾���Ϊ�� 0
// v0 - v1: v0 v1 ��̾���Ϊ�� 7
// v0 - v2: v0 v2 ��̾���Ϊ�� 1
// v0 - v3: v0 v3 ��̾���Ϊ�� 5
// v0 - v4: v0 v2 v4 ��̾���Ϊ�� 7
// v0 - v5: v0 v2 v5 ��̾���Ϊ�� 5
