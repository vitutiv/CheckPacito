package game;

import java.util.ArrayList;

public class Board {
	/* Lines and column count */
	private int _lines = 8;
	private int _columns = 8;
	/* The board "itself" - a two dimensional array with "lines" and "columns" */
	private Piece[][] _tiles = new Piece[8][8];
	
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
	
	/* Return the board tiles*/
	public Piece[][] getTiles() {
		return _tiles;
	}
}
