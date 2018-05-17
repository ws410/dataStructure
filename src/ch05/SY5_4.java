package ch05;

import java.util.Scanner;
import ch05.exChang;
public class SY5_4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入先根遍历序列：");
		
		String preOrder = sc.next();// 先根遍历序列
		System.out.print("请输入中根遍历序列：");
		String inOrder = sc.next();// 中根遍历序列
		BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
		exChang.exChang1(T.getRoot());
		System.out.println("先根遍历后二叉树的镜像为（递归算法）：");
		T.preRootTraverse();
		System.out.println("");
		System.out.println("中根遍历后二叉树的镜像为（递归算法）：");
		T.inRootTraverse();
		System.out.println("");
		exChang.exChang2(T.getRoot());
		System.out.println("后根遍历后二叉树的镜像为（非递归算法）：");
		T.postRootTraverse();
		System.out.println("");
		System.out.println("中根遍历后二叉树的镜像为（非递归算法）：");
		T.inRootTraverse();
	}
}
