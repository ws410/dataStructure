package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 4.��д�㷨����붥��vi�����·������ΪK�����ж��㡣
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_4 {
	public final static int INFINITY = Integer.MAX_VALUE;

	// ��Dijkstra�㷨��vi���㵽���ඥ��v����̳���D[v]
	public void findVex_DIJ(MGraph G, int vi, int k) throws Exception {
		int vexNum = G.getVexNum();
		int[] R = new int[vexNum];// ��ž���vi����Ϊk�Ķ���
		int[] D = new int[vexNum];// vi�����ඥ�����̳���
		boolean isHaveVex = false;// ��¼�Ƿ���ھ��뵽vi����Ϊk�ĵ�

		boolean[] finish = new boolean[vexNum];
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			R[v] = -1;
			D[v] = G.getArcs()[vi][v];
		}

		D[vi] = 0;// ��ʼ����vi��������S��
		finish[vi] = true;
		int v = -1;
		int j = 0;// ����vi����Ϊk�ĵ������

		// ��ʼ��ѭ����ÿ�����vi��ĳ��v��������·��������v��S��
		for (int i = 1; i < vexNum; i++) {// ����G.getVexNum-1������
			int min = INFINITY;// ��ǰ��֪��vi������������
			for (int w = 0; w < vexNum; w++) {
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			}

			if (min == k) {
				R[j++] = v;
				isHaveVex = true;
			} else if (min > k)
				break;

			finish[v] = true;// ��vi���������v����S��

			// ���µ�ǰ���·��������
			for (int w = 0; w < vexNum; w++) {
				if (!finish[w] && G.getArcs()[v][w] < INFINITY
						&& (min + G.getArcs()[v][w] < D[w])) { // �޸�D[w]��P[w],w����V-S
					D[w] = min + G.getArcs()[v][w];
				}
			}
		}

		if (isHaveVex) {
			System.out.println("����vi����Ϊk�Ķ���Ϊ��");
			for (int i = 0; i < R.length; i++) {
				if (R[i] != -1)
					System.out.print(G.getVex(R[i]) + "\t");
				else
					break;
			}
		} else {
			System.out.println("�����ھ���vi����Ϊk�Ķ��㣡");
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

		Exercise6_4_4 exercise4_4 = new Exercise6_4_4();
		exercise4_4.findVex_DIJ(G, 0, 5);
	}
}

//���Խ����
//����vi����Ϊk�Ķ���Ϊ��
//v3	v5	