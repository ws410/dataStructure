package ch07;

public class SY_keyTotal implements Comparable<SY_keyTotal> {
	private double totalScore;   //关键字
    public SY_keyTotal(double totalScore) {
		this.totalScore = totalScore;
	}

	public String toString() { //覆盖toString()方法
        return totalScore + " ";
    }
	
	@Override
	public int compareTo(SY_keyTotal another) {
		double thisVal = this.totalScore;
        double anotherVal = another.totalScore;
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
}
