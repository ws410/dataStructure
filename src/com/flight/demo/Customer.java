package com.flight.demo;

public class Customer {
	private int flightNum;//航班号
	private String name;
	private int tickets;
	private int space;
	
	
	
	public Customer(int flightNum, String name, int tickets, int space) {
		super();
		this.flightNum = flightNum;
		this.name = name;
		this.tickets = tickets;
		this.space = space;
	}
	
	
	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "  姓名： " + name + ",   订票数：" + tickets + ", 舱位：" + space;
	}
	
}
