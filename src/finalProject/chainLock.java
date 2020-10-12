package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class chainLock {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chainLock window = new chainLock();
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
	public chainLock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 511, 353);
		frame.setResizable(false);
		JTextField count_num100 = new JTextField("0");
		count_num100.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		count_num100.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField count_num10 = new JTextField("0");
		count_num10.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		count_num10.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField count_num1 = new JTextField("0");
		count_num1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		count_num1.setHorizontalAlignment(SwingConstants.CENTER);

		JButton up100 = new JButton("+");
		up100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)up100) {
					int num100 = Integer.parseInt(count_num100.getText());
					if(num100 >= 0 && num100 <= 9)
					{
						num100 += 1;
					}
					if(num100 == 10) {
						num100 = 0;
					}
					count_num100.setText(String.valueOf(num100));
				}
			}
		});

		JButton up10 = new JButton("+");
		up10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)up10) {
					int num10 = Integer.parseInt(count_num10.getText());
					if(num10 >= 0 && num10 <= 9)
					{
						num10 += 1;
					}
					if(num10 == 10) {
						num10 = 0;
					}
					count_num10.setText(String.valueOf(num10));
				}
			}
		});

		JButton up1 = new JButton("+");
		up1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)up1) {
					int num1 = Integer.parseInt(count_num1.getText());
					if(num1 >= 0 && num1 <= 9)
					{
						num1 += 1;
					}
					if(num1 == 10) {
						num1 = 0;
					}
					count_num1.setText(String.valueOf(num1));
				}
			}
		});

		JButton down100 = new JButton("-");
		down100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)down100) {
					int num100 = Integer.parseInt(count_num100.getText());
					if(num100 >= 0 && num100 <= 9)
					{
						num100 -= 1;
					}
					if(num100 == -1) {
						num100 = 9;
					}
					count_num100.setText(String.valueOf(num100));
				}
			}
		});

		JButton down10 = new JButton("-");
		down10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)down10) {
					int num10 = Integer.parseInt(count_num10.getText());
					if(num10 >= 0 && num10 <= 9)
					{
						num10 -= 1;
					}
					if(num10 == -1) {
						num10 = 9;
					}
					count_num10.setText(String.valueOf(num10));
				}
			}
		});

		JButton down1 = new JButton("-");
		down1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)down1) {
					int num1 = Integer.parseInt(count_num1.getText());
					if(num1 >= 0 && num1 <= 9)
					{
						num1 -= 1;
					}
					if(num1 == -1) {
						num1 = 9;
					}
					count_num1.setText(String.valueOf(num1));
				}
			}
		});

		JButton btnNewButton = new JButton("Submit!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == (JButton)btnNewButton) {
					int submitAnswer = Integer.parseInt(count_num100.getText()) * 100 + Integer.parseInt(count_num10.getText()) * 10 + Integer.parseInt(count_num1.getText());
					if(submitAnswer == Main.answer) {
						Main.time.setVisible(false);
						JOptionPane.showMessageDialog(frame, "Correct!\n It took " + String.valueOf(Main.min_up) + ":" + String.valueOf(Main.sec_up));
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong...... Try Again");
					}
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(count_num100)
								.addComponent(down100, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(up100, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addGap(46)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(up10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(down10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(count_num10, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(up1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(down1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(count_num1, Alignment.LEADING))
						.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(139)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addGap(148))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(up100)
								.addComponent(up1)
								.addComponent(up10))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(count_num100, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(count_num1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(count_num10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(down100)
								.addComponent(down1)
								.addComponent(down10))
						.addGap(18)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(124, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}