package ch02;

public class SY_2_3JosephProblem {
	public static void main(String[] args) {
		LinkList list=josephProblem(30, 15);
		System.out.println("生者号数为：");
		list.display();
	}
	public static LinkList josephProblem(int totalNum,int cycleNum){
		LinkList list=new LinkList();
		for (int i = 1; i <=totalNum; i++) {
			list.insert(i);
		}
		int count=1;
		for (int i = 0;list.length()!=totalNum/2; i++) {
			if(i==list.length()){
				i=0;
			}
			if(count%cycleNum==0){
				try {
					list.remove(i--);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
		}
		return  list;
	}
}
