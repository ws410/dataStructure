package ch07;

public class SY_SqlistEnt extends SeqList{
	public SY_CopareMoveNum cm[];
	public RecordNode[] r;    //顺序表记录结点数组
    public int curlen;  
    public RecordNode[] getRecord() {
        return r;
    }
    public void setRecord(RecordNode[] r) {
        this.r = r;
    }
	@Override
	public void bubbleSort() {	
	}
	@Override
	public int Partition(int i, int j) {
		RecordNode pivot = r[i];          //第一个记录作为支点记录
        cm[1].setMvn(cm[1].getMvn() + 1);
        while (i < j) {    //从表的两端交替地向中间扫描
            while (i < j && pivot.getKey().compareTo(getRecord()[j].getKey())<= 0) {
                j--;
                cm[i].setCpn(cm[1].getCpn() + 1);
            }
            if (i < j) {
                getRecord()[i] = getRecord()[j];   //将比支点记录关键字小的记录向前移动
                i++;
                cm[1].setMvn(cm[1].getMvn() + 1);
            }
            while (i < j && pivot.getKey().compareTo(getRecord()[i].getKey())>0) {
                i++;
                cm[i].setCpn(cm[1].getCpn() + 1);
            }
            if (i < j) {
                getRecord()[j] = getRecord()[i];   //将比支点记录关键字大的记录向后移动
                j--;
                cm[1].setMvn(cm[1].getMvn() + 1);
            }
        }
        getRecord()[i] = pivot;         //支点记录到位
        cm[1].setMvn(cm[1].getMvn() + 1);
        return i;             //返回支点位置
	}
	
}
