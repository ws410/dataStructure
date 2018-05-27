package zhoufan;



import java.util.Scanner;

import ch06.MGraph;

public class ShortestPath_DIJ1 {
	private boolean[][] P;// v0到其余顶点的最短路径, 若P[v][w]为true，则w是从v0到v当前求得最短路径上的顶点

	private int[] D;// v0到其余顶点的带权长度

	public final static int INFINITY = Integer.MAX_VALUE;

	// 用Dijkstra算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其权值D[v]
	public void DIJ(MGraph G, int v0) {
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]为true当且仅当v属于S,即已经求得从v0到v的最短路径
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			for (int w = 0; w < vexNum; w++)
				P[v][w] = false;// 设空路径
			if (D[v] < INFINITY) {
				P[v][v0] = true;
				P[v][v] = true;
			}
		}

		D[v0] = 0;// 初始化，v0顶点属于S集
		finish[v0] = true;
		int v = -1;

		// 开始主循环，每次求得v0到某个v顶点的最短路径，并加v到S集
		for (int i = 1; i < vexNum; i++) {// 其余G.getVexNum-1个顶点
			int min = INFINITY;// 当前所知离v0顶点的最近距离
			for (int w = 0; w < vexNum; w++)
				if (!finish[w])
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
			finish[v] = true;// 离v0顶点最近的v加入S集

			for (int w = 0; w < vexNum; w++)
				// 更新当前最短路径及距离
				if (!finish[w] && G.getArcs()[v][w] < INFINITY
						&& (min + G.getArcs()[v][w] < D[w])) { // 修改D[w]和P[w],w属于V-S
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
		MGraph G = getSignInformation.getLuJing();
		Scanner scanner = new Scanner(System.in);
		ShortestPath_DIJ1 dij = new ShortestPath_DIJ1();
		System.out.println("请输入出发点景点名称：");
		String string = scanner.next();
		System.out.println("请输入目标景点名称：");
		String string2 = scanner.next();
		dij.DIJ(G, getSignInformation.getVexsNode(string));;
		dij.display(G, string, string2);;
	}
	
	
	

	// 用于输出最短路径上的各个顶点及权值
	public void display(MGraph G,String string,String string2) throws Exception {
		int i = getSignInformation.getVexsNode(string2);
		if (D != null) {
			System.out.println(string + " 到 " + string2 + "的最短路径上及最短距离分别是：");
			for (int k = 0; k < P[i].length; k++) {
				int a = -1;
				int min = INFINITY;
				for (int j = 0; j < P[i].length; j++) {//依次找出离i最近的点，这样可以将路径按顺序输出
						if (D[j] < min && P[i][j]) {
							a = j;
							min = D[j];
						}
				}
				if(a!=-1){
					System.out.print(G.getVex(a) + "  ");
					P[i][a]=false;
				}
			}
			System.out.println("\n最短距离为： " + D[i]);
		}
	}
	
}
