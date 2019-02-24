package gameCheckers;

import java.awt.Color;

import game.Piece;
import game.Position;

public class CheckersPiece extends Piece{
	
	public CheckersPiece(Color color, Position position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}

	public CheckersPiece(String name, Color color, Position position) {
		super(name,color,position);
	}

	public void setPosition(int line, int column) {
		int oldLine = _position.getLine();
		int oldColumn = _position.getColumn();
		if (line == oldLine + 1 && column == oldColumn + 1 || line == oldLine + 1 && column == oldColumn - 1) {
			_position = new Position(column, line);	
		}else {
			System.out.println("Invalid movement");
		}
	}
}
