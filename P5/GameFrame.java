package P5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	private Game game;
	public GameFrame(Game game, String title, int width, int height) {
		this.game = game;
		//attributes
		setSize(width, height);
		setTitle(title);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//create and add objects
		add(new GamePanel());
	}
	
	private class GamePanel extends JPanel{
		BufferedImage myImage;
		public GamePanel() {
			//setBackground(Color.BLACK);
			try {
				myImage = ImageIO.read(new File("background.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(myImage, 0, 0, this);
			game.paint((Graphics2D)g);
		}

	}

}
