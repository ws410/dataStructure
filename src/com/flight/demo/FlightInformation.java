package com.flight.demo;

import ch02.LinkList;

public class FlightInformation {
	private int flightNum;//航班号
	private String terminal;//终点站
	private String flightWeek;//飞行周日
	private int totalTicket;//总票数
	private int residualTicket;//余票数
	private LinkList list;
	
	public FlightInformation(int flightNum, String terminal, String flightWeek, int totalTicket, int residualTicket,
			LinkList list) {
		super();
		this.flightNum = flightNum;
		this.terminal = terminal;
		this.flightWeek = flightWeek;
		this.totalTicket = totalTicket;
		this.residualTicket = residualTicket;
		this.list = list;
	}
	public LinkList getList() {
		return list;
	}
	public void setList(LinkList list) {
		this.list = list;
	}
	public int getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getFlightWeek() {
		return flightWeek;
	}
	public void setFlightWeek(String flightWeek) {
		this.flightWeek = flightWeek;
	}
	public int getTotalTicket() {
		return totalTicket;
	}
	public void setTotalTicket(int totalTicket) {
		this.totalTicket = totalTicket;
	}
	public int getResidualTicket() {
		return residualTicket;
	}
	public void setResidualTicket(int residualTicket) {
		this.residualTicket = residualTicket;
	}
	@Override
	public String toString() {
		return "flightNum=" + flightNum + ", terminal=" + terminal + ", flightWeek=" + flightWeek
				+ ", totalTicket=" + totalTicket + ", residualTicket=" + residualTicket ;
	}
	
	
	
	
	
}
