package ch06;


public class SY_ShortPath_DIJ {
	private boolean[][] P;// v0到其余顶点的最短路径, 若P[v][w]为true，则w是从v0到v当前求得最短路径上的顶点
	private int[] D;// v0到其余顶点的带权长度
	public final static int INFINITY = Integer.MAX_VALUE;
	// 用Dijkstra算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其权值D[v]
	public void DIJ(MGraph G, int start) throws Exception {
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];// finish[v]为true当且仅当v属于S,即已经求得从v0到v的最短路径
		for (int v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[start][v];
			for (int w = 0; w < vexNum; w++)
				P[v][w] = false;// 设空路径
			if (D[v] < INFINITY) {
				P[v][start] = true;
				P[v][v] = true;
			}
		}

		D[start] = 0;// 初始化，v0顶点属于S集
		finish[start] = true;
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
	// 用于输出最短路径上的各个顶点及权值
	public void display(MGraph G,int end ) throws Exception {
		if (D != null) {
			System.out.println("两景点的最短路线和最短距离为：");
			StringBuffer str=new StringBuffer("");
			for (int i = 0; i < P.length; i++) {
				if(G.getVex(i).equals(G.getVex(end))){
					for (int j = 0; j < P[i].length; j++) {
						if (P[i][j]){
							String str1=G.getVex(j) + "---";
							str= str.append(str1);
						}
					}
					System.out.println(str.substring(0, str.length()-3));
					System.out.println("最短距离为： " + D[i]);
				}
			}
		}
	}
	public int[] getD() {
		return D;
	}

	public boolean[][] getP() {
		return P;
	}
	
	
}
