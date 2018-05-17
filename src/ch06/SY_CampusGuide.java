package ch06;

import java.util.Scanner;
public class SY_CampusGuide {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入开始景点代号（0-正校门, 1-东校门, 2-西校门, 3-北校门, 4-食堂, 5-磁悬浮列车实验室,6-樱花大道,7-图书馆,8-体育场,9-体育馆,10-游泳馆,11-礼堂,12-教学楼,13-宿舍）");
		Scanner sc=new Scanner(System.in);
		int start=sc.nextInt();
		System.out.println("请输入结束景点代号（0-正校门, 1-东校门, 2-西校门, 3-北校门, 4-食堂, 5-磁悬浮列车实验室,6-樱花大道,7-图书馆,8-体育场,9-体育馆,10-游泳馆,11-礼堂,12-教学楼,13-宿舍）");
		int end=sc.nextInt();
		MGraph G = SY_CampusRoadmap.getCampusRoadmap();
		SY_ShortPath_DIJ dij=new SY_ShortPath_DIJ();
		dij.DIJ(G, start);
		dij.display(G,end);
	}
}
