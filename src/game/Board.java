package game;
 

import java.util.ArrayList;

import checkers.CheckerKing;

public class Board {
	/* Lines and column count */
	protected int _lines = 8;
	protected int _columns = 8;
	/* The board "itself" - a two dimensional array with "lines" and "columns" */
	protected Piece[][] _tiles = new Piece[8][8];
	protected Piece previousPiece = null;
	/* Empty constructor because all needed variables are initialized elsewhere, so... */
	public Board() {
		
	}
	/* Basic constructor, no piece will be added */
	public Board(int lines, int columns) {
		_lines = lines;
		_columns = columns;
		_tiles = new Piece[lines][columns];
	}
	/* Builds a board with pieces in it */
	public Board(int lines, int columns, ArrayList<Piece> pieces) {
		_lines = lines;
		_columns = columns;
		_tiles = new Piece[lines][columns];
		setPieces(pieces);
	}
	/* Returns the line board's line count*/
	public int getLineCount() {
		return _lines;
	}
	/* Returns the line board's column count*/
	public int getColumnCount() {
		return _columns;
	}
	/* Sets the pieces in their respective tile position */
	public void setPieces(ArrayList<Piece> pieces) {
		for (int i = 0; i < pieces.size(); i++) {
			_tiles[pieces.get(i).getPosition().getLine()][pieces.get(i).getPosition().getColumn()] = pieces.get(i);
		}
	}
	/* Returns the board tiles */
	public Piece[][] getTiles() {
		return _tiles;
	}
	/* Returns if tile has a piece */
	public boolean hasPiece(int tileLine, int tileColumn) {
		return _tiles[tileLine][tileColumn] != null;
	}
	/* Move Piece to tile */
	public byte movePiece(int tileLine, int tileColumn) {
		return 0;
	}	
	public String toString() {
		String boardString = "";
		for (int line = 0; line < _lines; line++) {
    		for (int column = 0; column < _columns; column++) {
    			if (_tiles[line][column] != null) {
    				if (_tiles[line][column].getColor() == Teams.getTeamColor(0)) {
    					if (_tiles[line][column] instanceof CheckerKing) {
    						boardString += ("[K]");
						}else {
							boardString += ("[R]");	
						}
    				}else {
    					if (_tiles[line][column] instanceof CheckerKing) {
    						boardString += ("[Q]");
    					}else {
        					boardString += ("[B]");
    					}
    				}
    			}else {
    				boardString += ("[ ]");
    			}
    		}
    		boardString += ("\n");
    	}
		return boardString;
	}
}