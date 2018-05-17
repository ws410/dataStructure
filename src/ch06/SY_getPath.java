package ch06;

public class SY_getPath {
	 public static int dijkstra(int[][] W1, int start, int end) { 
	        boolean[] isLabel = new boolean[W1[0].length];// 是否标号 
	        int[] indexs = new int[W1[0].length];// 所有标号的点的下标集合，以标号的先后顺序进行存储，实际上是一个以数组表示的栈 
	        int i_count = -1;//栈的顶点 
	        int[] distance = W1[start].clone();// v0到各点的最短距离的初始值 
	        int index = start;// 从初始点开始 
	        int presentShortest = 0;//当前临时最短距离 
	 
	        indexs[++i_count] = index;// 把已经标号的下标存入下标集中 
	        isLabel[index] = true; 
	         
	        while (i_count<W1[0].length) { 
	            // 第一步：标号v0,即w[0][0]找到距离v0最近的点 
	 
	            int min = Integer.MAX_VALUE; 
	            for (int i = 0; i < distance.length; i++) { 
	                if (!isLabel[i] && distance[i] != -1 && i != index) { 
	                    // 如果到这个点有边,并且没有被标号 
	                    if (distance[i] < min) { 
	                        min = distance[i]; 
	                        index = i;// 把下标改为当前下标 
	                    } 
	                } 
	            } 
	            if (index == end) {//已经找到当前点了，就结束程序 
	                break; 
	            } 
	            isLabel[index] = true;//对点进行标号 
	            indexs[++i_count] = index;// 把已经标号的下标存入下标集中 
	            if (W1[indexs[i_count - 1]][index] == -1
	                    || presentShortest + W1[indexs[i_count - 1]][index] > distance[index]) { 
	                // 如果两个点没有直接相连，或者两个点的路径大于最短路径 
	                presentShortest = distance[index]; 
	            } else { 
	                presentShortest += W1[indexs[i_count - 1]][index]; 
	            } 
	 
	            // 第二步：将distance中的距离加入vi 
	            for (int i = 0; i < distance.length; i++) { 
	                // 如果vi到那个点有边，则v0到后面点的距离加 
	                if (distance[i] == -1 && W1[index][i] != -1) {// 如果以前不可达，则现在可达了 
	                    distance[i] = presentShortest + W1[index][i]; 
	                } else if (W1[index][i] != -1
	                        && presentShortest + W1[index][i] < distance[i]) { 
	                    // 如果以前可达，但现在的路径比以前更短，则更换成更短的路径 
	                    distance[i] = presentShortest + W1[index][i]; 
	                } 
	 
	            } 
	        } 
	        //如果全部点都遍历完，则distance中存储的是开始点到各个点的最短路径 
	        for (int i = 0; i < indexs.length; i++) {
	        	System.out.println(indexs[i]);
				
			}
	        return distance[end] - distance[start]; 
	    } 
	    public static void main(String[] args) { 
	        // 建立一个权值矩阵 
	        int[][] W1 = { //测试数据1 
	                { 0, 1, 4, -1, -1, -1 }, 
	                { 1, 0, 2, 7, 5, -1 }, 
	                { 4, 2, 0, -1, 1, -1 },  
	                { -1, 7, -1, 0, 3, 2 }, 
	                { -1, 5, 1, 3, 0, 6 },  
	                { -1, -1, -1, 2, 6, 0 } }; 
	        int[][] W = { //测试数据2 
	                { 0, 1, 3, 4 }, 
	                { 1, 0, 2, -1 }, 
	                { 3, 2, 0, 5 }, 
	                { 4, -1, 5, 0 } }; 
	 
//	        System.out.println(dijkstra(W1, 0,4)); 
	        dijkstra(W1, 0,4);
	 
	    } 
}
