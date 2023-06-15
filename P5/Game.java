package P5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game {
	public static final int WIDTH = 800, HEIGHT = 500, MAX_PLAYERS = 3, PLAYER_Y = 50;
	protected ArrayList<Player> players = new ArrayList<Player>(MAX_PLAYERS);
	private GameFrame frame = new GameFrame(this, "COSC 111 Jeopardy", WIDTH, HEIGHT);
	private BDialog dialog = new BDialog(frame);
	private Player currentPlayer;
	private Color responseColor = Color.white;
	
	public Game(){
		frame.setLocationRelativeTo(null);
		dialog.setLocationRelativeTo(frame);
		dialog.setSize(WIDTH-10, 100);
		dialog.setLocation(frame.getX()+5, frame.getY() + HEIGHT - 105);
		frame.setVisible(true);
	}
	public void print(String msg){
		frame.repaint();
		dialog.showMessageDialog(msg);
	}
	public String askForText(String msg){
		frame.repaint();
		String response = dialog.showInputDialog(msg);  
		return (response==null || response.length()==0)? "" : response.trim();
	}
	public int askForInt(String msg, int min, int max){
		msg += "(" + min + " to " + max + ")";
		boolean found = false, msgModified = false;
		int num = 0;
		while(!found){
			try{
				num = Integer.parseInt(askForText(msg));
				if(num<min || num>max) 
					throw new Exception();
				found = true;
			}catch(Exception e){
				if(!msgModified) msg = "Invlid input. " + msg;
				msgModified = true;
			}
		}
		return num;
	}
	
	public void addPlayer(String name){
		Player player = new Player(name);
		int playerWidth = player.getImg().getWidth();
		int distanceBetweenPlayers = (WIDTH - MAX_PLAYERS * playerWidth) / (MAX_PLAYERS + 1);
		int x = (players.size()+1)  * distanceBetweenPlayers + players.size() * playerWidth;
		player.setX(x);
		player.setY(PLAYER_Y);
		players.add(player);
		frame.repaint();
	}
	public void clearPlayers(){
		players.clear();
	}
	public void paint(Graphics2D g2){
		//draw players
		for (int i = 0; i < players.size(); i++)
			players.get(i).paint(g2);
		//draw frame around selected player
		if(currentPlayer != null){
			int px = currentPlayer.getX()-4;
			int py = currentPlayer.getY()-4;
			int pw = currentPlayer.getImg().getWidth()+8;
			int ph = currentPlayer.getImg().getHeight()+8;
			g2.setStroke(new BasicStroke(8));
			g2.setColor(responseColor);
			g2.drawRect(px, py, pw, ph);
		}
		//who is turn it is
		if(currentPlayer != null){
			g2.setColor(Color.yellow);
			String name =  currentPlayer.getName() + "'s turn";
			Font font = new Font("Arial", Font.BOLD, 28);
			g2.setFont(font);
			FontMetrics metrics = g2.getFontMetrics(font);
			int txtWidth = metrics.stringWidth(name);
			g2.drawString(name, (WIDTH-txtWidth)/2, 35);
		}
	}
	public void setCurrentPlayer(int pl) {
		currentPlayer = players.get(pl);
		responseColor  = new Color(255, 160, 255);
	}
	public void correct() {
		responseColor = Color.green;
		frame.repaint();
		if(currentPlayer != null)
			currentPlayer.incrementScore();
		print("Correct (press Enter to continue).");
	}
	public void incorrect() {
		responseColor = Color.red;
		frame.repaint();
		print("Sorry, that is incorrect answer (press Enter to continue).");
	}
}
