package ch06;

public class GenerateGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	public static MGraph generateMGraph() {
		Object vexs[] = { "v0", "v1", "v2", "v3", "v4", "v5" };
		int[][] arcs = { { 0, INFINITY, 10, INFINITY, 30, 100},
				{ INFINITY, 0, 5, INFINITY, INFINITY, INFINITY }, 
				{ INFINITY, INFINITY, 0, 50, INFINITY, INFINITY },
				{ INFINITY, INFINITY, INFINITY, 0, INFINITY, 10 },
				{ INFINITY, INFINITY, INFINITY, 20, 0, 60 },
				{ INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 0 } };
		MGraph G = new MGraph(GraphKind.UDG, 6, 8, vexs, arcs);
		return G;
	}

	public static ALGraph generateALGraph() {
		ArcNode v12 = new ArcNode(1, 6);
		ArcNode v13 = new ArcNode(2, 4, v12);
		ArcNode v14 = new ArcNode(3, 5, v13);
		VNode v1 = new VNode("v1", v14);

		ArcNode v25 = new ArcNode(4, 1);
		VNode v2 = new VNode("v2", v25);

		ArcNode v35 = new ArcNode(4, 1);
		VNode v3 = new VNode("v3", v35);

		ArcNode v46 = new ArcNode(5, 2);
		VNode v4 = new VNode("v4", v46);

		ArcNode v57 = new ArcNode(6, 9);
		ArcNode v58 = new ArcNode(7, 7, v57);
		VNode v5 = new VNode("v5", v58);

		ArcNode v68 = new ArcNode(7, 4);
		VNode v6 = new VNode("v6", v68);

		ArcNode v79 = new ArcNode(8, 2);
		VNode v7 = new VNode("v7", v79);

		ArcNode v89 = new ArcNode(8, 4);
		VNode v8 = new VNode("v8", v89);

//		ArcNode v91 = new ArcNode(0, 6);
		VNode v9 = new VNode("v9");

		VNode[] vexs = { v1, v2, v3, v4, v5, v6, v7, v8, v9 };
		ALGraph G = new ALGraph(GraphKind.DG, 9, 11, vexs);
		return G;
	}
}
