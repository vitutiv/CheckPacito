package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.*;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public final int TILE_SIZE = 60;

	public GameWindow(Board b){
		Board gameBoard = b;
		//Piece[][] boardTiles = gameBoard.getTiles();
		JPanel gamePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub

				for (int x = 0; x < gameBoard.getColumnCount(); x++) {
					for (int y = 0; y < gameBoard.getLineCount(); y ++) {						
						if ((x + y) % 2 == 0) {
							g.setColor(Color.WHITE);	
						}else{
							g.setColor(Color.BLACK);
						}
						g.fillRect(x * TILE_SIZE , y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
						//System.out.println("Board Column: " + x + " Line:"+ y + " Cor: " + g.getColor());
					}
				}
				
				for (int l = 0; l < b.getLineCount(); l++) {
					for (int c = 0; c < b.getColumnCount(); c++) {
						if (b.getTiles()[c][l] != null) {
							int line = b.getTiles()[c][l].getPosition().getLine();
							int column = b.getTiles()[c][l].getPosition().getColumn();
							//System.out.println(line + " " + column);
							g.setColor(b.getTiles()[c][l].getColor());
							g.fillRect(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
							g.setColor(Color.WHITE);
							g.drawRect(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
						}
					}
				}

			}
		};
		getContentPane().add(gamePanel);
		setSize((int) (TILE_SIZE * 8.1), (int) (TILE_SIZE * 8.5));
		setVisible(true);
	}
}