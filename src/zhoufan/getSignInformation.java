package zhoufan;



import ch06.GraphKind;
import ch06.MGraph;

public class getSignInformation {
	public final static int IF = Integer.MAX_VALUE;
	public final static Object vexs[] = { "小东门", "大东门","一餐","图书馆", "综合楼",
			"工学馆", "东操场", "六餐", "南门" ,"大学会馆","小南门","西操场","鹏远餐厅" };
	public final static Object SignInformation[] = { "小东门信息……", "大东门信息……","一餐信息……","图书馆信息……", "综合楼信息……",
			"工学馆信息……", "东操场信息……", "六餐信息……", "南门信息……" ,"大学会馆信息……","小南门信息……","西操场信息……","鹏远餐厅信息……" };
	public static void AskSignInformation(String IN) {
		for(int i = 0; i<vexs.length;i++)
			if(vexs[i].equals(IN)){
				System.out.println("查询的地点的信息为：" + SignInformation[i]);
				break;		 
			}
	}
	public static MGraph getLuJing() throws Exception {
		int[][] arcs = {{0 ,20,15,IF,IF,IF,IF,IF,IF,IF,IF,IF,IF},
						{20,0 ,IF,IF,5 ,IF,IF,IF,IF,IF,IF,IF,IF},
						{15,IF,0 ,50,IF,10,IF,IF,IF,IF,IF,IF,IF},
						{IF,IF,50,0 ,5 ,IF,40,IF,IF,IF,IF,IF,IF},
						{IF,5 ,IF,5 ,0 ,IF,IF,50,IF,IF,IF,IF,IF},
						{IF,IF,10,IF,IF,0 ,IF,IF,IF,15,IF,IF,50},
						{IF,IF,IF,40,IF,IF,0 ,5 ,IF,20,IF,IF,IF},
						{IF,IF,IF,IF,50,IF,5 ,0 ,5 ,IF,15,IF,IF},
						{IF,IF,IF,IF,IF,IF,IF,5 ,0 ,IF,20,IF,IF},
						{IF,IF,IF,IF,IF,15,20,IF,IF,0 ,IF,20,IF},
						{IF,IF,IF,IF,IF,IF,IF,15,20,IF,0 ,15,IF},
						{IF,IF,IF,IF,IF,IF,IF,IF,IF,20,15,0 ,60},
						{IF,IF,IF,IF,IF,50,IF,IF,IF,IF,IF,60,0 },};
		MGraph NEUQ = new MGraph(GraphKind.DN, 13, 18, vexs, arcs);//构建校园平面图
		return NEUQ;
	}
	
	public static int getVexsNode(String IN) {
		for(int i = 0; i<vexs.length;i++)
			if(vexs[i].equals(IN)){
				return i;
			}
		return -1;
	}
}
