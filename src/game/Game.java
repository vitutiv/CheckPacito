package game;
import java.util.ArrayList;
public abstract class Game {
	protected ArrayList<Piece> pieces;
	protected Board board = new Board();	
	public Game(){
		/* Just a nice to have */
	}
	/* Returns the game's Board */
	public Board getBoard() {
		return board;
	}
}