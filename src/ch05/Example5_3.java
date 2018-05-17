package ch05;

/**
 * 
 * 【例5-3】 编写成员函数完成求二叉树的深度
 */

public class Example5_3 {

	public int getDepth(BiTreeNode T) {
		if (T != null) {
			int lDepth = getDepth(T.lchild);// 左子树的深度
			int rDepth = getDepth(T.rchild);// 右子树的深度
			return 1 + (lDepth > rDepth ? lDepth : rDepth);// 返回左子树的深度和右子树的深度中的最大值加1
		}
		return 0;
	}
	
  //  采用递归模型方法，计算二叉树的深度
	public int getDepth1(BiTreeNode T) {
		if (T==null) 
			return 0;
		else if (T.lchild==null&&T.rchild==null)
			return 1;
		else 
			return 1 + (getDepth1(T.lchild)> getDepth1(T.rchild)? getDepth1(T.lchild) : getDepth1(T.rchild));
	}
	
	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();// 创建一棵树
		BiTreeNode root = biTree.getRoot();// 取得树的根结点

		Example5_3 e = new Example5_3();
		System.out.println("树中的深度为： " + e.getDepth(root));
		System.out.println("树中的深度为： " + e.getDepth1(root));
	}
}
// 运行结果：
// 树中的深度为： 5
//树中的深度为： 5
