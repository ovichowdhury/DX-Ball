import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;



public class Obstacles {
	LevelOneObstacles ob;
	LevelTwoObstacles ob2;
	LevelThreeObstacles ob3;
	DynamicObstacle dynamicOb;
	//DynamicObstacle dynamicOb2;
	
	public Obstacles(){
		ob  = new LevelOneObstacles();
		ob2 = new LevelTwoObstacles();
		ob3 = new LevelThreeObstacles();
		dynamicOb = new DynamicObstacle();
		//dynamicOb2 = new DynamicObstacle();
	}
	
}

class RandomColor{
	
	public static Color getRandomColor(){
		Random rn = new Random();
		int color = rn.nextInt(6);
		switch(color){
		case 1:
			return Color.ORANGE;
		case 2:
			return Color.CYAN;
		case 3:
			return Color.MAGENTA;
		case 4:
			return Color.BLUE;
		case 5:
			return Color.GRAY;
		}
		return Color.GREEN;
	}
}

// dynamic obstacle or level

class DynamicObstacle{
	private int x=20;
	private int y=30;
	private int length=30;
	private  static boolean levelFlag=false;
	private Random rn = new Random();
	private Color color;
	
	static Vector <Rectangle> r;
	
	public DynamicObstacle(){
		r = new Vector<Rectangle>();
		for(int i=0;i<rn.nextInt(13)+4;i++){
			r.add(new Rectangle());
		}
		this.setRectanglePositions();
		this.color = RandomColor.getRandomColor();
	}
	public void reConfigureTheState(){
		x=20;
		y=30;
		for(int i=0;i<rn.nextInt(13)+4;i++){
			r.add(new Rectangle());
		}
		this.setRectanglePositions();
		this.color = RandomColor.getRandomColor();
		levelFlag=false;
		
	}
	private void setRectanglePositions(){
		for(int i=0 ; i<r.size() ; i++){
			r.elementAt(i).setBounds(x, y, length, length);
			x=x+70;
			switch(i){
			case 3:
				x=40; y=y+30;
				break;
			case 7:
				x=20; y=y+30;
				break;
			case 11:
				x=40; y=y+30;
				break;
			}
		}
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		for(int i=0; i<r.size(); i++){
			if(i==Ball.clashWith){
				r.removeElementAt(i);
				Ball.clashWith=-1;
			}else{
				g.fillOval(r.elementAt(i).x, r.elementAt(i).y, r.elementAt(i).width, r.elementAt(i).height);
			}
		}
		if(r.size()==0 && levelFlag==false){
			MyPanel.level++;
			levelFlag=true;
			this.reConfigureTheState();
		}
	}
	
}

class LevelThreeObstacles{
	private int x=20;
	private int y=40;
	private int length=20;
	private static boolean levelFlag=false;
	//static boolean reConfigure=false;
	static Rectangle [] r;
	final int NUM_OF_OBSTACLES=8;
	static int obstacleRemains=8;
	
	public LevelThreeObstacles(){
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES/2 ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+70;
		}
		x=40;
		y=y+30;
		for(int i=NUM_OF_OBSTACLES/2; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+70;
		}
	}
	
	public void reConfigureTheState(){
		x=20;
		y=40;
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES/2 ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+70;
		}
		x=40;
		y=y+30;
		for(int i=NUM_OF_OBSTACLES/2; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+70;
		}
		levelFlag=false;
		obstacleRemains=8;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.MAGENTA);
	 
		for(int i=0; i<obstacleRemains; i++){
			if(i==Ball.clashWith){
				r[i]=r[obstacleRemains-1];
				r[obstacleRemains-1]=null;
				obstacleRemains--;
				Ball.clashWith=-1;
				continue;
			}else{
				g.fillRect(r[i].x,r[i].y, r[i].width, r[i].height);
			}
		}
		if(obstacleRemains==0 && levelFlag==false){
			MyPanel.level++;
			levelFlag=true;
		}
		
	}
	
}

class LevelTwoObstacles{
	private int x=100;
	private int y=50;
	private int length=20;
	private static boolean levelFlag=false;
	//static boolean reConfigure=false;
	static Rectangle [] r;
	final int NUM_OF_OBSTACLES=6;
	static int obstacleRemains=6;
	
	public LevelTwoObstacles(){
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES/2 ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
		x=100;
		y=y+30;
		for(int i=NUM_OF_OBSTACLES/2; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
	}
	
	public void reConfigureTheState(){
		x=100;
		y=50;
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES/2 ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
		x=100;
		y=y+30;
		for(int i=NUM_OF_OBSTACLES/2; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
		levelFlag=false;
		obstacleRemains=6;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.cyan);
		/*if(reConfigure==true){
			//System.out.println(reConfigure);
			this.reConfigureTheState();
			reConfigure=false;
		}*/
		for(int i=0; i<obstacleRemains; i++){
			if(i==Ball.clashWith){
				r[i]=r[obstacleRemains-1];
				r[obstacleRemains-1]=null;
				obstacleRemains--;
				Ball.clashWith=-1;
				continue;
			}else{
				g.fillRect(r[i].x,r[i].y, r[i].width, r[i].height);
			}
		}
		if(obstacleRemains==0 && levelFlag==false){
			MyPanel.level++;
			levelFlag=true;
		}
		
	}
	
}

class LevelOneObstacles{	
	private int x=100;
	private int y=50;
	private int length=20;
	private static boolean levelFlag=false;
	static Rectangle [] r;
	final int NUM_OF_OBSTACLES=3;
	static int obstacleRemains=3;
	
	public LevelOneObstacles(){
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
	}
	
	public void reConfigureTheState(){
		x=100;
		y=50;
		r = new Rectangle[NUM_OF_OBSTACLES]; 
		for(int i=0; i<NUM_OF_OBSTACLES ; i++){
			r[i]=new Rectangle(x,y,length,length);
			x=x+30;
		}
		obstacleRemains=3;
		levelFlag=false;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.blue);
		for(int i=0; i<obstacleRemains; i++){
			if(i==Ball.clashWith){
				r[i]=r[obstacleRemains-1];
				r[obstacleRemains-1]=null;
				obstacleRemains--;
				Ball.clashWith=-1;
				continue;
			}else{
				g.fillRect(r[i].x,r[i].y, r[i].width, r[i].height);
			}
		}
		if(obstacleRemains==0 && levelFlag==false){
			MyPanel.level++;
			levelFlag=true;
		}
		
	}
	
}


