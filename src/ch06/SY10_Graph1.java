package ch06;

public class SY10_Graph1 {
	public static void main(String[] args) throws Exception {
		MGraph g=new MGraph();
		g.createGraph();
		System.out.println("图的广度遍历序列为：");
		BTraverser.BFSTraverse(g);;
		System.out.println("\n"+"图的深度遍历序列为：");
		DTraverser.DFSTraverse(g);
	}
}
