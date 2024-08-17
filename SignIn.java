package QuizApplication;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.*; // for sub package of swing
import java.awt.event.*;
import java.sql.*;

public class SignIn extends JFrame implements ActionListener {
    JButton back, create;

    JTextField username, name,email,phno;
    JPasswordField password;

    SignIn() {
        setBounds(450, 150, 700, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 400);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 3), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(249, 194, 56)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(173, 216, 230));
        add(panel);
        

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(120, 50, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(300, 50, 200, 30);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(120, 100, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(300, 100, 200, 30);
        panel.add(name);
        
        JLabel lblemail = new JLabel("Email-Mail");
        lblemail.setBounds(120, 150, 140, 20);
        lblemail.setForeground(Color.GRAY);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblemail);

        email = new JTextField();
        email.setBounds(300, 150, 200, 30);
        panel.add(email);
        
        JLabel lblphno = new JLabel("PhoneNo");
        lblphno.setBounds(120, 200, 140, 20);
        lblphno.setForeground(Color.GRAY);
        lblphno.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblphno);

        phno = new JTextField();
        phno.setBounds(300, 200, 200, 30);
        panel.add(phno);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(120, 250, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblpassword);

        password = new JPasswordField();
        password.setBounds(300, 250, 200, 30);
        panel.add(password);
        

        create = new JButton("Create");
        create.setBounds(120, 300, 150, 30);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBounds(320, 300, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String susername = username.getText();
            String sname = name.getText();
            String semail = email.getText();
            String sphno = phno.getText();
            String spassword = new String(password.getPassword());

            try {
                Conn c = new Conn(); // connection established

                String query = "insert into signIn values('" + susername + "','" + sname + "','" + semail + "','" + sphno + "','" + spassword + "')";

                c.s.executeUpdate(query); // execute

                JOptionPane.showMessageDialog(null, "Account Created successfully");

                setVisible(false);
                new Login(sname); // Pass the name JTextField reference
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login(name.getText()); // Pass the name JTextField reference
        }
    }

    public static void main(String[] args) {
        new SignIn();
    }
}

    
