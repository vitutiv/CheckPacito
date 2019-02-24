package game;

import java.util.ArrayList;

public class Board {
	private int _lines = 8;
	private int _columns = 8;
	private Piece[][] _tiles = new Piece[8][8];
	
	public Board() {
		
	}
	
	public Board(int lines, int columns) {
		_lines = lines;
		_columns = columns;
		_tiles = new Piece[lines][columns];
	}
	
	public Board(int lines, int columns, ArrayList<Piece> pieces) {
		_lines = lines;
		_columns = columns;
		_tiles = new Piece[lines][columns];
		setPieces(pieces);
		
	}
	public int getLineCount() {
		return _lines;
	}
	
	public int getColumnCount() {
		return _columns;
	}
	
	public void setPieces(ArrayList<Piece> pieces) {
		for (int i = 0; i < pieces.size(); i++) {
			_tiles[pieces.get(i).getPosition().getColumn()][pieces.get(i).getPosition().getLine()] = pieces.get(i);
			//System.out.println(_tiles[pieces.get(i).getPosition().getColumn()][pieces.get(i).getPosition().getLine()]);
			//System.out.println(i);
		}
	}
	
	public Piece[][] getTiles() {
		return _tiles;
	}
	
}
