package ch09;

import java.util.Scanner;

public class SY_8_1 {
	public static void main(String[] args) {
		BSTree bstree=new BSTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入二叉排序树的结点个数");
		int n=sc.nextInt();
		System.out.println("请输入节点关键字序列");
		for (int i = 0; i < n; i++) {
			int a=sc.nextInt();
			bstree.insertBST(a,a);
		}
		System.out.println("\n创建的二叉排序树的中序遍历为：  ");
		bstree.inOrderTraverse(bstree.root);
		System.out.println();
		System.out.println("请输入要删除的结点");
		int b=sc.nextInt();
		bstree.removeBST(b);
		System.out.println("\n删除指定结点后的二叉排序树的中序遍历为：  ");
		bstree.inOrderTraverse(bstree.root);
	}
}
