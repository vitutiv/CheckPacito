package game;
import gameCheckers.CheckersGame;
import view.*;;
public class Main {
		
	public static void main(String[] args) {
		CheckersGame game = new CheckersGame();
		GameWindow gameWindow = new GameWindow(game.getBoard());
		gameWindow.setTitle("Checkers Game");
		//gameWindow.setResizable(false);
	}

}
