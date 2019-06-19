package checkers;
import java.awt.Color;
import game.Piece;
import game.Position;
import game.Teams;

public class CheckersPiece extends Piece{
	/* Basic constructor - Color and position */
	public CheckersPiece(Color color, Position position) {
		super(color,position);
	}
	
	/* Basic constructor - Color only */
	public CheckersPiece(Color color) {
		super(color);
	}
	
	@Override
	public boolean setPosition(int line, int column) {
		if (Teams.getTeamIndex(_color) == Teams.getTeamTurn()) {
			//This determines the way that the piece can move
			int way = 1;
			if (Teams.getTeamIndex(_color) == 1) {
				way = -1;
			}
			int oldLine = _position.getLine();
			int oldColumn = _position.getColumn();
			if (line == oldLine + way && (column == oldColumn + 1 || column == oldColumn - 1)) {
				_position = new Position(line, column);
				Teams.nextTurn();
				return true;
			}else if (line == oldLine + (2 * way) && (column == oldColumn + 2 || column == oldColumn - 2)){
				_position = new Position(line, column);
				return true;
			}
		}
		return false;
	}
}