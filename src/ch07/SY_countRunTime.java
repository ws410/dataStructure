package ch07;

public class SY_countRunTime {
	 static int maxSize = 10000;  //排序关键码个数

    public static void main(String[] args) throws Exception {
        int[] d = new int[maxSize];  //顺序表空间大小
        for (int i = 0; i < maxSize; i++) {
            d[i] = (int) (Math.random() * 100);
        }
        SeqList L;
        L = createList(d);
        System.out.println("直接插入排序所需时间：" + testSortTime(L, 'i') + "毫秒");
        L = createList(d);
        System.out.println("冒泡排序所需时间：" + testSortTime(L, 'b') + "毫秒");
        L = createList(d);
        System.out.println("快速排序所需时间：" + testSortTime(L, 'q') + "毫秒");
        L = createList(d);
        System.out.println("直接选择排序所需时间：" + testSortTime(L, 's') + "毫秒");
        L = createList(d);
        System.out.println("堆排序所需时间：" + testSortTime(L, 'h') + "毫秒");
    }

    private static SeqList createList(int[] d) throws Exception {
        SeqList L = new SeqList(maxSize);   //建立顺序表
        for (int i = 0; i < d.length; i++) {
            RecordNode r = new RecordNode(d[i]);
            L.insert(L.length(), r);
        }
        return L;
    }

    public static long testSortTime(SeqList L, char sortmethod) {

        long startTime, endTime, testTime;
        startTime = System.currentTimeMillis();
        switch (sortmethod) {
            case 'i':
                L.insertSort();     //直接插入排序
                break;
            case 's':
                L.selectSort();     //选择排序
                break;
            case 'b':
                L.bubbleSort();     //冒泡排序
                break;
            case 'q':
                L.quickSort();      //快速排序
                break;
            case 'h':
                L.heapSort();       //堆排序
                break;
        }
        endTime = System.currentTimeMillis();
        testTime = endTime - startTime;
        return testTime;
    }
}
