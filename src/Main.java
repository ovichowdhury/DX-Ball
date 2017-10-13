import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args){
		try{
			MyFrame mainFrame = MyFrame.getInstance();
			mainFrame.setVisible(true);
			
			// Game loop
		
			while(true){
				while(mainFrame.panel.start){
					mainFrame.panel.ball.moveBall();
					mainFrame.panel.repaint();
					switch(MyPanel.level){
					case 1:
						Thread.sleep(6);
						break;
					case 2:
						Thread.sleep(5);
						break;
					case 3:
						Thread.sleep(5);
						break;
					default:
						Thread.sleep(4);
						break;
					
					}
					if(MyPanel.gameOverFlag==true){
						Audio.winningSound.play();
						int answer = JOptionPane.showConfirmDialog(mainFrame, "Want To Play?", "ExitBox", JOptionPane.YES_NO_OPTION);
						if(answer==0){
							MyPanel.level=1;
							MyPanel.gameOverFlag=false;
							mainFrame.panel.reConfigureStates();
							mainFrame.lPanel.run=true;
						}else{
							System.exit(0);
						}
					}
				}
				Thread.sleep(1);
			}
		}catch(Exception  | Error e){
			JOptionPane.showMessageDialog(null, "Error Occured");
			
		}
	
	}

}
