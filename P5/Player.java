package P5;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private String name;
	private int score, x, y;
	//private static Image img = Toolkit.getDefaultToolkit().getImage("MisterX.jpg");
	private BufferedImage img;
	public Player(String name){
		this.name = name;
		try {
			img = ImageIO.read(new File("MisterX.jpg"));
		} catch (IOException e) {}
	}
		
	public void paint(Graphics2D g2){
		g2.drawImage(img, x, y, null);
		g2.setColor(new Color(255, 210, 0));
		Font font = new Font("Arial", Font.PLAIN, 18);
		FontMetrics metrics = g2.getFontMetrics(font);
		int nameWidth = metrics.stringWidth(name);
		g2.setFont(font);
		g2.drawString(name, x + (img.getWidth(null)-nameWidth)/2, y + img.getHeight(null)-5);

		g2.setFont(new Font("Arial", Font.BOLD, 22));
		g2.setColor(new Color(150, 255, 255));
		g2.drawString("$" + score, x+10, y + img.getHeight(null)+55);
	}

	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void incrementScore(){
		score+=100;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
