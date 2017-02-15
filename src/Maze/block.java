package Maze;

public class block {

	int x, y;
	boolean visited;

	public block(int x, int y, boolean visited) {
		this.x = x;
		this.y = y;
		this.visited = visited;
	}

	@Override
	public String toString() {

		return "x = " + x + " y = " + y + " visit = " + visited + "\n";
	}
}
