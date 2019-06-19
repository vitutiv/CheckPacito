package game;

public class Position {
	/* Stores the position itself */
	private int _x;
	private int _y;
	/* Initializes the position object itself
	 * _x is column
	 * _y is line
	 * as coordinates usually work
	*/
	public Position(int line, int column){
		_x = column;
		_y = line;
	}	
	/* Returns the position's line */
	public int getLine() {
		return _y;
	}
	/* Returns the position's column */
	public int getColumn() {
		return _x;
	}
}