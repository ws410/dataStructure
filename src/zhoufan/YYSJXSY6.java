package zhoufan;



import java.util.Scanner;

import ch06.GraphKind;
import ch06.MGraph;

public class YYSJXSY6 {
	
		
	public static void main(String[] args) throws Exception {
		boolean b=true;
		Scanner scanner = new Scanner(System.in);
		while(b){
			System.out.println("查询校内景点信息请输入1\n查询路径请输入2\n退出请输入3：");
			int i = scanner.nextInt();
			switch (i) {
			case 1:
				System.out.println("请输入要查询的地点：");
				String IN = scanner.next();
				getSignInformation.AskSignInformation(IN);
				break;
			case 2:
				ShortestPath_DIJ1.main(args);
				break;
			case 3:
				System.out.print("");
				return;
			}
		}
	}

}
