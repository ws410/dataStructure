package ch03;

import java.util.Scanner;

public class SY3_Statck1 {
	public static void main(String[] args) throws Exception {
		SqStack sq=new SqStack(100);
		LinkStack ls=new LinkStack();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入栈的长度");
		int n=sc.nextInt();
		System.out.println("请输入栈中各元素值");
		for (int i = 0; i < n; i++) {
			int x=sc.nextInt();
			sq.push(x);
			ls.push(x);
		}
		System.out.println("\n建立的顺序栈中各元素的值为（从栈顶到栈底）");
		sq.display();
		System.out.println("\n建立的链栈中个元素值为（从栈顶到栈底）");
		ls.display();
		System.out.println("\n请输入待入栈的元素值");
		int e=sc.nextInt();
		sq.push(e);
		ls.push(e);
		System.out.println("\n入栈后的顺序栈中各元素值为（从栈顶到栈底）");
		sq.display();
		System.out.println("\n入栈后的链栈中各元素值为（从栈顶到栈底）");
		ls.display();
		System.out.println("\n删除栈顶元素后，顺序栈中各元素值为（从栈顶到栈底）");
		sq.pop();
		sq.display();
		System.out.println("\n删除栈顶元素后，链栈中各元素值为（从栈顶到栈底）");
		ls.pop();
		ls.display();
	}
}
