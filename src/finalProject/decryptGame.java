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

public class decryptGame extends Cipher {

	public JFrame frame;
	public JTextField hint1, answer;
	public JTextArea problem1;
	public int hintCount = 0;
	public JPanel panel;
	public JLabel lock;
	public JLabel background;
	public String probWord = createRandomWord(5);
	public String exWord = createRandomWord(5);

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					decryptGame window = new decryptGame();
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
	public decryptGame() {
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

		//Problem #1 settings in Text Area
		problem1 = new JTextArea();
		problem1.append(" There's a small note on the safe box...I think it's a key\r\n Find the pattern for the encryption and decrypt the random letters");
		encrypt("JAVA");
		problem1.append("\n #1: JAVA => " + getEncryptedText());
		encrypt("ESCAPE");
		problem1.append("\n #2: ESCAPE => " + getEncryptedText());
		encrypt("ROOM");
		problem1.append("\n #3: ROOM => " + getEncryptedText());
		encrypt(exWord);
		problem1.append("\n #4: " + exWord + "=>  " + getEncryptedText());
		problem1.append("\n-------------------------------------------------------------------------------------" );
		encrypt(probWord);
		problem1.append("\n OOOOO => " + getEncryptedText());
		problem1.append("\n\n ***** Note: Not an actual word *****");	

		problem1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		problem1.setEditable(false);
		problem1.setBackground(Color.LIGHT_GRAY);
		problem1.setBounds(68, 34, 489, 234);
		frame.getContentPane().add(problem1);

		//sets the answer for the problem
		setDecryptedText(probWord);

		//if hint button is pressed shows hints in hint1 textfield
		JButton hint = new JButton("Hint");
		hint.setForeground(Color.BLACK);
		hint.setBackground(new Color(255, 255, 255));
		hint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintCount++;
				if(hintCount == 1) {
					hint1.setText("Hint #1: Think of SHIFTED");
					System.out.println("ANSWER: " +  getDecryptedText());
				} else if(hintCount == 2) {
					hint1.setText("Hint #2: O[" + getDecryptedText().charAt(1) + "]OOO");
				} else if(hintCount == 3) {
					hint1.setText("Hint #3: O[" + getDecryptedText().charAt(1) + "]O[" + getDecryptedText().charAt(3) + "]O");
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
				//if answer is correct closes the current frame and opens encryptGame frame
				if(s1.toUpperCase().compareTo(getDecryptedText()) == 0) {
					JOptionPane.showMessageDialog(frame, "Correct!!!");
					frame.setVisible(false);
					frame.dispose();
					encryptGame frame2 = new encryptGame();
					frame2.start();
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

		//panel initialization
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
