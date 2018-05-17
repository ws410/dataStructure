package ch03;

import java.util.Scanner;

import javax.xml.ws.EndpointContext;

public class SY3_4 {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入m的值：");
		int m = sc.nextInt();
		
		System.out.print("请输入n的值：");
		int n = sc.nextInt();
		int result=ack(m,n);
		System.out.println("计算结果为"+result);
	}
		/*方法分析：
		 * 参数列表：m,n（int）；
		 * 返回值类型：int
		 * */
	private static int ack(int m,int n) throws Exception{
		StackElem e;
		Stack s = new Stack(1000);
		e = new StackElem(m, n);
		s.push(e);
		do{
			while(s.getTop().mval !=0){
				while(s.getTop().nval != 0){
					e = new StackElem(s.getTop().mval,s.getTop().nval - 1);
					s.push(e);
				}
				s.setTop(s.getTop().mval-1, 1);
			}
			if(!s.isEmpty()){
				e = s.pop();
				s.setTop(s.getTop().mval - 1, e.nval + 1);
			}
		}while(s.length() != 1 || s.getTop().mval != 0);
		return s.getTop().nval + 1;
	}
}
