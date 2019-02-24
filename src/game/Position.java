package game;

public class Position {
	private int _x;
	private int _y;
	
	public Position(int column, int line){
		_x = column;
		_y = line;
	}
	
	public int getLine() {
		return _y;
	}
	
	public int getColumn() {
		return _x;
	}
}
