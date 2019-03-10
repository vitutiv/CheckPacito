package checkers;

import java.awt.Color;
import java.util.ArrayList;
import game.*;

public class CheckersGame extends Game{
	
	public CheckersGame() {
		/* Initialize, generate and add each team pieces generated to the ArrayList of pieces
		 * I know, too many nested 'for' loops */
		Teams.setTeamColors(new Color[]{Color.RED, Color.BLACK});
		pieces = new ArrayList<Piece>();
		for (int team = 0; team < 2; team++) {
			for (int column = 0; column < 8; column++) {
				for (int line = 0; line < 3; line++) {
					if ((line + column + team) % 2 == 1) {
						Piece p = new CheckersPiece(Teams.getTeamColor(team),new Position(line + (team * 5),column));
						pieces.add(p);
					}
				}
			}
		}
		
		/* Finally, initializes the checker board with the pieces */
		board = new CheckersBoard(pieces);
	}
}
