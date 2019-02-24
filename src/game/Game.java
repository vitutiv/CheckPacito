package game;

import java.util.ArrayList;

public abstract class Game {

	protected ArrayList<Piece> pieces;
	protected Board board;

	public Board getBoard() {
		return board;
	}

}

