package visao;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.*;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public final int TILE_SIZE = 60;

	public GameWindow(Game g){
		Board gameBoard = g.getBoard();
		ArrayList<Piece> gamePieces = gameBoard.getPieces();
		JPanel gamePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub

				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y ++) {						
						if ((x + y) % 2 == 0) {
							g.setColor(Color.WHITE);	
						}else{
							g.setColor(Color.BLACK);
						}
						g.fillRect(x * TILE_SIZE , y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

						System.out.println("Casa Coluna: " + x + " Linha:"+ y + " Cor: " + g.getColor());
					}
				}
				for (int i = 0; i < gamePieces.size(); i++) {
					Piece p = gamePieces.get(i);
					g.setColor(p.getColor());
					g.fillRect(p.getPosition().getX() * TILE_SIZE + TILE_SIZE / 4,p.getPosition().getY() * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
					System.out.println(p.getName() + " Coluna:" +p.getPosition().getX() + " Linha:" +p.getPosition().getY());					
					if (g.getColor() == Color.WHITE) {
						g.setColor(Color.BLACK);
					}else{
						g.setColor(Color.WHITE);
					}
					g.drawRect(p.getPosition().getX() * TILE_SIZE + TILE_SIZE / 4,p.getPosition().getY() * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
				}
			}
		};
		getContentPane().add(gamePanel);
		setSize((int) (TILE_SIZE * 8.1), (int) (TILE_SIZE * 8.5));
		setTitle("Damas");
		setVisible(true);
	}
}