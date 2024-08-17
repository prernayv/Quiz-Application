package QuizApplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ListOfQuiz extends JFrame implements ActionListener  {
    JButton submit,rules;
    JRadioButton java, python, C, c2, sql;
    
    String susername,sname;
    
    public ListOfQuiz(String susername,String sname) {
         this.sname=sname;
         this.susername=susername;
        // Set frame properties
        setBounds(450,150,700,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel panel =new JPanel();
        panel.setBounds(30, 70, 630, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(249,194,56),2),"List Of Quizzes",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(249,194,56)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        JLabel heading = new JLabel("Choose a Quiz");
        heading.setBounds(150, 30, 400, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        java = new JRadioButton("JAVA");
        java.setBounds(100,50 ,120 ,30);
        java.setFont(new Font("Tahoma", Font.BOLD, 14));
        java.setBackground(Color.WHITE);
        panel.add(java);
        
        python = new JRadioButton("PYTHON");
        python .setBounds(100,100 ,120 ,30);
        python.setFont(new Font("Tahoma", Font.BOLD, 14));
        python .setBackground(Color.WHITE);
        panel.add(python );
        
        C = new JRadioButton("C Programming");
        C.setBounds(100,150 ,150 ,30);
        C.setFont(new Font("Tahoma", Font.BOLD, 14));
        C.setBackground(Color.WHITE);
        panel.add(C);
        
        c2 = new JRadioButton("C++");
        c2 .setBounds(100,200 ,120 ,30);
        c2.setFont(new Font("Tahoma", Font.BOLD, 14));
        c2 .setBackground(Color.WHITE);
        panel.add(c2 );
        
         sql = new JRadioButton("SQL");
        sql .setBounds(100,250 ,120 ,30);
        sql.setFont(new Font("Tahoma", Font.BOLD, 14));
        sql .setBackground(Color.WHITE);
        panel.add(sql );
        
        
        
        
        ButtonGroup selectButton = new ButtonGroup();
        selectButton.add(java);
        selectButton.add(python);
        selectButton.add(C);
        selectButton.add(c2);
        selectButton.add(sql);
        
        submit = new JButton("Start");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(500, 400, 100, 30);
        submit.addActionListener(this);
        add(submit);
      
        rules = new JButton("Check the Rules");
        rules.setBackground(Color.BLACK);
        rules.setForeground(Color.white);
        rules.setFont(new Font("Raleway",Font.BOLD,14));
        rules.setBounds(250, 400, 200, 30);
        rules.addActionListener(this);
        add(rules);
        
     
        setSize(700, 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
                // Check which radio button is selected
                if (java.isSelected()) {
                    JOptionPane.showMessageDialog(null, "JAVA Selected");
                    setVisible(false);
                    new JavaQue(sname,susername);
                } else if (python.isSelected()) {
                    JOptionPane.showMessageDialog(null, "PYTHON Selected");
                    setVisible(false);
                    new PythonQue(sname,susername);
                } else if (C.isSelected()) {
                    JOptionPane.showMessageDialog(null, "C Programming Selected");
                    setVisible(false);
                    new CProgrammingQue(sname,susername);
                } else if (c2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "C++ Selected");
                    setVisible(false);
                    new CPlusProgramming(sname,susername);
                } else if (sql.isSelected()) {
                    JOptionPane.showMessageDialog(null, "SQL Selected");
                    setVisible(false);
                    new SqlQue(sname,susername);
                } 
                else if (e.getSource() == rules) {
                   setVisible(false);
                   new Rules(sname,susername);}
                else {
                    JOptionPane.showMessageDialog(null, "No Option Selected");
                    setVisible(false);
                }
            }

    public static void main(String[] args) {
        new ListOfQuiz("","");
    }
}

    

