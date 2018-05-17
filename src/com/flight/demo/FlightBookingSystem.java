package com.flight.demo;
import ch02.LinkList;
import ch02.Node;
import ch02.SqList;
import ch03.LinkQueue;

public class FlightBookingSystem {
	static SqList list1=new SqList(100);
	static LinkList list2=new LinkList();
	static LinkQueue queue=new LinkQueue();
	public static void setRoute() throws Exception{
		FlightInformation node1= new FlightInformation(1001, "上海", "周一", 5, 3,list2);
		FlightInformation node2= new FlightInformation(1002, "上海", "周二", 5, 2,list2);
		FlightInformation node3= new FlightInformation(1003, "上海", "周三", 5, 3,list2);
		FlightInformation node4= new FlightInformation(1004, "上海", "周四", 5, 2,list2);
		FlightInformation node5= new FlightInformation(1005, "上海", "周五", 5, 3,list2);
		list1.insert(list1.length(), node1);
		list1.insert(list1.length(), node2);
		list1.insert(list1.length(), node3);
		list1.insert(list1.length(), node4);
		list1.insert(list1.length(), node5);
		Customer cu1=new Customer(1001,"张三", 2, 3);
		Customer cu2=new Customer(1001,"李四", 1, 2);
		Customer cu3=new Customer(1001,"王五", 1, 3);
		Customer cu4=new Customer(1002,"王6", 1, 3);
		list2.insert(list2.length(), cu1);
		list2.insert(list2.length(), cu2);
		list2.insert(list2.length(), cu3);
		list2.insert(list2.length(), cu4);
		WaitingCustomer wcu1=new WaitingCustomer("李白", 2);
		WaitingCustomer wcu2=new WaitingCustomer("杜甫", 1);
		WaitingCustomer wcu3=new WaitingCustomer("白居易",3);
		queue.offer(wcu1);
		queue.offer(wcu2);
		queue.offer(wcu3);	
	}
	public static void queryRoute(String terminal) throws Exception{
		for (int i = 0; i < list1.length(); i++) {
				FlightInformation node=(FlightInformation) list1.get(i);
				if(node.getTerminal().equals(terminal)){
					int num=node.getFlightNum();
					System.out.println("航班号： " + node.getFlightNum() + " 终点站：" + node.getTerminal()
					+ "    飞行周日： " + node.getFlightWeek() + "   总票数：" + node.getTotalTicket()
					+ " 余票数： " + node.getResidualTicket());
					for (int j = 0; j <node.getList().length(); j++) {
						Customer cus=(Customer)(node.getList().get(j));
						if(cus.getFlightNum()==num){
							System.out.println(cus);
						}else{
							/*System.out.println("");*/
						}
					}
				}
		}
	}
	public static void querycus(int flightNum) throws Exception{
		for (int i = 0; i <list1.length(); i++) {
			if((list1.get(i).equals(list2.head))){
				Node node=(Node) list1.get(i);
				Customer cus=(Customer) node.data;
				System.out.println(cus);
				while(node!=null){
					if(flightNum==cus.getFlightNum()){
						System.out.println(node.data+" ");
						node=node.next;
					}
					
				}
			}
		}
	}
	public static void bookingTicket(int flightNum,int tickets) throws Exception{
		for (int i = 0; i <list1.length(); i++) {
			if(!(list1.get(i).equals(list2.head))){
				FlightInformation node=(FlightInformation) list1.get(i);
				if(node.getFlightNum()==flightNum && node.getResidualTicket()>tickets)
					node.setResidualTicket(node.getResidualTicket()-tickets);
			}
		}
		WaitingCustomer was=(WaitingCustomer) queue.poll();
		System.out.println("其中已购票的乘客航班数为： "+flightNum+""+was+", 舱位："+3);
	}
	public static void main(String[] args) throws Exception {
	setRoute();
	queryRoute("上海");
	
	
	}
}
