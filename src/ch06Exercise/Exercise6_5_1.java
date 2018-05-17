package ch06Exercise;

import ch06.GraphKind;
import ch06.MGraph;

/**
 * 1.���ڽӾ���洢�ṹ��ʵ��ͼ�Ļ���������InsertArc(G,v,w, P)��DeleteArc(G,v,w)��
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_5_1 {
	public final static int INFINITY = Integer.MAX_VALUE;

	void insertArc(MGraph G, Object v, Object w, int P) {
		int iv = G.locateVex(v);
		int iw = G.locateVex(w);
		int[][] arcs = G.getArcs();
		arcs[iv][iw] = P;
		G.setArcs(arcs);
		G.setArcNum(G.getArcNum() + 1);
	}

	void deleteArc(MGraph G, Object v, Object w) {
		int iv = G.locateVex(v);
		int iw = G.locateVex(w);
		int[][] arcs = G.getArcs();
		arcs[iv][iw] = INFINITY;
		G.setArcs(arcs);
		G.setArcNum(G.getArcNum() - 1);
	}

	public static void main(String[] args) throws Exception {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, 7, 1, 5, INFINITY, INFINITY },
				{ 7, 0, 6, INFINITY, 3, INFINITY }, { 1, 6, 0, 7, 6, 4 },
				{ 5, INFINITY, 7, 0, INFINITY, 2 },
				{ INFINITY, 3, 6, INFINITY, 0, 7 },
				{ INFINITY, INFINITY, 4, 2, 7, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);
		System.out.println("�޸�ǰͼ�ı���Ϊ��" + G.getArcNum());

		Exercise6_5_1 exercise5_1 = new Exercise6_5_1();
		exercise5_1.deleteArc(G, "v0", "v1");
		System.out.println("ɾ��V0-V1�ߺ�ͼ�ı���Ϊ��" + G.getArcNum());
		exercise5_1.insertArc(G, "v0", "v1", 7);
		System.out.println("����V0-V1�ߺ�ͼ�ı���Ϊ��" + G.getArcNum());
	}

}

//���Խ����
//�޸�ǰͼ�ı���Ϊ��10
//ɾ��V0-V1�ߺ�ͼ�ı���Ϊ��9
//����V0-V1�ߺ�ͼ�ı���Ϊ��10
