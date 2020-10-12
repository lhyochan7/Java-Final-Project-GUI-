package finalProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class encryptGame extends Cipher {
	
	public JFrame frame;
	private JTextArea problem2;
	public JTextField hint1, answer;
	public int hintCount = 0;
	public JPanel panel;
	public JLabel lock;
	public JLabel background;
	public String probWord = createRandomWord(5);
	public String exWord = createRandomWord(5);
	private int hint_num = Main.hint[0];

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encryptGame window = new encryptGame();
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
	public encryptGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame initialization
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setBounds(100, 100, 622, 593);

		//Problem #2 settings in Text Area
		problem2 = new JTextArea();
		problem2.append(" Letters appear on the box!..I should encrypt this word\n It might be the password for this lock\n Find the pattern for the encryption and encrypt the random letters");
		encryptToNum("JAVA");
		problem2.append("\n #1: JAVA => " + getEncryptedText());
		encryptToNum("ESCAPE");
		problem2.append("\n #2: ESCAPE => " + getEncryptedText());
		encryptToNum("ROOM");
		problem2.append("\n #3: ROOM => " + getEncryptedText());
		encryptToNum(exWord);
		problem2.append("\n #4: " + exWord + " => " + getEncryptedText());
		problem2.append("\n-------------------------------------------------------------------------------------" );
		encryptToNum(probWord);
		problem2.append("\n " + probWord + " => OOOOO");

		problem2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		problem2.setEditable(false);
		problem2.setBackground(Color.LIGHT_GRAY);
		problem2.setBounds(68, 34, 489, 234);
		frame.getContentPane().add(problem2);


		//if hint button is pressed shows hints in hint1 textfield
		JButton hint = new JButton("Hint");
		hint.setForeground(Color.BLACK);
		hint.setBackground(new Color(255, 255, 255));
		hint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintCount++;
				if(hintCount == 1) {
					hint1.setText("Hint #1: Think of LINES");
					System.out.println("ANSWER: " +  getEncryptedText());
				} else if(hintCount == 2) {
					hint1.setText("Hint #2: O[" + getEncryptedText().charAt(1) + "]OOO");
				} else if(hintCount == 3) {
					hint1.setText("Hint #3: O[" + getEncryptedText().charAt(1) + "]O[" + getEncryptedText().charAt(3) + "]O");
					hintCount=0;
				}
			}

		});
		hint.setBounds(34, 505, 93, 28);
		frame.getContentPane().add(hint);


		//Text field for hints
		hint1 = new JTextField();
		hint1.setEditable(false);
		hint1.setBounds(149, 505, 160, 28);
		frame.getContentPane().add(hint1);
		hint1.setColumns(10);

		//if guess button is pressed checks if the input in the answer text field is correct or wrong
		JButton guess = new JButton("Guess");
		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = answer.getText();  
				//if correct shows message with hint and closes current frame
				if(s1.compareTo(getEncryptedText()) == 0) {
					ImageIcon open = new ImageIcon("safeOpen.jpg");
					JOptionPane.showMessageDialog(frame, "Opened Safe Box!!!\nThe hint is " + hint_num, "Correct!", JOptionPane.INFORMATION_MESSAGE,open);
					frame.setVisible(false);
					frame.dispose();
				} else
					JOptionPane.showMessageDialog(frame, "Wrong Answer");
			}
		});
		guess.setBackground(new Color(255, 255, 255));
		guess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		guess.setBounds(350, 505, 93, 28);
		frame.getContentPane().add(guess);

		//text field to input answer
		answer = new JTextField();
		answer.setBounds(465, 505, 110, 28);
		frame.getContentPane().add(answer);
		answer.setColumns(10);

		//panel inititalization
		panel = new JPanel();
		panel.setBounds(0, 0, 618, 565);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//safe box image
		lock = new JLabel("New label");
		lock.setIcon(new ImageIcon("lock.jpg"));
		lock.setBounds(179, 299, 235, 163);
		panel.add(lock);

		//background image
		background = new JLabel("New label");
		background.setIcon(new ImageIcon("background.png"));
		background.setBounds(0, 0, 618, 565);
		panel.add(background);
	}
}
