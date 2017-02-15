package Maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class ScanToImage extends JFrame {

	public ScanToImage() {
		setSize(500, 300);
		setTitle("미로 나타내기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			MyPanel panel = new MyPanel();
			add(panel, BorderLayout.CENTER);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws IOException {
		ScanToImage frame = new ScanToImage();
		frame.setVisible(true);
	}

}

class MyPanel extends JPanel {
	BufferedImage bi;
	int width, height, imageX, imageY;
	boolean isStart = true;
	Color color = new Color(0, 0, 0);
	BufferedReader s = null;
	boolean[][] maze = new boolean[12][13];

	public MyPanel() throws IOException {
		s = new BufferedReader(new FileReader("maze.txt"));
		String line = null;
		int i = 0;
		int j = 0;
		while ((line = s.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				if (st.nextToken().equals("1"))
					maze[i][j] = true;
				else
					maze[i][j] = false;
				j++;
			}
			i++;
			j = 0;
		}
		for (i = 0; i < maze.length; i++) {
			for (j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

		if (s != null)
			s.close();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				g.setColor(Color.black);
				if (maze[i][j])
					g.fillRect(j * 50, i * 50, 50, 50);
				g.setColor(Color.blue);
				if (maze[i][j])
					g.drawRect(j * 50, i * 50, 50, 50);
			}
		}
	}
}