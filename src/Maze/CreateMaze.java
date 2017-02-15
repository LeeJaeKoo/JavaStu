package Maze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JApplet;

public class CreateMaze extends JApplet implements Runnable {

	Thread t = new Thread(this);

	static final int WINDOWSIZE = 500;// size of Applet window
	static final int N = 20;// NUM OF ROOM in a row

	static final int MAPSIZE = N * 2 + 1;
	static final int BSIZE = (int) (WINDOWSIZE / MAPSIZE);

	static block[][] map = new block[MAPSIZE][MAPSIZE];
	static int[][] m = new int[MAPSIZE][MAPSIZE];
	ArrayList<block> list = new ArrayList<block>();

	public void init() {
		for (int i = 0; i < MAPSIZE; i++) {
			for (int j = 0; j < MAPSIZE; j++) {
				map[i][j] = new block(i, j, false);
			}
		}

	}

	public void createJFrame() {
		setSize(MAPSIZE * BSIZE, MAPSIZE * BSIZE);
		setVisible(true);
		generateMap();
	}

	public static void main(String[] args) {
		new CreateMaze();
	}

	@Override
	public void run() {// 미로 찾기
		while (true) {

		}
	}

	public void generateMap() {
		int randX = (int) (Math.random() * N) * 2 + 1;
		int randY = (int) (Math.random() * N) * 2 + 1;
		map[randY][randX].visited = true;

		System.out.println(randX + " " + randY + " " + map.length + " " + N);

		if (randX - 1 != 0) {
			list.add(map[randY][randX - 1]);
		}
		if (randX + 1 != MAPSIZE) {
			list.add(map[randY][randX + 1]);
		}
		if (randY - 1 != 0) {
			list.add(map[randY - 1][randX]);
		}
		if (randY + 1 != MAPSIZE) {
			list.add(map[randY + 1][randX]);
		}

		while (!list.isEmpty()) {
			int index = (int) (Math.random() * list.size());

		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < MAPSIZE; i++) {
			for (int j = 0; j < MAPSIZE; j++) {
				if (m[i][j] == 1)
					drawBlock(g, j, i);
			}
		}
	}

	public void drawBlock(Graphics g, int x, int y) {
		g.setColor(Color.black);

		Color t = new Color(100, 100, 50);
		g.setColor(t);
		g.fillRect(x * BSIZE, y * BSIZE, BSIZE, BSIZE);
	}
}
