package ch09;

import java.util.Scanner;

import ch05.BiTreeNode;
public class SY_studentSortByBSTree {
	private static SY_studentNode[]stu;
	private static Scanner scanner=new Scanner(System.in);
	private static BSTree bt;
	public static void input(int n){
		stu=new SY_studentNode[n];
		System.out.println("please input number,name,english,math");
		for (int i = 0; i < stu.length; i++) {
			int num=scanner.nextInt();
			String name=scanner.next();
			double english=scanner.nextDouble();
			double math=scanner.nextDouble();
			stu[i]=new SY_studentNode(num, name, english, math);
			stu[i].setTotal(english+math);
		}
	}
	public static void insert(){
		bt=new BSTree();
		for (int i = 0; i < stu.length; i++) {
			bt.insertBST(new SY_keyNum(stu[i].getNum()), stu[i]);
		}
	}
	public static void searchStudent(){
		SY_keyNum keyValue=new SY_keyNum();
		System.out.println("please input student number what you need search");
		int stunum=scanner.nextInt();
		keyValue.num=stunum;
		Object searchBST = bt.searchBST(keyValue);
		if(searchBST==null){
			System.out.println("查找失败");
		}else{
			System.out.println(searchBST);
		}
	}
	public static void removeStudent(){
		SY_keyNum keyValue=new SY_keyNum();
		System.out.println("please input student number what you need remove");
		int stunum=scanner.nextInt();
		keyValue.num=stunum;
		Object searchBST = bt.searchBST(keyValue);
		if(searchBST==null){
			System.out.println("删除失败");
		}else{
			bt.removeBST(keyValue);
		}
	}
	public static void main(String[] args) {
		boolean flag=true;
		while (flag) {
			System.out.println("1-录入学生信息，2-展示学生信息，3-按学号查找学生，4-按学号删除学生,5-退出");
			int a=scanner.nextInt();
			switch (a) {
			case 1:
				System.out.println("please input student number");
				int n=scanner.nextInt();
				input(n);
				insert();
				break;
			case 2:
				bt.inOrderTraverse(bt.root);
				System.out.println("");
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				removeStudent();
				break;
			case 5:
				flag=false;
				break;
			}	
		}
	}
}
