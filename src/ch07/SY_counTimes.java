package ch07;

import ch02.LinkList;
@SuppressWarnings(value = { "all" })
public class SY_counTimes {
	public RecordNode[] r;    //顺序表记录结点数组
	public int curlen;
	public static SY_CopareMoveNum cm[];
	public SY_counTimes(int MaxSize) {
		this.r = new RecordNode[MaxSize];
		this.cm = new SY_CopareMoveNum[10];
	}
	public int length() {
	        return curlen; // 返回顺序表的当前长度
	}
	public void insert(int i, RecordNode x) throws Exception {
	    if (curlen == r.length) {    // 判断顺序表是否已满
	        throw new Exception("顺序表已满");
	    }
	    if (i < 0 || i > curlen) {  // i小于0或者大于表长
	        throw new Exception("插入位置不合理");
	    }
	    for (int j = curlen; j > i; j--) {
	        r[j] = r[j - 1];   // 插入位置及之后的元素后移
	    }
	    r[i] = x;   // 插入x
	    this.curlen++;  // 表长度增1
	 }
	
	public void bubbleSort(){
		cm[0]=new SY_CopareMoveNum();
		RecordNode temp;       //辅助结点
	    boolean flag = true;   //是否交换的标记
	    for (int i = 1; i < this.curlen && flag; i++) { //有交换时再进行下一趟，最多n-1趟
	        flag = false;
	        for (int j = 0;j<this.length() - i;j++){
	        	if(r[j].getKey().compareTo(r[j + 1].getKey())>0){
	        		cm[0].setCpn(cm[0].getCpn() + 1);
	        		temp = r[j];
	        		r[j] = r[j + 1];
	        		r[j + 1] = temp;
	        		flag = true;
	        		cm[0].setMvn(cm[0].getMvn() + 3);
	        	}
	        }
	     }
    }
	
	public int Partition(int i, int j) {
		cm[1]=new SY_CopareMoveNum();
        RecordNode pivot = r[i];          //第一个记录作为支点记录
        cm[1].setMvn(cm[1].getMvn() + 1);
        while (i < j) {    //从表的两端交替地向中间扫描
            while (i < j && pivot.getKey().compareTo(r[j].getKey())<= 0) {
                j--;
                cm[1].setCpn(cm[1].getCpn() + 1);
            }
            if (i < j) {
                r[i] = r[j];   //将比支点记录关键字小的记录向前移动
                i++;
                cm[1].setMvn(cm[1].getMvn() + 1);
            }
            while (i < j && pivot.getKey().compareTo(r[i].getKey())>0) {
                i++;
                cm[1].setCpn(cm[1].getCpn() + 1);
            }
            if (i < j) {
                r[j] = r[i];   //将比支点记录关键字大的记录向后移动
                j--;
                cm[1].setMvn(cm[1].getMvn() + 1);
            }
        }
        r[i] = pivot;         //支点记录到位
        cm[1].setMvn(cm[1].getMvn() + 1);
        return i;             //返回支点位置
	}
	
	public void displayTimes(char c){
		switch (c) {
		case 'b':
			System.out.println("冒泡排序的比较次数为："+cm[0].getCpn()+"\t"+"移动次数为："+cm[0].getMvn());
			break;
		case 'p':
			System.out.println("一趟快速排序的比较次数为："+cm[1].getCpn()+"\t"+"移动次数为："+cm[1].getMvn());
			break;
		}
	}
}
