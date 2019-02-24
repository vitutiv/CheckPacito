package game;

import java.util.ArrayList;

public class Board {
	public int[] BoardLine;
	public int[] BoardColumn;
	
	private ArrayList<Piece> _piece;
	
	public void setPieces(ArrayList<Piece> piece) {
		_piece = piece;
	}
	
	public ArrayList<Piece> getPieces() {
		return _piece;
	}
	
}
