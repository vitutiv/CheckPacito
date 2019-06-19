package game;
import java.awt.Color;
public abstract class Piece {
	/* Basic variable declaration: color and position */
	protected Color _color;
	protected Position _position;
	protected int _moveCounter = 0;
	/* Default constructor - initializes color and position */
	public Piece(Color color, Position position) {
		_color = color;
		_position = position;
	}
	/* Basic constructor - initializes color */
	public Piece(Color color) {
		_color = color;
	}
	/* Returns the piece's color */
	public Color getColor() {
		return _color;
	}
	/* Returns the piece's position */
	public Position getPosition() {
		return _position;
	}
	/* Returns the piece's move counter */
	public int getMoveCounter() {
		return _moveCounter;
	}
	/* Increases the piece's move counter */
	public void incrementMoveCounter() {
		++_moveCounter;
	}
	/* Decreases the piece's move counter */
	public void decrementMoveCounter() {
		--_moveCounter;
	}
	/* Set the piece's position */
	public boolean setPosition(int line, int column) {
		_position = new Position(line, column);
		_moveCounter++;
		return true;
	}
}