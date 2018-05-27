package ch07;
public class SY_DebugCounTimes {
	static int maxSize = 10;
	public static void main(String[] args) throws Exception {
		int[] d = new int[maxSize];  //顺序表空间大小
        for (int i = 0; i < maxSize; i++) {
            d[i] = (int) (Math.random() * 100);
        }
        SY_counTimes sc;
        sc=createList(d);
        runMethod(sc, 'b');
        sc.displayTimes('b');
        sc=createList(d);
        runMethod(sc, 'p');
        sc.displayTimes('p');      
	}
	private static SY_counTimes createList(int[] d) throws Exception {
        SY_counTimes L = new SY_counTimes(maxSize);   //建立顺序表
        for (int i = 0; i < d.length; i++) {
            RecordNode r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }
        return L;
    }
	public static void runMethod(SY_counTimes sct,char methType){
		switch (methType) {
		case 'b':
			sct.bubbleSort();
			break;
		case 'p':
			sct.Partition(1, 5);
			break;
		}
	}
}
