package game;

import java.awt.Color;

public class Piece {
	private String _name;
	private Color _color;
	private Position _position;
	private int _moveCounter = 0;
	
	public Piece(String name, Color color, Position position) {
		_name = name;
		_color = color;
		_position = position;
	}
	
	public Piece(Color color, Position position) {
		_name = "";
		_color = color;
		_position = position;
	}
	
	public String getName() {
		return _name;
	}
	
	public Color getColor() {
		return _color;
	}
	
	public Position getPosition() {
		return _position;
	}
	
	public int getMoveCounter() {
		return _moveCounter;
	}

	public void incrementMoveCounter() {
		++_moveCounter;
	}
	public void decrementMoveCounter() {
		--_moveCounter;
	}
	
}
