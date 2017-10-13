import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class LevelPanel extends JPanel implements Runnable{
	Thread th;
	JLabel label;
	boolean gameIsAlive=true;
	private int time=0;
	boolean run=true;
	
	public LevelPanel(){
		th = new Thread(this);
		
		this.setSize(300, 45);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		
		label = new JLabel();
		label.setText("You Are In Label - " +String.valueOf(MyPanel.level) + "  Time : " + String.valueOf(time));
		label.setBounds(10, 0, 300, 35);
		this.add(label);
		
		th.start();
		
	}

	@Override
	public void run() {
		
		while(gameIsAlive){
			while(run){
				if(MyPanel.gameOverFlag==true){
					//label.setBounds(10, 0, 300, 35);
					label.setText("Congratulations Game Is Over " + "(Total Time : " +String.valueOf(time) +" )");
					time=0;
					run=false;
				}	
				else
					label.setText("You Are In Level - " +String.valueOf(MyPanel.level) + "  Time : " + String.valueOf(time));
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					time=time+1;
				}
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}