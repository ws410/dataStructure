package ch03;

import java.util.ArrayList;

public class MazeTest {
	public static void main(String[] args) {
        Maze m = new Maze();
        m.footPrint = new ArrayList<>();
        m.footPrint.add("11");
        m.stacks.push(m.start);
        while (m.currentPosition.getPx() != 8 || m.currentPosition.getPy() != 8) {
            m.move();
        }
        m.printMap();
        System.out.println("下面是足迹,长度是：" + m.footPrint.size());
        m.printFootPrint();
    }
}
