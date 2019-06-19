package checkers;

import java.util.ArrayList;
import game.Board;
import game.Piece;
import game.Position;
import game.Teams;
public class CheckersBoard extends Board{
	/* Basic constructor, no piece will be added */
	public CheckersBoard() {
		super(8,8);
	}
	/* Builds a board with pieces in it */
	public CheckersBoard(ArrayList<Piece> pieces) {
		super(8,8,pieces);
	}
	@Override
	public byte movePiece(int tileLine, int tileColumn) {
		Position previousPosition = null;
		if (previousPiece != null) {
			previousPosition = previousPiece.getPosition();
		}
		if (!hasPiece(tileLine, tileColumn)) {
    		
			if (tileLine == previousPiece.getPosition().getLine() + 2 || tileLine == previousPiece.getPosition().getLine() - 2) {
				int wayY = -1;
				if (tileLine == previousPiece.getPosition().getLine() + 2) {
					wayY = 1;
				}
				int wayX = -1;
				if (tileColumn == previousPiece.getPosition().getColumn() + 2) {
					wayX = 1;
				}
				if (hasPiece(tileLine - wayY, tileColumn - wayX) && _tiles[tileLine - wayY][tileColumn - wayX].getColor() != Teams.getTeamColor(Teams.getTeamTurn())) {
					if (previousPiece.setPosition(tileLine, tileColumn)) {
	        			_tiles[previousPosition.getLine()][previousPosition.getColumn()] = null;
						_tiles[tileLine - wayY][tileColumn - wayX] = null;
	        			_tiles[tileLine][tileColumn] = previousPiece;
					}else {
						return 2;
					}
				}
    		}else{
    			
    		}
			if (previousPiece != null) {
        		/* Checks if tile is null and moves the piece if true */
    			if (previousPiece.setPosition(tileLine, tileColumn)){
        			_tiles[previousPosition.getLine()][previousPosition.getColumn()] = null;
        			/* Checks if piece has become a king */
        			if (tileLine == _lines - 1 || tileLine == 0) {
        				_tiles[tileLine][tileColumn] = new CheckerKing(previousPiece);
        				return -1;
        			}
        			_tiles[tileLine][tileColumn] = previousPiece;
        			return 0;
        		}
        		return 1;
    		}
    	}else {
			previousPiece = _tiles[tileLine][tileColumn];
    	}
    	return 2;
	}
}