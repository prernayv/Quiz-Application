package QuizApplication;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener
{   
    JLabel text,userid,password;
    JButton login, signup , clear;
    JTextField userTextField;
    JPasswordField pinTextField;
    String sname;
     Login(String sname)
     {
        this.sname=sname;
         
         setTitle("QUIZ APPLICATION");
         setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/wlcm.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 800, 480);
        add(image1);

         
          text = new JLabel("Welcome to the Quiz");
         text.setFont(new Font("Osward",Font.BOLD,38));
         text.setBounds(200,40 ,400,40 );
         image1.add(text);
         
          userid = new JLabel("User Id");
         userid.setFont(new Font("Raleway",Font.BOLD,28));
         userid.setBounds(120,150 ,150,30 );
         image1.add(userid);
         
          userTextField = new JTextField();
         userTextField.setBounds(300, 150, 230, 30);
         userTextField.setFont(new Font("Arial",Font.BOLD,14));
         image1.add(userTextField);
         
          password = new JLabel("Password");
         password.setFont(new Font("Raleway",Font.BOLD,28));
         password.setBounds(120,220 ,250,30 );
         image1.add(password);
         
          pinTextField = new JPasswordField();
         pinTextField.setBounds(300, 220, 230, 30);
         pinTextField.setFont(new Font("Arial",Font.BOLD,14));
         image1.add(pinTextField);
         
          login = new JButton("LOGIN");
         login.setBounds(300, 300, 100, 30);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
        login.addActionListener(this);
         image1.add(login);
         
          signup = new JButton("SIGN UP");
         signup.setBounds(300, 350, 230, 30);
         signup.setBackground(Color.BLACK);
         signup.setForeground(Color.WHITE);
          signup.addActionListener(this);
         image1.add(signup);
         
          clear = new JButton("CLEAR");
         clear.setBounds(430, 300, 100, 30);
         clear.setBackground(Color.BLACK);
         clear.setForeground(Color.WHITE);
          clear.addActionListener(this);
         image1.add(clear);
         
         getContentPane().setBackground(Color.WHITE);
         
         
         setSize(800,480);
         setVisible(true);
         setLocation(350,200);
     }
         
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String susername=userTextField.getText();
            String spassword =pinTextField.getText();
            
            
            try{
                Conn c =new Conn();
                String query ="select * from signIn where username = '"+susername+"' and password = '"+spassword+"'";// table value extraction
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    
                  setVisible(false);
                  new Dashboard(susername,sname);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid login");
                    userTextField.setText(" ");
                    pinTextField.setText(" ");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == clear){
              userTextField.setText(" ");
              pinTextField.setText(" ");
        }else if(ae.getSource()==signup){
            setVisible(false);
            
            new SignIn();
            
        }
        
    }
    
      

    public static void main(String args[]) {
        new Login("");
       
    }
}
    
