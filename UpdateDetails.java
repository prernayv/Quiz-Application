
package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class UpdateDetails extends JFrame implements ActionListener{
    JTextField tfemail,tfphone;
    JButton Update,cancel;
   
    String susername,sname;
    UpdateDetails(String susername,String sname){
        
        this.susername=susername;
        this.sname=sname;
        setBounds(300,150,700,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 70, 650, 350);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(249, 194, 56), 2), "Update Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(249, 194, 56)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Update Information ");
        heading.setBounds(180,20,500,50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,70,100,20);
        lblname.setFont(new Font ("Tahoma",Font.BOLD,20));
        panel.add(lblname);
        
         JLabel name = new JLabel(" ");
         name.setBounds(230,70,200,20);
        panel.add(name);
        
        JLabel lblemail = new JLabel("Email-Id");
        lblemail.setBounds(50,140,100,20);
        lblemail.setFont(new Font ("Tahoma",Font.BOLD,20));
        panel.add(lblemail);
        
         tfemail = new JTextField();
         tfemail.setBounds(230,140,200,20);
        panel.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone-no");
         lblphone.setBounds(50,210,100,20);
          lblphone.setFont(new Font ("Tahoma",Font.BOLD,20));
        panel.add(lblphone);
        
         tfphone = new JTextField();
         tfphone.setBounds(230,210,200,20);
        panel.add(tfphone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from SignIn where username ='"+susername+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phoneno"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         Update = new JButton("Update");
        Update.setBackground(Color.black);
       Update.setForeground(Color.white);
        Update.setBounds(70,260,100,25);
        Update.addActionListener(this);
        panel.add(Update);
          
        cancel = new JButton("cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(230,260,100,25);
        cancel.addActionListener(this);
        panel.add(cancel);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
//        Image i2=i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
//         ImageIcon i3 =new ImageIcon(i2);
//         JLabel image =new JLabel(i3);
//         image.setBounds(550, 50,400 , 300);
//         add(image);
        
     setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Update){
           //String labelname = lblname.getText();
           String email = tfemail.getText();
           String phone = tfphone.getText();
           
           try{
               Conn c= new Conn();
               
               c.s.executeUpdate("update SignIn set email='"+email+"',phoneno='"+phone+"' where username ='"+susername+"'");
               
               JOptionPane.showMessageDialog(null, "User information updated successfully");
               setVisible(false);
               new Dashboard(susername,sname);
           } catch (Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
            new Dashboard(susername,sname);
        }
    }
public static void main(String[] args){
  new UpdateDetails("","");
}
}

