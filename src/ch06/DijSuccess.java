package ch06;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijSuccess {
public static int INFINITY =Integer.MAX_VALUE;
    public static Map<String,Vertex> vertexMap = new HashMap<String,Vertex>();
   
    //边距
    static class Edge{
        public Vertex dest;
        public double cost;
        public Edge(Vertex d,double c){
            this.dest = d;
            this.cost = c;
        }
    }
   
    //静态类：Vertex
    static class Vertex implements Comparable<Vertex>{
        public String name;
        public List<Edge> adj;
        public double dist;
        public Vertex prev;
        public int scratch;
        public boolean visited;
        public Vertex(String nm){
            this.name = nm;
            adj = new ArrayList<Edge>();
            reset();
        }
        public void reset(){
            visited = false;
            dist=DijSuccess.INFINITY;
        }
        @Override
        public int compareTo(Vertex o) {
            double c = o.dist;
           
            return dist < c ? -1:dist > c ? 1:0;
        }
       
    }
   
    //dijkstra算法实现:找到从startName点出发，到其他所有点的最短路径:选取自己定义的终点
    public static void dijkstra(String startName,String endName){
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();//该队列以权值升序排列，因为Vertex实现Comparable接口
        Vertex start = vertexMap.get(startName);
        start.dist = 0;
        for(Vertex v:vertexMap.values())
            pq.add(v);
        int seenNum = 0;
        while(!pq.isEmpty()&&seenNum < vertexMap.size()){
            Vertex v = pq.remove();
            if(v.name.equals(endName)){   //恰好是自己要找的那个点
            System.out.println(startName + "---->" + v.name + ":" + v.dist);
            System.out.println(getPreNames(v));
            break;
           
            }
            if(v.scratch != 0)
                continue;
            v.scratch = 1;
            seenNum++;
           
            for(Edge e:v.adj){
                Vertex w = e.dest;
                double v_to_w = e.cost;
                if(w.dist > v.dist + v_to_w){
                    w.dist = v.dist + v_to_w;
                    w.prev = v;
                    pq.remove(w);//出队
                    pq.add(w);//按优先级插在队头，先插入的在队头，依次往后
                   
                }
            }
        }
    }
   
    /**
     * 得到最短路径所经历的路线
     * @param v
     * @return
     */
    public static String getPreNames(Vertex v){
    String routeEndName = v.name;
    StringBuilder sb = new StringBuilder();
        while(v.prev != null){
        sb.append(v.prev.name + ",");
        v = v.prev;
        }
        String reverseRoute = routeEndName + "," + sb.toString();
        String[] reverseArray = reverseRoute.split(",");
        StringBuilder route = new StringBuilder();
       
        for(int i=0;i<reverseArray.length;i++){
        route.append(reverseArray[reverseArray.length-1-i]);
        route.append(",");
        }
    return route.substring(0, route.length()-1);
    }
    public static void main(String[] args){
    	Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("v5");
        
        List<Edge> e0l = v0.adj;
        List<Edge> e1l = v1.adj;
        List<Edge> e2l = v2.adj;
        List<Edge> e3l = v3.adj;
        List<Edge> e4l = v4.adj;
        List<Edge> e5l = v5.adj;
        
        Edge e02 = new Edge(v2,10);
        Edge e04 = new Edge(v4,30);
        Edge e05 = new Edge(v5,100);
        e0l.add(e02);
        e0l.add(e04);
        e0l.add(e05);

        Edge e12 = new Edge(v2,5);
        e1l.add(e12);
       
        Edge e23 = new Edge(v3,50);
        e2l.add(e23);
       
        Edge e35 = new Edge(v5,10);
        e3l.add(e35);
       
        Edge e43 = new Edge(v3,20);
        Edge e45 = new Edge(v5,60);
        e4l.add(e43);
        e4l.add(e45);
       
        vertexMap.put("v0", v0);
        vertexMap.put("v1", v1);
        vertexMap.put("v2", v2);
        vertexMap.put("v3", v3);
        vertexMap.put("v4", v4);
        vertexMap.put("5", v5);
       
        dijkstra("v0","v5");
    }
   
}