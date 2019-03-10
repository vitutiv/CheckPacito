package checkers;

import java.awt.Color;
import game.*;

public class CheckerKing extends CheckersPiece {
	/* Basic constructor - Color only*/
	public CheckerKing(Color color) {
		super(color);
	}

	/* Basic constructor - Color and position */
	public CheckerKing(Color color,Position position) {
		super(color, position);
	}
	
	/* A constructor for lazy enough people like me */
	public CheckerKing(Piece p) {
		super(p.getColor(),p.getPosition());
	}
	
	@Override
	public boolean setPosition(int line, int column) {
		if (Teams.getTeamIndex(_color) == Teams.getTeamTurn()) {
			int oldLine = _position.getLine();
			int oldColumn = _position.getColumn();
			if (line == oldLine + 1 && column == oldColumn + 1 || line == oldLine + 1 && column == oldColumn - 1||line == oldLine -1 && column == oldColumn + 1 || line == oldLine + -1 && column == oldColumn - 1) {
				_position = new Position(line, column);
				Teams.nextTurn();
				return true;
			}
		}
		return false;
	}


}
