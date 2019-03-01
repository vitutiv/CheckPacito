package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import game.*;
/* HERE'S WHEN THE MESS BEGINS */
public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public final int TILE_SIZE = 60;
	private Piece previousPiece = null;
	public GameWindow(Board b){
		JPanel gamePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void paint(Graphics g) {
				for (int x = 0; x < b.getColumnCount(); x++) {
					for (int y = 0; y < b.getLineCount(); y ++) {						
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
						if (b.getTiles()[l][c] != null) {
							int line = b.getTiles()[l][c].getPosition().getLine();
							int column = b.getTiles()[l][c].getPosition().getColumn();
							g.setColor(b.getTiles()[l][c].getColor());
							g.fillOval(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
							g.setColor(Color.WHITE);
							g.drawOval(column * TILE_SIZE + (TILE_SIZE/4), line * TILE_SIZE + (TILE_SIZE / 4), TILE_SIZE/2, TILE_SIZE / 2);
						}
					}
				}
			}
		};
		getContentPane().add(gamePanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize((int) (TILE_SIZE * (b.getColumnCount() + 0.1)), (int) (TILE_SIZE * (b.getLineCount() + 0.5)));
		setVisible(true);
		gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int mouseX = e.getX();
            	int mouseY = e.getY();
            	int tileColumn = (int) (mouseX / TILE_SIZE);
            	int tileLine = (int) (mouseY / TILE_SIZE);
            	            	
            	if (b.getTiles()[tileLine][tileColumn] == null) {
            		System.out.print("No piece here: ");
            		if (previousPiece != null) {
            			Position previousPosition = previousPiece.getPosition();
                		if (previousPiece.setPosition(tileLine, tileColumn)){
                    		b.getTiles()[previousPosition.getLine()][previousPosition.getColumn()] = null;
                    		b.getTiles()[tileLine][tileColumn] = previousPiece;
                		}
            		}
            	}else {
            		System.out.print("There is a piece here: ");
        			previousPiece = b.getTiles()[tileLine][tileColumn];
            	}
            	System.out.println("Line: " + tileLine + " Column: " + tileColumn);

            	/* Outputs a board for debugging purposes */
            	for (int line = 0; line < b.getLineCount(); line++) {
            		for (int column = 0; column < b.getColumnCount(); column++) {
            			if (b.getTiles()[line][column] != null) {
            				if (b.getTiles()[line][column].getColor() == Teams.getTeamColor(0)) {
                				System.out.print("[R]");
            				}else {
            					System.out.print("[B]");
            				}
            			}else {
            				System.out.print("[ ]");
            			}
            		}
        			System.out.println("");
            	}
            	gamePanel.repaint();
            }
		});
	}

}