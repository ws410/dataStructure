package ch03;

import java.util.ArrayList;
import java.util.Stack;

	public class Maze {
	    final Position start;//迷宫的起点
	    final Position end;//迷宫的终点
	    ArrayList<String> footPrint;//足迹
	    ArrayList<Position> test;
	    Stack<Position> stacks;//定义栈
	    Position currentPosition;//定义当前位置
	    public Maze() {//栈的初始化工作
	        start = new Position(1, 1);
	        end = new Position(8, 8);
	        currentPosition = start;
	        stacks = new Stack();
	        test = new ArrayList<>();
	    }
	    public static final int map[][] = //定义地图为10*10的方格
	            {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
	            {1, 1, 0, 1, 0, 0, 0, 1, 0, 1},
	            {1, 0, 0, 1, 0, 1, 1, 0, 0, 1},
	            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
	            {1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
	            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
	            {1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
	            {1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
	            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
	    public static void printMap() {//打印地图
	        for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	                if (map[i][j] == 1) System.out.print(" ■");
	                else System.out.print("  ");
	            }
	            System.out.println();
	        }
	    }
	    public boolean moveTop() {//上移
	        String s = currentPosition.getPx() + "" + (currentPosition.getPy() - 1);
	        if ((map[currentPosition.getPx()][currentPosition.getPy() - 1] != 1) & !isArrived(s)) {
	            footPrint.add(s);
	            return true;
	        }
	        return false;
	    }
	    public boolean moveRight() {//右移
	        String s = (currentPosition.getPx() + 1) + "" + currentPosition.getPy();
	        if (map[currentPosition.getPx() + 1][currentPosition.getPy()] != 1 & !isArrived(s)) {
	            footPrint.add(s);
	            return true;
	        }
	        return false;
	    }
	    public boolean moveBottom() {//下移
	        String s = currentPosition.getPx() + "" + (currentPosition.getPy() + 1);
	        if ((map[currentPosition.getPx()][currentPosition.getPy() + 1] != 1) & !isArrived(s)) {
	            footPrint.add(s);
	            return true;
	        }
	        return false;
	    }
	    public boolean moveLeft() {//左移
	        String s = (currentPosition.getPx() - 1) + "" + currentPosition.getPy();
	        if ((map[currentPosition.getPx() - 1][currentPosition.getPy()] != 1) & !isArrived(s)) {
	            footPrint.add(s);
	            return true;
	        }
	        return false;
	    }
	    public boolean isArrived(String position) {//判断当前位置是否已经到打过
	        return footPrint.contains(position);
	    }
	    public void move() {//move函数分别向四个方向移动，然后将可行的path入栈
	        if (moveRight()) {
	            Position temp = new Position(currentPosition.getPx() + 1, currentPosition.getPy());
	            test.add(temp);
	            stacks.push(temp);
	        } else if (moveBottom()) {
	            Position temp = new Position(currentPosition.getPx(), currentPosition.getPy() + 1);
	            test.add(temp);
	            stacks.push(temp);
	        } else if (moveTop()) {
	            Position temp = new Position(currentPosition.getPx(), currentPosition.getPy() - 1);
	            test.add(temp);
	            stacks.push(temp);
	        } else if (moveLeft()) {
	            Position temp = new Position(currentPosition.getPx() - 1, currentPosition.getPy());
	            test.add(temp);
	            stacks.push(temp);
	        } else {
	            currentPosition = stacks.pop();//若当前位置四个方向都走不通，则将当前位置出栈，继续遍历上一节点
	        }
	    }
	    public void printFootPrint() {
	        for (int i = 0; i < footPrint.size(); i++) {
	            System.out.print(footPrint.get(i) + ",");
	        }
	        System.out.println();
	    }
	}

