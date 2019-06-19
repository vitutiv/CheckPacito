package game;
import checkers.CheckersGame;
import view.*;;
public class Main {		
	public static void main(String[] args) {
		/* Calls a new Checkers game */
		CheckersGame game = new CheckersGame();
		/* Initializes the interface with the created board */
		GameWindow gameWindow = new GameWindow(game.getBoard());		
		gameWindow.setTitle("Checkers Game");
		//gameWindow.setResizable(false);
	}
}