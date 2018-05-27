package ch09;

public class SY_keyNum implements Comparable<SY_keyNum> {
	int num;  //关键字
	public SY_keyNum() {
	}
    public SY_keyNum(int num) {
		this.num = num;
	}

	public String toString() { //覆盖toString()方法
        return num + " ";
    }
	
	@Override
	public int compareTo(SY_keyNum another) {
		double thisVal = this.num;
        double anotherVal = another.num;
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
}
