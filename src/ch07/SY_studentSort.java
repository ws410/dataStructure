package ch07;

import java.util.Scanner;

public class SY_studentSort {
	private SeqList list;
	private Scanner scanner;
	private SY_student[]stu;
	
	
	public SY_studentSort() throws Exception {
		scanner=new Scanner(System.in);
		System.out.println("please input student number");
		int number=scanner.nextInt();
		input(number);
	
		list=new SeqList(number);
		for (int i = 0; i < stu.length; i++) {
			RecordNode r=new RecordNode(new SY_keyTotal(stu[i].getTotal()),stu[i]);
			list.insert(list.length(), r);
		}
		
		System.out.println("befor of sort"+"\n");
		output();
		System.out.println("behand of sort");
//		list.insertSort();
		list.insertSortDesc();
		System.out.println("The result is based on the total score descending "+"\n");
		output();
	}

	public void input(int n){
		stu=new SY_student[n];
		System.out.println("please input number,name,english,math");
		for (int i = 0; i < stu.length; i++) {
			String num=scanner.next();
			String name=scanner.next();
			double english=scanner.nextDouble();
			double math=scanner.nextDouble();
			stu[i]=new SY_student(num, name, english, math);
			stu[i].setTotal(english+math);
		}
		
	}
	public void output(){
		System.out.println("number"+"\t"+"name"+"\t"+"english"+"\t"+"math"+"\t"+"total");
		for (int i = 0; i < stu.length; i++) {
			SY_student s=(SY_student)list.r[i].element;
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getEnglish()+"\t"+s.getMath()+"\t"+s.getTotal());
		}
		System.out.println("\n");
	}
	public static void main(String[] args) throws Exception {
		SY_studentSort s=new SY_studentSort();
	}
}
