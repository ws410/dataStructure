package ch09;

public class SY_studentNode {
	private String name;
	private int num;
	private double english,math,total;
	
	public SY_studentNode(int num, String name, double english, double math) {
		super();
		this.num = num;
		this.name = name;
		this.english = english;
		this.math = math;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "name:" + name + ", num:" + num + ", english:" + english + ", math:" + math + ", total:"
				+ total;
	}
	
}
