package ch02;

import java.util.Scanner;

public class SX1_2_Test {
	public static void main(String[] args) throws Exception {
		SqList list1=new SqList(20);
		creatList(list1,1);
		SqList list2=new SqList(20);
		creatList(list2,2);
		SqList list3=new SqList(20);
		creatList(list3,3);
		deletePublic(list1, list2, list3);
		System.out.println("删除后A中元素为");
		list1.display();
		
		
		
        
		
	}
	private static void creatList(SqList list,int n) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入顺序表"+n+"的长度");
		int len=sc.nextInt();
		System.out.println("请输入存储的元素");
		for (int i = 0; i <len; i++) {
			list.insert(i, sc.nextInt());
		}
		System.out.println("排序后是");
		insertSort(list);
		list.display();
	}
	public static void insertSort(SqList list){
		for (int i = 0; i < list.length(); i++) {
			for (int j = i; j >0; j--) {
				try {
					if((Integer)list.get(j)<(Integer)list.get(j-1)){
						int temp=(int) list.get(j-1);
						list.remove(j-1);
						list.insert(j, temp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void deletePublic(SqList A,SqList B,SqList C)throws Exception{
		int i=0,j=0,k=0;
		while (j<B.length()&& k<C.length()) {
			if((Integer)B.get(j)<(Integer)C.get(k)){
				j++;
			}else if((Integer)B.get(j)>(Integer)C.get(k)){
				k++;
			}else{
				while(i<A.length()&&(Integer)A.get(i)<(Integer)B.get(j)){
					i++;
				}
				if(i<A.length()&&(Integer)A.get(i)==(Integer)B.get(j)){
					A.remove(i);
				}
				j++;
				k++;
			}
		}
	}
//	public static void deletePublic(SqList list1,SqList list2,SqList list3) throws Exception{
//		for (int i = 0; i < list1.length(); i++) {
//			for (int j = 0; j <list2.length(); j++) {
//				if((Integer)list1.get(i)==(Integer)list2.get(j)){
//					list1.remove(i);
//				}
//			}	
//		}
//	}
}
