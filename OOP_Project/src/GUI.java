import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    private static JLabel usernameLabel;
    private static JButton button1, button2, button3, button4, button5, button6;
    private static JFrame frame;

   public GUI(String Un) {
           frame = new JFrame();
           frame.setTitle("Library");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(600, 600);
           frame.setLayout(null);

           frame.getContentPane().setBackground(new Color(50, 50, 50));

           JPanel buttonsPanel = new JPanel(new GridLayout(2, 3));
           button1 = new JButton("BorrowBook");
           button1.setFocusable(false);
           button1.setBackground(new Color(70, 130, 180));
           button1.setForeground(Color.white);
           button1.setFont(new Font("SansSerif", Font.BOLD, 14));
           button2 = new JButton("ReturnBook");
           button2.setFocusable(false);
           button2.setBackground(new Color(70, 130, 180));
           button2.setForeground(Color.white);
           button2.setFont(new Font("SansSerif", Font.BOLD, 14));
           button3 = new JButton("BorrowedBooks");
           button3.setFocusable(false);
           button3.setBackground(new Color(70, 130, 180));
           button3.setForeground(Color.white);
           button3.setFont(new Font("SansSerif", Font.BOLD, 14));
           button4 = new JButton("Lost a book?");
           button4.setFocusable(false);
           button4.setBackground(new Color(70, 130, 180));
           button4.setForeground(Color.white);
           button4.setFont(new Font("SansSerif", Font.BOLD, 14));
           button5 = new JButton("FINES");
           button5.setFocusable(false);
           button5.setBackground(new Color(70, 130, 180));
           button5.setForeground(Color.white);
           button5.setFont(new Font("SansSerif", Font.BOLD, 14));
           button6 = new JButton("RL");
           button6.setFocusable(false);
           button6.setBackground(new Color(70, 130, 180));
           button6.setForeground(Color.white);
           button6.setFont(new Font("SansSerif", Font.BOLD, 14));
           button1.addActionListener(this);
           button2.addActionListener(this);
           button3.addActionListener(this);
           button4.addActionListener(this);
           button5.addActionListener(this);
           button6.addActionListener(this);
           buttonsPanel.add(button1);
           buttonsPanel.add(button2);
           buttonsPanel.add(button3);
           buttonsPanel.add(button4);
           buttonsPanel.add(button5);
           buttonsPanel.add(button6);
           buttonsPanel.setBounds(0, 30, 600, 540); // Set bounds for the buttons panel
           frame.add(buttonsPanel);

           usernameLabel = new JLabel(Un);
           usernameLabel.setBounds(10, 5, 150, 20); // Set bounds for the username label
           frame.add(usernameLabel);


           frame.setVisible(true);


           Account.UserLogged = Un;
           CheckFile.BookArray();

       }


        @Override
        public void actionPerformed(ActionEvent e) {

   }
}
