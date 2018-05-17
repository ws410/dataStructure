package ch02;
import java.util.Scanner;
public class SY_2_LinkList {
  private static void creat(LinkList list){ 
	  Scanner sc=new Scanner(System.in);
	 System.out.println("请输入链表中各元素的值（以0结束）");
	 for(int x=sc.nextInt();x!=0;x=sc.nextInt()){
		 try {
			list.insert(0, x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
  }
  public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		LinkList list=new LinkList();
		creat(list);
		System.out.println("建立的单链表为：");
		list.display();
		System.out.println("请输入要插入的位置 i");
		int i=sc.nextInt();
		System.out.println("请输入要插入数据值 x");
		int x=sc.nextInt();
		list.insert(i, x);
		System.out.println("插入后的顺序为：");
		list.display();
		System.out.println("请输入待删除的元素位置");
		list.remove(sc.nextInt());
		System.out.println("删除后的链表为：");
		list.display();
		System.out.println("请输入待查找的数据元素的位序号：");
		int n=sc.nextInt();
		System.out.println("此单链表中第"+n+"个结点的数据元素值为"+list.get(n)  );
	}
}
