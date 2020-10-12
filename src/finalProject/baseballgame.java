package finalProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class baseballgame {

   private JFrame frame;
   private JTextField input1;
   private JTextField input2;
   private JTextField input3;
   private static int rnd = (int) (Math.random()*(999 - 0 + 1) + 1);
   private static int copy = rnd;
   private static int divisor = 100;
   private int strike = 0;
   private int ball = 0;
   private int[] computer = new int [3];
   private int[] user = new int [3];
   private int num= 0;
   private String game = "";
   private int hint_num = Main.hint[1];


   /**
    * Launch the application.
    */
   public static void start() {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               baseballgame window = new baseballgame();
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
   public baseballgame() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.DARK_GRAY);
      frame.setBounds(100, 100, 355, 423);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.setResizable(false);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.DARK_GRAY);
      panel.setBounds(0, 0, 341, 386);
      frame.getContentPane().add(panel);
      panel.setLayout(null);

      JLabel intro = new JLabel("Try to find the numbers in the correct position");
      intro.setForeground(Color.LIGHT_GRAY);
      intro.setHorizontalAlignment(SwingConstants.CENTER);
      intro.setBounds(11, 65, 318, 62);
      panel.add(intro);

      JButton btn_s = new JButton("Start");
      btn_s.setBackground(Color.LIGHT_GRAY);
      btn_s.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(rnd);
            intro.setText("You can get the password. Go!");
            
            for(int i = 0 ; i < 3 ; i++) {
          	  computer[i]= copy/divisor;
          	  copy -= computer[i]*divisor;
          	  divisor /= 10;
            }
         }
      });
      btn_s.setBounds(89, 20, 154, 35);
      panel.add(btn_s);

      input1 = new JTextField();
      input1.setBounds(26, 139, 51, 35);
      panel.add(input1);
      input1.setColumns(10);

      input2 = new JTextField();
      input2.setBounds(89, 138, 51, 35);
      panel.add(input2);
      input2.setColumns(10);

      input3 = new JTextField();
      input3.setBounds(152, 139, 51, 35);
      panel.add(input3);
      input3.setColumns(10);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(33, 185, 277, 179);
      panel.add(scrollPane);
      
      JTextArea textArea = new JTextArea();
      scrollPane.setViewportView(textArea);
      

      JButton btn = new JButton("Enter");
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(e.getSource() == (JButton)btn) {
               int submitAnswer = Integer.parseInt(input1.getText()) * 100 + Integer.parseInt(input2.getText()) * 10 + Integer.parseInt(input3.getText());
               if(submitAnswer == rnd) {
                  JOptionPane.showMessageDialog(null, "You've guessed correctly\nThe hint is " + hint_num);
                  frame.dispose();
               }
               else {
            	  strike=0; ball=0;
                  user[0] = Integer.parseInt(input1.getText());
                  user[1] = Integer.parseInt(input2.getText());
                  user[2] = Integer.parseInt(input3.getText());

                  for(int i = 0 ; i < 3 ; i++){
                     for(int a = 0 ; a < 3 ; a++){
                        if(computer[i] == user[a]){

                           if(i == a){
                              strike++;
                              intro.setText("STRIKE!!");
                           }else{
                              ball++;
                              intro.setText("BALL!!");
                           }
                        }                         
                     }  
                  }
                  game = game + " Trial No. " + (num+1) + ") " + user[0] + "  -  " + user[1] + "  -  " + user[2] +  "      [" + strike + "strike / " + ball + "ball" + "]"+"\n";
                  textArea.setText(game);
                  num += 1;
               }
            }

         }
      });
      btn.setBackground(Color.LIGHT_GRAY);
      btn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         }
      });
      btn.setBounds(215, 144, 95, 23);
      panel.add(btn);
   }
}