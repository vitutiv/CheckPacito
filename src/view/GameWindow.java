package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import game.*;

/* HERE'S WHERE THE MESS BEGINS */
public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public final int TILE_SIZE = 60;
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
            	/* mouseX and mouseY are the mouse coordinates on screen */
            	int mouseX = e.getX();
            	int mouseY = e.getY();
            	
            	/* tileColumn and tileLine store calculated values about the line and column clicked by the user */
            	int tileColumn = (int) (mouseX / TILE_SIZE);
            	int tileLine = (int) (mouseY / TILE_SIZE);
            	
            	/* Handles the return values of the movePiece method */
            	switch (b.movePiece(tileLine,tileColumn)) {
            	case 0:
            		System.out.print("Position of piece changed successfully. ");
            		break;
            	case 1:
            		System.out.print("There is no piece here. ");
            		break;
            	case 2:
            		System.out.print("There is a piece here. ");
            		break;
        		default:
        			System.out.print("UNHANDLED COSMIC EXCEPTION");
            	}
            	
            	/* Outputs last clicked and calculated line and column */
            	System.out.println("Line: " + tileLine + " Column: " + tileColumn);
            	
            	/* Outputs a text version of the board for debugging purposes */
            	System.out.println(b.toString());
            	gamePanel.repaint();
            }
		});
	}
}