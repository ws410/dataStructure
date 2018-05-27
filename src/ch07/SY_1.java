package ch07;

public class SY_1 extends SeqList{
	static int maxSize=20;
	public SY_1(int maxSize) {
		super(maxSize);
	}
	private static SeqList createList(int[]d) throws Exception{
		SeqList L = new SY_1(maxSize);   //建立顺序表
        for (int i = 0; i < d.length; i++) {
            RecordNode r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }
        return L;
	}
	public void display(){
		for (int i = 0; i < this.length(); i++) {
			System.out.print(" "+getRecord()[i].getKey().toString());
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		int d[]=new int[maxSize];
		for (int i = 0; i < d.length; i++) {
			d[i]=(int) (Math.random()*100);
		}
		SeqList l=createList(d);
		System.out.println("排序前：");
		l.display();
		l.insertSortWithGuard();
		System.out.println("排序后：");
		l.display(9);
	}
}
