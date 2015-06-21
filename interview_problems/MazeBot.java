/**
You are a hover bot that needs to find the quickest
way out of a 3D maze! You can think of the maze as a
box made up of unit cubes where each cube is either
transparent or solid. You can move in any of these
6 directions: north, south, east, west, up, down. Each
move is considered to take exactly one cube and you
can move only through transparent cubes. (You cannot
move through the boundaries of the maze, or
through solid cubes). A* is not required for this problem.
You may focus more on solving it than optimizing it.

INPUT FORMAT

The input file begins with a line of text designating the
height of the box measured in cubes. It then
describes each layer individually that make up the box
starting from bottom to top. Each layer must
be the same width and height. Let's assume that "#"
designates a solid cube and "." a transparent one.
Also, "B" marks your beginning cell and "E" marks the
end cell. Note that B and E may be in any one of
the layers. Also, assume B and E can be treated as
transparent cubes.

OUTPUT FORMAT

The output format should ouput either "Not Escapable"
or "Escapable: " followed by the exact steps the Bot
took to get out of the maze. Please shorten the
direction names to be N,S,E,W,U,D. Also, make sure
the bot finds the solution in the shortest path
possible!

SAMPLE INPUT


3
B####
.####
.####
.....

#..#.
#..#.
#..#.
####.

..#.E
..#..
..#..
.....

The sample input can be a file or a string of text in your php/java file that we can change to test our own levels.

SAMPLE OUTPUT

Escapable: SSSEEEEUNNNU


Some further thoughts to include
(This can be in the form of just writing, we can talk about this on the phone, or during the implementation, if you can find a way to do this without too much work, you can choose to squeeze it in)
Extra: Have the ability to input another Bot, called "A" in the sample input, at a different location. Both bots must make it to the exit without colliding with each other in the shortest amount of total moves possible. Explain(don't implement) how your solution can scale up to more bots and a bigger maze while maintaining the criteria of shortest total moves possible?
Extra 2: Show a visualization of the bot moving(text based visual output is fine)

LAST NOTE
We will mainly look at your approach to the problem, your algorithm, code clarity, and the design choices made. We prefer that you program this in Objective C.
*/

class MazeBot {
	
	public class Maze {
		int level;
		int width;
		int length;
		Cell[][][] cells;
		Cell beginCell;
		Cell endCell;
		
		public Maze(String input) {
			init(str);
		}
		
		public void init(String str) {
			String[] lines = str.split(System.getProperty("line.separator"));
			this.level = str.charAt(0) - '0';
			this.width = lines[1].length();
			this.length = (lines.length - 1) / level;
			this.cells = new Cell[level][length][width];
			for (int l = 0; l < this.level; l++) {
				for (int i = 0; i < this.length; i++) {
					for (int j = 0; j < this.width; j++) {
						char val = line[l * length + i + 1].charAt(j);
						cells[l][i][j] = new Cell(l, i, j, val);
						if (val == 'B') {
							this.beginCell = cells[l][i][j];
						} else if (val == 'B') {
							this.endCell = cells[l][i][j];
						}
					}
				}
			}
		}
		
		
		/**
		x -  level; y - length; z - width
		*/
		public Cell getCell(int x, int y, int z) {
			return cells[x][y][z];
		}
		
		public List<Cell> getCloseCell(Cell cell) {
			int x = cell.x;
			int y = cell.y;
			int z = cell.z;
			List<Cell> res = new ArrayList<Cell>();
			if (x - 1 >= 0) {
				cells[x-1][y][z] = Direction.down;
				res.add(cells[x-1][y][z]);
			}
			if (x + 1 < level) {
				cells[x+1][y][z].lastStep = Direction.up;
				res.add(cells[x+1][y][z]);
			}
			if (y - 1 >= 0) {
				cells[x][y-1][z] = Direction.north;
				res.add(cells[x][y-1][z]);
			}
			if (y + 1 < length) {
				cells[x][y+1][z] = Direction.south;
				res.add(cells[x][y+1][z]);
			}
			if (z - 1 >= 0) {
				cells[x][y][z-1].lastStep = Direction.west;
				res.add(cells[x][y][z-1]);
			}
			if (z + 1 < width) {
				cells[x][y][z+1].lastStep = Direction.east;
				res.add(cells[x][y][z+1]);
			}
			return res;
		}
	}
	
	public class Cell {
		int x;
		int y;
		int z;
		char val;
		boolean visited;
		Direction lastStep;
		
		public Cell(int x, int y, int z, int val) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.val = val;
		}
		
	}
	
	enum Direction {
		north, south, east, west, up, down;
	}	
	
	public class Robot {
		Maze maze
		String path;
	
		public void start(Maze maze) {
			this.maze = maze;			
			boolean isExcapable = bfs();
			if (isExcapable) {
				this.path = backtrackPath(maze.endCell);
			} else {
				this.path = "Not Escapable";
			}
		}
	
		public String getPath() {
			return this.path;
		}
		
		private String backtrackPath(Cell cell) {
			StringBuilder res = new StringBuilder();
			int x = cell.x;
			int y = cell.y;
			int z = cell.z;
			while (cell.val != 'B') {
				switch (cell.lastStep) {
					case Direction.north:
						res.append("N");
						cell = maze.getCell(x, ++y, z);
						break;
					case Direction.south:
						res.append("S");
						cell = maze.getCell(x, --y, z);
						break;
					case Direction.west:
						res.append("W");
						cell = maze.getCell(x, y, ++z);
						break;
					case Direction.east:
						res.append("E");
						cell = maze.getCell(x, y, --z);
						break;
					case Direction.up:
						res.append("U");
						cell = maze.getCell(--x, y, z);
						break;
					case Direction.down:
						res.append("D");
						cell = maze.getCell(++x, y, z);
						break;
				}
			}
			res.reverse();
			res.insert(0, "Escapable: ");
			return res.toString();
		}
		
		private void bfs() {
			Queue<Cell> queue = new PriorityQueue<Cell>();
			queue.add(maze.getCell(0, 0, 0));
			while (!queue.isEmpty()) {
				Cell cell = queue.pop();
				for (Cell c : maze.getCloseCell(cell)) {
					if (c.val == '#' || c.visited) {
						continue;
					}
					if (c.val == 'E') {
						return true;
					}
					c.visited = true;
					queue.add(c);
				}
			}
			return false;
		}
	}
	/**
	*	Read content from txt file
	*/
	public String readInputFile(String filePath) {
		
	}
	
	public static void main(String[] args) {
		String filePath = "";
		String input = readInputFile(filePath);
		Maze maze = new Maze(input);
		Robot robot = new Robot(maze);
		robot.start();
		String path = robot.getPath();
		System.out.println(path);
	}
}