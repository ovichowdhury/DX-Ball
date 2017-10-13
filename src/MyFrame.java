import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class MyFrame extends JFrame {
	//JLabel background;
	MyPanel panel;
	LevelPanel lPanel;
	private static MyFrame gameFrame;
	private JMenuBar bar;
	private JMenu file;
	private JMenu help;
	private JMenu view;
	private JMenu background;
	private JMenuItem pause;
	private JMenuItem black;
	private JMenuItem white;
	private JMenuItem exit;
	private JMenuItem about;
	
	private MyFrame(){
		this.setTitle("Desk Ball");
		this.setSize(300, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocation(300, 200);
		//adding menu
		this.addMenu();
		// adding panel
		panel = new MyPanel();
		panel.init();
		this.add(panel);
		
		// adding icon
		
		try {
			this.setIconImage(ImageIO.read(new File("resources/magic_ball.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// adding level panel
		lPanel = new LevelPanel();
		lPanel.setBounds(0, 270, 300, 45);
		this.add(lPanel);
		
	}
	
	private void addMenu(){
		bar = new JMenuBar();
		file = new JMenu("File");
		help = new JMenu("Help");
		view = new JMenu("View");
		background = new JMenu("Background");
		pause = new JMenuItem("Pause Game");
		black = new JMenuItem("Black");
		white = new JMenuItem("White");
		exit = new JMenuItem("Exit");
		about = new JMenuItem("About");
		
		bar.setBorder(BorderFactory.createLineBorder(Color.green));
		background.add(black);
		background.add(white);
		view.add(background);
		file.add(pause);
		file.add(exit);
		help.add(about);
		bar.add(file);
		bar.add(view);
		bar.add(help);
		
		
		this.setJMenuBar(bar);
		this.addActionListenerForMenu();
	}
	
	private void addActionListenerForMenu(){
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Simple Desk Ball Game Developed By Chowdhury Nahid and Anisur Rahman");
			}
			
		});
		
		black.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.setBackground(Color.black);
			}
			
		});
		
		white.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.setBackground(Color.white);
			}
			
		});
		
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.start=false;
				
			}
			
		});
	}
	
	public static MyFrame getInstance(){
		if(gameFrame==null){
			gameFrame = new MyFrame(); 
		}
		return gameFrame;
	}

}
