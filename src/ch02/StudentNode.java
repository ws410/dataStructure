package ch02;

import java.util.Scanner;

/**
 * 
 * 学生成绩查询系统的结点,作为顺序表的数据元素(listElem[i])
 * 
 */
public class StudentNode {
	public int number; // 学号

	public String name; // 姓名

	public String sex; // 性别

	public double english; // 大学英语成绩

	public double math; // 高等数学成绩
	
	public double phone;//电话号码
	
	public String addr;//地址

	
	public StudentNode(int number, String name, String sex, double english, double math, double phone, String addr) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.english = english;
		this.math = math;
		this.phone = phone;
		this.addr = addr;
	}

	public StudentNode(Scanner sc) {
		this(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc
				.nextDouble(),sc.nextDouble(),sc.next());
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
