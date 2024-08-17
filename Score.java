 package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    JLabel scoredetails, lblscore;
    JButton Exit, dashboard;
    String sname;
    String susername;

    Score(String sname, String susername, int score) {
        this.sname = sname;
        this.susername = susername;
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/star.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(50, 150, 600, 200);
        image1.setLayout(null); // Setting layout to null so we can add components with custom positions
        add(image1); 

        scoredetails = new JLabel("YOUR SCORE " + sname);
        scoredetails.setBounds(150, 50, 500, 50);
        scoredetails.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        scoredetails.setForeground(Color.BLACK);
        add(scoredetails);

        // Place the score label onto the image
        lblscore = new JLabel("" + score);
        lblscore.setBounds(250, 0, 300, 200);  // Position lblscore inside the image1 label
        lblscore.setFont(new Font("Viner Hand ITC", Font.BOLD, 150));
        lblscore.setForeground(Color.BLACK);
        image1.add(lblscore);  // Add lblscore to image1

        Exit = new JButton("EXIT");
        Exit.setBounds(400, 400, 150, 30);
        Exit.setBackground(Color.black);
        Exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Exit.setForeground(Color.white);
        Exit.addActionListener(this);
        add(Exit);

        dashboard = new JButton("Dashboard");
        dashboard.setBounds(150, 400, 200, 30);
        dashboard.setBackground(Color.black);
        dashboard.setFont(new Font("Tahoma", Font.PLAIN, 22));
        dashboard.setForeground(Color.white);
        dashboard.addActionListener(this);
        add(dashboard);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Exit) {
            setVisible(false);
        } else if (ae.getSource() == dashboard) {
            setVisible(false);
            new Dashboard(susername, sname);
        }
    }

    public static void main(String[] args) {
        new Score("user", "", 0);
    }
}
