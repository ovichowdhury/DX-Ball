import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;


public class Ball {
	MyPanel panel;
	static int clashWith=-1;
	private int x=135;
	private int y=230;
	private int xDir=1;
	private int yDir=1;
	
	public Ball(){
		
	}
	
	public Ball(MyPanel pan){
		this.panel=pan;
	}
	
	public void setX(int xCor){
		x=xCor;
	}
	
	public void setY(int yCor){
		y=yCor;
	}
	
	public void moveBall(){
		if( x+xDir <= 5)
			xDir=1;
		if(y+yDir <= 5)
			yDir=1;
		if(x+xDir > panel.getWidth()-20)
			xDir=-1;
		if(y+yDir > panel.getHeight()-25)
			panel.gameOver();
		if(isCollision()){
			yDir=-1;
		}
		switch(MyPanel.level){
		case 1:
			if(levelOneCollisions()){
				if(xDir==1)
					xDir=-1;
				else
					xDir=1;
				if(yDir==1)
					yDir=-1;
				else
					yDir=1;
				Audio.sound.play();
			}
			break;
		case 2:
			if(levelTwoCollisions()){
				if(xDir==1)
					xDir=-1;
				else
					xDir=1;
				if(yDir==1)
					yDir=-1;
				else
					yDir=1;
				Audio.sound.play();
			}
			break;
		case 3:
			if(levelThreeCollisions()){
				if(xDir==1)
					xDir=-1;
				else
					xDir=1;
				if(yDir==1)
					yDir=-1;
				else
					yDir=1;
				Audio.sound.play();
			}
			break;
		case 4:
			if(dynamicLevelCollisions()){
				if(xDir==1)
					xDir=-1;
				else
					xDir=1;
				if(yDir==1)
					yDir=-1;
				else
					yDir=1;
				Audio.sound.play();
			}
			break;
		case 5:
			if(dynamicLevelCollisions()){
				if(xDir==1)
					xDir=-1;
				else
					xDir=1;
				if(yDir==1)
					yDir=-1;
				else
					yDir=1;
				Audio.sound.play();
			}
			break;
		}
		
		x=x+xDir;
		y=y+yDir;
	}
	
	public void paint(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.red);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.fillOval(x, y, 20, 20);
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,20,20);
	}
	
	private boolean isCollision(){
		if(panel.getBounds().intersects(getBounds())== true){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean levelOneCollisions(){
		for(int i=0; i<LevelOneObstacles.obstacleRemains; i++){
			if(LevelOneObstacles.r[i].getBounds().intersects(getBounds())){
				clashWith=i;
				return true;
			}
		}
		return false;
	}
	private boolean levelTwoCollisions(){
		for(int i=0; i<LevelTwoObstacles.obstacleRemains; i++){
			if(LevelTwoObstacles.r[i].getBounds().intersects(getBounds())){
				clashWith=i;
				return true;
			}
		}
		return false;
	}
	private boolean levelThreeCollisions(){
		for(int i=0; i<LevelThreeObstacles.obstacleRemains; i++){
			if(LevelThreeObstacles.r[i].getBounds().intersects(getBounds())){
				clashWith=i;
				return true;
			}
		}
		return false;
	}
	private boolean dynamicLevelCollisions(){
		for(int i=0; i<DynamicObstacle.r.size(); i++){
			if(DynamicObstacle.r.elementAt(i).intersects(getBounds())){
				clashWith=i;
				return true;
			}
		}
		return false;
		
	}
	
}
