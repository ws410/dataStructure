package ch06Exercise;

import ch03.LinkQueue;
import ch06.ALGraph;
import ch06.ArcNode;
import ch06.GraphKind;
import ch06.IGraph;
import ch06.VNode;

/**
 * 2. ����ͼ�����ڽӱ�洢�ṹ����д�㷨���ͼ�и���ͨ�����Ķ������С�
 * 
 * @author zouyimin
 * 
 */
public class Exercise6_4_2 {

	public static void CC_BFS(IGraph G) throws Exception {
		boolean[] visited = new boolean[G.getVexNum()];// ���ʱ�־����
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		LinkQueue Q = new LinkQueue();// ��������Q
		LinkQueue P = new LinkQueue();// ��������P,���ڼ�¼��ͨ�����Ķ���
		int i = 0;// ���ڼ�����ͨ�����ĸ���
		for (int v = 0; v < G.getVexNum(); v++) {
			P.clear();// �������
			if (!visited[v]) {// v��δ����
				visited[v] = true;
				P.offer(G.getVex(v));
				Q.offer(v);// v�����
				while (!Q.isEmpty()) {
					int u = (Integer) Q.poll();// ��ͷԪ�س����в���ֵ��u
					for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u,
							w)) {
						if (!visited[w]) {// wΪu����δ���ʵ��ڽӶ���
							visited[w] = true;
							P.offer(G.getVex(w));
							Q.offer(w);
						}
					}
				}
				System.out.println("ͼ�ĵ�" + ++i + "����ͨ����Ϊ��");
				while (!P.isEmpty())
					System.out.print(P.poll().toString() + " ");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ArcNode v12 = new ArcNode(1);
		ArcNode v13 = new ArcNode(2, 0, v12);
		VNode v1 = new VNode("v1", v13);

		ArcNode v21 = new ArcNode(0);
		ArcNode v24 = new ArcNode(3, 0, v21);
		VNode v2 = new VNode("v2", v24);

		ArcNode v31 = new ArcNode(0);
		ArcNode v34 = new ArcNode(3, 0, v31);
		VNode v3 = new VNode("v3", v34);

		ArcNode v42 = new ArcNode(1);
		ArcNode v43 = new ArcNode(2, 0, v42);
		VNode v4 = new VNode("v4", v43);

		ArcNode v56 = new ArcNode(5);
		ArcNode v57 = new ArcNode(6, 0, v56);
		VNode v5 = new VNode("v5", v57);

		ArcNode v65 = new ArcNode(4);
		VNode v6 = new VNode("v6", v65);

		ArcNode v75 = new ArcNode(4);
		VNode v7 = new VNode("v7", v75);

		VNode[] vexs = { v1, v2, v3, v4, v5, v6, v7 };
		ALGraph G = new ALGraph(GraphKind.UDG, 7, 12, vexs);
		CC_BFS(G);
	}
}

//���Խ����
//ͼ�ĵ�1����ͨ����Ϊ��
//v1 v3 v2 v4 
//ͼ�ĵ�2����ͨ����Ϊ��
//v5 v7 v6 