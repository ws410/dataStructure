package ch02;

import java.util.Scanner;

public class SY_2_2DoLinkList {
	public static void main(String[] args) {
		DuLinkList list=new DuLinkList();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入双链表的长度：");
		int n=sc.nextInt();
		creatDuLinkList(list, n);
		list.display();
		move(list);
		System.out.println("移动后结果为：");
		list.display();
	
	}
	public static void creatDuLinkList(DuLinkList list, int n){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入双向链表中各元素的值：");
		for (int i = 0; i < n; i++) {
			try {
				list.insert(i, sc.nextInt());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void move(DuLinkList list){
		Object temp;
		DuLNode p=list.getHead().next;
		DuLNode q=list.getHead().prior;
		if (!list.isEmpty()) {
			while(!p.equals(q)){
				while(!p.equals(q)&&(Integer)p.data>0){
					p=p.next;
				}
				while (!p.equals(q)&&(Integer)q.data<0) {
					q=q.prior;
				}
				if (!p.equals(q)) {
					temp=p.data;
					p.data=q.data;
					q.data=temp;
					if(p.next.equals(q)){
						p=q;
					}else{
						p=p.next;
						q=q.prior;
					}
				}
			}
		}
	}
}
