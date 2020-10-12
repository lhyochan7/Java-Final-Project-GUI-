package finalProject;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.io.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Main {
	private JFrame frame;
	private JScrollPane scroll;
	private JPanel panel;
	public static JLabel time;
	private int pos = 0, count = 0;
	private String storyLine[] = new String[50];
	public static int answer = (int) (Math.random()*(999 - 0 + 1) + 1);
	private static int copy = answer; 
	public static int[] hint = new int[3];
	static int divisor = 100;
	private static int cnt_down = 900, cnt_up=0;
	public static int min_down, sec_down, min_up, sec_up;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(answer);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 696, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		//change answer key to digit for each game
		for(int i = 0; i<3; i++) {
			hint[i] = copy/divisor;
			copy -= hint[i]*divisor;
			divisor /= 10;
		}

		//read lines from file txt and store them inside string array 
		try {
			File file=new File("story.txt");
			FileReader reader=new FileReader(file);
			BufferedReader buf=new BufferedReader(reader);
			String line = buf.readLine();
			while((line=buf.readLine())!=null) {
				storyLine[pos++] = line;
			}
			buf.close();
		} catch(IOException e) {
			System.out.println("File read error");
		}

		//BGM play
		try
		{
			AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("BGM.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(bgm);
			clip.start();
		}
		catch (Exception ex) {
			
		}
		
		//Text for Story settings (Text Area)
		JTextArea storyText = new JTextArea("Click Here and press Enter to Play Game\n");
		storyText.setBackground(new Color(204, 204, 204));
		storyText.setEditable(false);
		storyText.setBounds(39, 288, 546, 249);
		frame.getContentPane().add(storyText);

		//Pressing Enter to read line by line from file
		storyText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {

					if(count < 50 ) {
						if(storyLine[count] == null) 
							storyText.append("Search the room and try to escape!\n");
						else 
							storyText.append(storyLine[count] +"\n");
						count++;
					}
				}
			}
		});

		//panel initalizaiton
		panel = new JPanel();
		panel.setBounds(0, 0, 696, 640);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//stopwatch
		time = new JLabel("");
		time.setForeground(Color.RED);
		time.setFont(new Font("±¼¸²", Font.BOLD, 25));
		time.setBounds(594, 0, 102, 41);
		panel.add(time);
		ActionListener actListner = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent event) {
	            cnt_down -= 1;
	            cnt_up += 1;
	            min_down = cnt_down/60;
	            sec_down = cnt_down%60;
	            min_up = cnt_up/60;
	            sec_up = cnt_up%60;
	            
	            if(sec_down < 10 && sec_down >=0) {
	            	time.setText(String.valueOf(min_down) + ":0" + String.valueOf(sec_down));
	            } else {
	            time.setText(String.valueOf(min_down) + ":" + String.valueOf(sec_down));
	            } 
	            
	            if(cnt_down == 0) {
	               JOptionPane.showMessageDialog(frame, "you failed to get out of the room");
	               frame.dispose();
	            }
	          }
	      };
		Timer timer = new Timer(1000, actListner);

		timer.start();

		//Scroll bar in Text Area
		scroll = new JScrollPane(storyText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(25, 477, 374, 137);
		panel.add(scroll);


		//Button to start minigame 1 (cipher game)
		JButton prob1 = new JButton();
		prob1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cipher game1 = new Cipher();
				game1.start();
			}
		});
		prob1.setOpaque(false);
		prob1.setContentAreaFilled(false);
		prob1.setBorderPainted(false);
		prob1.setBounds(139, 351, 33, 31);
		panel.add(prob1);


		//Button to start minigame 2 (baseball game)
		JButton prob2 = new JButton();
		prob2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "I looked at the wall and found numbers 0 to 9 scattered about in random order.\nNext to it is the phrase \"Choose three numbers.\"\nI don't think that means I can choose any number. What do I do? ");
				baseballgame game2 = new baseballgame();
				game2.start();
			}
		});
		prob2.setOpaque(false);
		prob2.setContentAreaFilled(false);
		prob2.setBorderPainted(false);
		prob2.setBounds(435, 171, 33, 31);
		panel.add(prob2);


		//Button to start minigame 3 (banana apple game)
		JButton prob3 = new JButton();
		prob3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banana game3 = new banana();
				game3.start();
			}
		});
		prob3.setOpaque(false);
		prob3.setContentAreaFilled(false);
		prob3.setBorderPainted(false);
		prob3.setBounds(619, 470, 28, 31);
		panel.add(prob3);


		//hidden button at bottom right shelf
		JButton hidden = new JButton();
		hidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "I don't think I should search here....");
			}
		});
		hidden.setOpaque(false);
		hidden.setContentAreaFilled(false);
		hidden.setBorderPainted(false);
		hidden.setBounds(547, 393, 68, 23);
		panel.add(hidden);


		//hidden button at door
		JButton hidden2 = new JButton();
		hidden2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Door's locked....");
			}
		});
		hidden2.setOpaque(false);
		hidden2.setContentAreaFilled(false);
		hidden2.setBorderPainted(false);
		hidden2.setBounds(226, 282, 41, 41);
		panel.add(hidden2);

		//hidden button at shelf next to door
		JButton hidden3 = new JButton();
		hidden3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "empty....");
			}
		});
		hidden3.setOpaque(false);
		hidden3.setContentAreaFilled(false);
		hidden3.setBorderPainted(false);
		hidden3.setBounds(346, 297, 28, 64);
		panel.add(hidden3);

		//hidden button at window
		JButton hidden4 = new JButton();
		hidden4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Window's closed....");
			}
		});
		hidden4.setOpaque(false);
		hidden4.setContentAreaFilled(false);
		hidden4.setBorderPainted(false);
		hidden4.setBounds(32, 210, 33, 64);
		panel.add(hidden4);

		//hidden button at cans on the floor
		JButton hidden5 = new JButton();
		hidden5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "only empty cans....");
			}
		});
		hidden5.setOpaque(false);
		hidden5.setContentAreaFilled(false);
		hidden5.setBorderPainted(false);
		hidden5.setBounds(241, 393, 79, 48);
		panel.add(hidden5);


		//Button to guess answer and open combination lock
		JButton guessAnswer = new JButton("Guess Password");
		guessAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chainLock lock = new chainLock();
				lock.start();
			}
		});
		guessAnswer.setBounds(469, 569, 146, 41);
		panel.add(guessAnswer);


		//Background settings
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("background.png"));
		background.setBounds(0, 0, 696, 640);
		panel.add(background);
	}
}







