package checkers;

import java.util.ArrayList;

import game.Board;
import game.Piece;
import game.Position;

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
		if (!hasPiece(tileLine, tileColumn)) {
    		if (previousPiece != null) {
    			Position previousPosition = previousPiece.getPosition();
        		if (previousPiece.setPosition(tileLine, tileColumn)){
        			_tiles[previousPosition.getLine()][previousPosition.getColumn()] = null;
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
