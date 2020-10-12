package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.Color;

public class banana {
	static Random r = new Random();
	static private JFrame frame;
	static private JTextField Dealer;
	static int banana,apple;
	static JLabel Player1;
	static JLabel Player2;
	static JLabel Player3;
	static JLabel Player4;
	static JLabel Player5;
	static JLabel Player6;
	static JLabel Player7;
	static JLabel Player8;
	static int score=0;
	static int check =0;
	ImageIcon ban = new ImageIcon("ba3.png"); 
	ImageIcon apl = new ImageIcon("aple.png"); 
	private int hint_num = Main.hint[2];
	
	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					banana window = new banana();
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
	public banana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 650, 500);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Banana Apple");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(232, 10, 148, 42);
		frame.getContentPane().add(lblNewLabel);

		JTextArea Description = new JTextArea("I looked around the room and saw bananas and apples.\n" + 
				"Bananas and apples... What does this mean?\r\n" + 
				"Looking closely, the paper says, \"Choose between banana and apple.\"\r\n" + 
				"What should I choose? \nYou just have to guess which one the dealer chooses between bananas and apples with eight other players.\nYou are given three chances to practice,\nand if you get three straight answers in the actual game,\nyou win the game.\n");
		Description.setBackground(Color.LIGHT_GRAY);
		Description.setFont(new Font("Monospaced", Font.PLAIN, 10));
		Description.setLineWrap(true);


		Description.setBounds(24, 58, 383, 157);
		frame.getContentPane().add(Description);

		JButton Banana = new JButton("Banana");
		Banana.setFont(new Font("±¼¸²", Font.PLAIN, 9));
		Banana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(banana < apple)
				{
					score++;
					if(score == 3 && check==0)
					{
						JOptionPane.showMessageDialog(frame, "You are successful\nThe hint is " + hint_num);
						frame.setVisible(false);
						frame.dispose();
						//hint
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Great!");
						game();
					}


				}
				else
				{
					JOptionPane.showMessageDialog(frame, "You are wrong!");
					score=0;
					game();
				}

			}
		});
		Banana.setBounds(386, 411, 68, 42);
		frame.getContentPane().add(Banana);

		Player2 = new JLabel("Player2");
		Player2.setForeground(Color.WHITE);
		Player2.setBounds(166, 244, 48, 55);
		frame.getContentPane().add(Player2);
		Player2.setVisible(false);

		Player3 = new JLabel("New label");
		Player3.setForeground(Color.WHITE);
		Player3.setBounds(288, 244, 59, 55);
		frame.getContentPane().add(Player3);
		Player3.setVisible(false);

		Player4 = new JLabel("New label");
		Player4.setForeground(Color.WHITE);
		Player4.setBounds(433, 244, 48, 55);
		frame.getContentPane().add(Player4);
		Player4.setVisible(false);

		Player6 = new JLabel("New label");
		Player6.setForeground(Color.WHITE);
		Player6.setBounds(166, 319, 68, 55);
		frame.getContentPane().add(Player6);
		Player6.setVisible(false);

		Player7 = new JLabel("New label");
		Player7.setForeground(Color.WHITE);
		Player7.setBounds(288, 319, 59, 55);
		frame.getContentPane().add(Player7);
		Player7.setIcon(new ImageIcon("ba3.png"));
		Player7.setVisible(false);

		Player8 = new JLabel("New label");
		Player8.setForeground(Color.WHITE);
		Player8.setBounds(433, 319, 59, 55);
		frame.getContentPane().add(Player8);
		Player8.setVisible(false);

		JButton Apple = new JButton("Apple");
		Apple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(banana > apple)
				{
					score++;
					if(score == 3)
					{
						JOptionPane.showMessageDialog(frame, "You are successful\nThe hint is " + hint_num);
						frame.setVisible(false);
						frame.dispose();
						//hint
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Great!");
						game();
					}


				}
				else
				{
					JOptionPane.showMessageDialog(frame, "You are wrong!");
					score=0;
					game();
				}
			}
		});
		Apple.setFont(new Font("±¼¸²", Font.PLAIN, 9));
		Apple.setBounds(466, 411, 68, 42);
		frame.getContentPane().add(Apple);

		JButton Practice = new JButton("Practice");
		Practice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				score=0;
				check=1;
				Player1.setIcon(new ImageIcon("ba3.PNG"));   
				game();

			}
		});
		Practice.setBounds(10, 398, 81, 55);
		frame.getContentPane().add(Practice);

		JButton Real = new JButton("Start");
		Real.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check=0;
				score=0;
				game();
			}
		});
		Real.setBounds(114, 398, 81, 55);
		frame.getContentPane().add(Real);

		Dealer = new JTextField();
		Dealer.setBounds(430, 105, 179, 62);
		frame.getContentPane().add(Dealer);
		Dealer.setColumns(10);;

		Player1 = new JLabel("New label");
		Player1.setForeground(Color.WHITE);
		Player1.setBounds(24, 250, 48, 42);
		frame.getContentPane().add(Player1);
		Player1.setVisible(false);
		Player1.setIcon(new ImageIcon("aple.png"));

		Player5 = new JLabel("New label");
		Player5.setForeground(Color.WHITE);
		Player5.setBounds(24, 323, 85, 47);
		frame.getContentPane().add(Player5);
		Player5.setVisible(false);




	}

	public static void game()
	{
		int b = r.nextInt(4);
		int a = r.nextInt(2);
		banana=0;
		apple=0;

		switch(b)
		{
		case 0 : 
			Dealer.setText("Dealer : I lOVE Banana.\n");
			break;
		case 1 :
			Dealer.setText("Dealer : I lOVE Apple.\n");
			break;
		case 2 :
			Dealer.setText("Dealer : I eat Apple.\n");
			break;
		case 3:
			Dealer.setText("Dealer : I eat Banana.\n");
			break;
		}

		if(a == 1)
		{
			Player1.setText("Banana");      
			banana++;
		}
		else
		{
			Player1.setText("Apple");
			apple++;
		}
		a = set(a);

		if(a == 1)
		{
			Player2.setText("Banana");
			banana++;
		}
		else
		{
			Player2.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{
			Player3.setText("Banana");
			banana++;
		}
		else
		{
			Player3.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{
			Player4.setText("Banana");
			banana++;
		}
		else
		{
			Player4.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{
			Player5.setText("Banana");
			banana++;
		}
		else
		{
			Player5.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{
			Player6.setText("Banana");
			banana++;
		}
		else
		{
			Player6.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{
			Player7.setText("Banana");
			banana++;
		}
		else
		{
			Player7.setText("Apple");
			apple++;
		}
		a = set(a);
		if(a == 1)
		{   
			banana++;
			if(apple == banana)
			{
				Player8.setText("Apple");
				banana--;
				apple++;
			}
			else
				Player8.setText("Banana");

		}
		else
		{ 
			apple++;
			if(banana == apple)
			{
				Player8.setText("Banana");
				apple--;
				banana++;
			}
			else
				Player8.setText("Apple");

		}
		Player1.setVisible(true);
		Player2.setVisible(true);
		Player3.setVisible(true);
		Player4.setVisible(true);
		Player5.setVisible(true);
		Player6.setVisible(true);
		Player7.setVisible(true);
		Player8.setVisible(true);

	}

	public static int set(int a)
	{
		Random r = new Random();
		a = r.nextInt(2);
		return a;
	}
}