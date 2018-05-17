package com.flight.demo;

public class WaitingCustomer {
	@Override
	public String toString() {
		return ",  姓名：" + name + ",   订票数 :" + needTickets;
	}
	private String name;
	private int needTickets;
	public WaitingCustomer(String name, int needTickets) {
		super();
		this.name = name;
		this.needTickets = needTickets;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNeedTickets() {
		return needTickets;
	}
	public void setNeedTickets(int needTickets) {
		this.needTickets = needTickets;
	}
	
	
}
