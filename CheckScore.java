package QuizApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CheckScore extends JFrame implements ActionListener {
    JButton cancel;
    String susername,sname;
    CheckScore(String susername,String sname){
        this.susername=susername;
        this.sname=sname;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("YOUR SCORES ");
        heading.setBounds(250,50,500,50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/score.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(350, 170, 450, 200);
        image1.setLayout(null); // Setting layout to null so we can add components with custom positions
        add(image1); 
        
        JLabel java = new JLabel("JAVA");
        java.setBounds(70,150,100,20);
        java.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(java);
        
         JLabel javano = new JLabel(" ");
         javano.setBounds(250,150,100,20);
         javano.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(javano);
        
          JLabel python = new JLabel("PYTHON");
        python.setBounds(70,210,100,20);
        python.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(python);
        
         JLabel pythonno = new JLabel(" ");
         pythonno.setBounds(250,210,100,20);
         pythonno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(pythonno);
        
        JLabel C = new JLabel("C_Programming");
        C.setBounds(70,270,200,30);
         C.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(C);
        
         JLabel Cno = new JLabel(" ");
         Cno.setBounds(250,270,400,30);
         Cno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(Cno);
        
         JLabel Cpp = new JLabel("C++");
        Cpp.setBounds(70,330,330,20);
        Cpp.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(Cpp);
        
         JLabel Cppno = new JLabel(" ");
         Cppno.setBounds(250,330,150,20);
         Cppno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(Cppno);
        
        JLabel sql = new JLabel("SQL");
        sql.setBounds(70,390,330,20);
        sql.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(sql);
        
         JLabel sqlno = new JLabel(" ");
         sqlno.setBounds(250,390,150,20);
         sqlno.setFont(new Font ("Tahoma",Font.PLAIN,20));
        add(sqlno);  
        
               try{
                   Conn c = new Conn();
                   ResultSet rs = c.s.executeQuery("select * from score where username ='"+susername+"'");
                     while(rs.next()){
                           javano.setText(rs.getString("java_score"));
                           pythonno.setText(rs.getString("python_score"));
                           Cno.setText(rs.getString("C_Programming_score"));
                           Cppno.setText(rs.getString("Cpp_score"));
                           sqlno.setText(rs.getString("SQL_score"));
               
                   }
               }catch(Exception e){
                      e.printStackTrace();
               }
    
   
        
        cancel = new JButton("cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350,450,100,25);
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
        new CheckScore("","");
    }
}
