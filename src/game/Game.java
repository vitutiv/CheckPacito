package game;

import java.awt.Color;
import java.util.ArrayList;
public class Game {
	private Board _gameBoard = new Board();
	public Board getBoard() {
		return _gameBoard;
	}
	public Game() {
		ArrayList<Piece> _piece = new ArrayList<Piece>();
		Color _pieceColor = Color.RED;
		for (byte t = 0; t < 2; t++) {
			for (byte y = 0; y < 3; y++) {
				for (byte x = 0; x < 8; x++) {
					if ((x + y + t) % 2 != 0) {
						_piece.add(new Piece("Generic", _pieceColor, new Position(x ,y + (t * 5))));	
					}
				}
			}	
			_pieceColor = Color.BLACK;
		}
		_gameBoard.setPieces(_piece);
	}
}
