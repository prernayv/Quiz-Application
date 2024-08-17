package QuizApplication;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class StudentDetails extends JFrame implements ActionListener {
    JButton cancel;
    String susername,sname;
    StudentDetails(String susername,String sname){
        this.susername=susername;
        this.sname=sname;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(10, 300, 850, 300);
        add(image1); 
        
        JLabel heading = new JLabel("YOUR Profile ");
        heading.setBounds(250,50,500,50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lbluser = new JLabel("UserName");
        lbluser.setBounds(70,150,100,20);
        lbluser.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(lbluser);
        
         JLabel username = new JLabel(" ");
         username.setBounds(250,150,100,20);
         username.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(username);
        
          JLabel lblname = new JLabel("Name");
        lblname.setBounds(70,210,100,20);
        lblname.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(lblname);
        
         JLabel name = new JLabel(" ");
         name.setBounds(250,210,100,20);
         name.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(name);
        
        JLabel lblemail = new JLabel("Email Address");
        lblemail.setBounds(70,270,200,20);
         lblemail.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(lblemail);
        
         JLabel emailid = new JLabel(" ");
         emailid.setBounds(250,270,400,30);
         emailid.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(emailid);
        
         JLabel pno = new JLabel("Phone Number");
        pno.setBounds(70,330,330,20);
        pno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(pno);
        
         JLabel num = new JLabel(" ");
         num.setBounds(250,330,150,20);
         num.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(num);
        
    
        
                try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from signIn where username ='"+susername+"'");
            while(rs.next()){
                username.setText(rs.getString("username"));
                name.setText(rs.getString("name"));
                emailid.setText(rs.getString("email"));
                num.setText(rs.getString("phoneno"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    
   
        
        cancel = new JButton("cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350,350,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
//        Image i2=i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
//         ImageIcon i3 =new ImageIcon(i2);
//         JLabel image =new JLabel(i3);
//         image.setBounds(20, 350,600 , 300);
//         add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Dashboard(susername,sname);
    }
    public static void main(String[]args){
        new StudentDetails("","");
    }
}
