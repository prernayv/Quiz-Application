package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    
    JButton Next, back;
    String sname,susername;
    Rules(String sname,String username) {
        this.sname=sname;
        this.susername=susername;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+sname+" to Simple Minds");
        heading.setBounds(200, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Rules.png"));
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 10, 700, 600);
        image1.setLayout(null); // Setting layout to null so we can add components with custom positions
        add(image1); 
        
        
        JLabel rules = new JLabel();
        rules.setBounds(100, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. There will be 10 qustions." + "<br><br>" +
                "2. Each question have four options and you have to select one." + "<br><br>" +
                "3. There will timer, for each question you have 15 seconds." + "<br><br>" +
                "4. After 15 sec you automatically forwarded to next question." + "<br><br>" +
                "5. There is no negative marking." + "<br><br>" +
                "6. You have one lifetime for any one question which hide two uncorrect option." + "<br><br>" +
                "7. Give your best, All the best." + "<br><br>" +
                //"8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        image1.add(rules);
        
      
        
        Next = new JButton("NEXT");
        Next.setBounds(400, 500, 100, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        image1.add(Next);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {
            setVisible(false);
            new ListOfQuiz(sname,susername);
        } 
    }
    
    public static void main(String[] args) {
        new Rules("user","");
    }
}
