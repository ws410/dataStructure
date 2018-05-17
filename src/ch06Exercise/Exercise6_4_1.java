package ch06Exercise;

import java.util.Scanner;

import ch06.ALGraph;
import ch06.GraphKind;
import ch06.VNode;

/**
 * 1.��д�㷨���Ӽ��̶�������ͼ�Ķ���ͻ�����������ͼ���ڽӱ�洢�ṹ��
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_1 {

	public static ALGraph createDG() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ���������ͼ�Ķ������ͱ���:");
		int vexNum = sc.nextInt();
		int arcNum = sc.nextInt();
		VNode[] vexs = new VNode[vexNum];
		System.out.println("��ֱ���������ͼ�ĸ�������:");
		for (int v = 0; v < vexNum; v++)
			// ���춥������
			vexs[v] = new VNode(sc.next());

		ALGraph G = new ALGraph(GraphKind.DG, vexNum, arcNum, vexs);

		System.out.println("����������ߵ������յ�:");
		for (int k = 0; k < arcNum; k++) {
			int v = G.locateVex(sc.next());
			int u = G.locateVex(sc.next());
			G.addArc(v, u, 0);
		}

		return G;
	}

	public static void main(String[] args) throws Exception {

		ALGraph G = Exercise6_4_1.createDG();

		System.out.println("�����ͼΪ��");
		for (int i = 0; i < G.getVexNum(); i++) {
			System.out.print(G.getVex(i) + ": ");
			for (int w = G.firstAdjVex(i); w != -1; w = G.nextAdjVex(i, w)) {
				System.out.print(G.getVex(w) + "\t");
			}

			System.out.println();
		}
	}

}

// ���Խ����
// ��ֱ���������ͼ�Ķ������ͱ���:
// 3 2
// ��ֱ���������ͼ�ĸ�������:
// V0 V1 V2
// ����������ߵ������յ�:
// V0 V1
// V0 V2
// �����ͼΪ��
// V0: V2 V1
// V1:
// V2:
