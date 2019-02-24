package game;

import java.awt.Color;
import java.util.ArrayList;

public class CheckersGame extends Game{
	
	public CheckersGame() {
		pieces = new ArrayList<Piece>();
		
		Color actualColor = Color.RED;
		for (int team = 0; team < 2; team++) {
			for (int column = 0; column < 8; column++) {
				for (int line = 0; line < 3; line++) {
					if ((line + column + team) % 2 == 1) {
						Piece p = new Piece(actualColor,new Position(column, line + (team * 5)));
						pieces.add(p);
						//System.out.println("Piece added: " + column + " " + (line + (team * 5)));
					}
				}
			}
			actualColor = Color.BLACK;
		}
		board = new Board(8,8,pieces);
	}
}
