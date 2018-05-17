package ch06;

import java.util.Scanner;
public class SY_newGetPath {
   public static int[][] arcs;	//表示邻接矩阵
   public static int[] shortPath;//存放从start到其他各点的最短路径  
   public static String[] path; //存放从start到其他各点的最短路径的字符串表示  
	public final static int INFINITY = Integer.MAX_VALUE;
   /**
    * 得到最短路径
    * @param G
    * @param start
    * @return int[]
    * @throws Exception
    * @author 顺
    */
    public static int[] Dijsktra( MGraph G ,int start) throws Exception{  
    	arcs=G.getArcs();
        int vexNum = arcs.length;   
        shortPath = new int[vexNum];  
        path=new String[vexNum];  
        for(int i=0;i<vexNum;i++){
        	path[i] = G.getVex(start) + "-->" + G.getVex(i);  
        }  
        //标记当前该顶点的最短路径是否已经求出,1表示已求出  
        int[] visited = new int[vexNum];  
        shortPath[start] = 0;  
        visited[start] = 1;  
        for(int count = 1;count <= vexNum - 1;count++){  
            //选出一个距离初始顶点start最近的未标记顶点  
            int k = -1;  
            int min =INFINITY ; 
            for(int i = 0;i < vexNum;i++){  
                if(visited[i] == 0 && arcs[start][i] <min){  
                    min = arcs[start][i];  
                    k = i;  
                }  
            }  
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是min  
            shortPath[k] = min;  
            visited[k] = 1;  
            //以k为中间点，修正从start到未访问各点的距离  
            for(int i = 0;i < vexNum;i++){  
                if(visited[i] == 0 && arcs[start][k] + arcs[k][i] < arcs[start][i]&& arcs[k][i] < INFINITY){  
                    arcs[start][i] = arcs[start][k] + arcs[k][i];  
                    path[i]=path[k]+"-->"+G.getVex(i); 
                }  
            }  
        }  
        return shortPath;  
    }
    /**
     * 打印最短路径
     * @param G
     * @param start
     * @param end
     * @throws Exception
     * @author 顺
     */
    public static void displayPath(MGraph G ,int start,int end) throws Exception{
    	 int[] shortPath = Dijsktra(G,start);  
	     for(int i = 0;i < shortPath.length;i++){  
	    	 if(G.getVex(i).equals(G.getVex(end))){
	    		 System.out.println("从"+G.getVex(start)+"出发到"+G.getVex(i)+"的最短距离为："+shortPath[i]);
	    		 System.out.println("从"+G.getVex(start)+"出发到"+G.getVex(i)+"的最短路径为："+path[i]); 
	    	 }
		 }  
	}
    public static void main(String[] args) throws Exception { 
 	   MGraph G = SY_CampusRoadmap.getCampusRoadmap();
 	   Scanner sc=new Scanner(System.in);
 	   System.out.println("请分别输入开始景点和目标景点");
 	   String start=sc.nextLine();
 	   String end=sc.nextLine();
 	   int s=G.locateVex(start);
 	   int e=G.locateVex(end);
        displayPath(G, s, e);
    }
}
