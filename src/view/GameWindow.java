package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.*;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public final int TILE_SIZE = 60;
	private Piece previousPiece = null;
	private Board gameBoard;
	public GameWindow(Board b){
		gameBoard = b;
		JPanel gamePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void paint(Graphics g) {
				for (int x = 0; x < gameBoard.getColumnCount(); x++) {
					for (int y = 0; y < gameBoard.getLineCount(); y ++) {						
						if ((x + y) % 2 == 0) {
							g.setColor(Color.WHITE);	
						}else{
							g.setColor(Color.BLACK);
						}
						g.fillRect(x * TILE_SIZE , y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
						//System.out.println("Board Column: " + x + " Line:"+ y + " Color: " + g.getColor());
					}
				}
				
				for (int l = 0; l < b.getLineCount(); l++) {
					for (int c = 0; c < b.getColumnCount(); c++) {
						if (b.getTiles()[c][l] != null) {
							int line = b.getTiles()[c][l].getPosition().getLine();
							int column = b.getTiles()[c][l].getPosition().getColumn();
							g.setColor(b.getTiles()[c][l].getColor());
							g.fillOval(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
							g.setColor(Color.WHITE);
							g.drawOval(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
						}
					}
				}

			}
		};
		getContentPane().add(gamePanel);
		setSize((int) (TILE_SIZE * (b.getColumnCount() + 0.1)), (int) (TILE_SIZE * (b.getLineCount() + 0.5)));
		setVisible(true);
		gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int mouseX = e.getX();
            	int mouseY = e.getY();
            	int tileColumn = (int) (mouseX / TILE_SIZE);
            	int tileLine = (int) (mouseY / TILE_SIZE);
            	
            	Piece p = b.getTiles()[tileColumn][tileLine];
            	
            	if (p == null) {
            		System.out.print("No piece here: ");
            	}else {
            		System.out.print("There is a piece here: ");
            	}
            	System.out.println("Column " + tileColumn + ", Line " +tileLine);
            	gamePanel.repaint();
            }
		});
	}

}