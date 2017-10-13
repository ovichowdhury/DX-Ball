import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyPanel extends JPanel {

	private static int x=120;
	private static int y=250;
	private static int w=50;
	private static int h=10;
	static int level=1;
	static boolean gameOverFlag=false;
	Rectangle pad;
	boolean start=false;
	static Obstacles obstacle = new Obstacles();
	Ball ball = new Ball(this);
	
	public MyPanel(){
		
	}
	public void init(){
		this.setSize(294, 272);
		this.setLayout(null);
		// Decoration
		this.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
		this.setBackground(Color.WHITE);
	
		// pad initial size
		pad = new Rectangle(x,y,w,h);
		
		// listener
		this.addKeyListenerToFrame();
		this.setFocusable(true);
	}
	
	private void addKeyListenerToFrame() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					movePadRight();
					repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT){
					movePadLeft();
					repaint();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					start=true;
					movePadRight();
					repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT){
					start=true;
					movePadLeft();
					repaint();
				}
				else if(e.getKeyChar()=='p'){
					start=false;
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(x, y, w,h);
		ball.paint(g);
		switch(level){
		case 1:
			obstacle.ob.paint(g);
			break;
		case 2:
			obstacle.ob2.paint(g);
			break;
		case 3:
			obstacle.ob3.paint(g);
			break;
		case 4:
			obstacle.dynamicOb.paint(g);
			break;
		case 5:
			obstacle.dynamicOb.paint(g);
			break;
		default:
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.setColor(Color.red);
			g.drawString("Game Over", 70, 70);
			gameOverFlag=true;
			break;
		}
		
		
		
	}
	
	private void movePadRight(){
		if(x < 290-w)
			x=x+5;
	}
	private void movePadLeft(){
		if(x > 5)
			x=x-5;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,w,h);
	}
	
	public void gameOver(){
		Audio.gameOver.play();
		int answer = JOptionPane.showConfirmDialog(this, "Want To Play?", "ExitBox", JOptionPane.YES_NO_OPTION);
		if(answer==0){
			x=120;
			y=250;
			ball.setX(135);
			ball.setY(230);
			switch(level){
			case 1:
				obstacle.ob.reConfigureTheState();
				break;
			case 2:
				obstacle.ob2.reConfigureTheState();
				break;
			case 3:
				obstacle.ob3.reConfigureTheState();
				break;
			case 4:
				obstacle.dynamicOb.reConfigureTheState();
				break;
			case 5:
				obstacle.dynamicOb.reConfigureTheState();
				break;
			}
			repaint();
			start=false;
		}
		else{
			System.exit(0);
		}
	}
	
	public  void reConfigureStates(){
		x=120;
		y=250;
		ball.setX(135);
		ball.setY(230);
		obstacle.ob.reConfigureTheState();
		obstacle.ob2.reConfigureTheState();
		obstacle.ob3.reConfigureTheState();
		obstacle.dynamicOb.reConfigureTheState();
		//obstacle.dynamicOb2.reConfigureTheState();
	}
	
}
