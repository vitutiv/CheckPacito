package visao;
import game.*;;
public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		GameWindow gameWindow = new GameWindow(g);
		gameWindow.setResizable(false);
	}

}
