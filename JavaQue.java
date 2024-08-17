package QuizApplication;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class JavaQue extends JFrame implements ActionListener{
    String questions[][] = new String [10][5];
    String answers[][]=new String [10][2];
    String userans[][]=new String[10][1];
    JLabel qno,que;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup groupOptions;
    JButton next,lifeline,clear,submit;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count=0;
    public static int score=0;
    
    String sname,susername;
    JavaQue(String sname,String susername){
        this.sname=sname;
        this.susername=susername;
        setBounds(300,50,900,750);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(50, 10, 800, 200);
        image1.setLayout(null); // Setting layout to null so we can add components with custom positions
        add(image1); 
        
         qno = new JLabel();
        qno.setBounds(50,250,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qno);
        
         que = new JLabel();
        que.setBounds(100,250,800,30);
        que.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(que);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
	
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        opt1 = new JRadioButton ();
        opt1.setBounds(100,340,450,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2 = new JRadioButton ();
        opt2.setBounds(100,380,450,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3 = new JRadioButton ();
        opt3.setBounds(100,420,450,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4 = new JRadioButton ();
        opt4.setBounds(100,460,450,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        
         groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);
        
         next =new JButton("Next");
        next.setBounds(600,340,150,40);
        next.setBackground(Color.black);
        next.setFont(new Font ("Tahoma",Font.PLAIN,22));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
         lifeline =new JButton("Lifeline");
        lifeline.setBounds(600,400,150,40);
        lifeline.setBackground(Color.black);
        lifeline.setFont(new Font ("Tahoma",Font.PLAIN,22));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);
        
        clear =new JButton("Clear");
        clear.setBounds(600,460,150,40);
        clear.setBackground(Color.black);
        clear.setFont(new Font ("Tahoma",Font.PLAIN,22));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
         submit =new JButton("Submit");
        submit.setBounds(600,540,200,40);
        submit.setBackground(Color.black);
        submit.setFont(new Font ("Tahoma",Font.PLAIN,22));
        submit.setForeground(Color.white);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);
        
        
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Time Left: " + timer + " seconds";//its a graphics
        g.setColor(Color.red);
        g.setFont(new Font ("Tahoma", Font.BOLD,16));
        
        
        if(timer>0){
            g.drawString(time, 600, 340);
        }
        else{
            g.drawString("Times Up!!", 600, 340);
        }
        timer--;
        
        try{                          // to decrease the time it wait only for 1sec            
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){           //ans is given or not
            ans_given=0;
            timer=15;
        }else if(timer<0){
            timer = 15;
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count==8){
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        if(count==9){
                 if(groupOptions.getSelection()==null){  //check ans selected or not
                userans[count][0]="";
                }else{ 
                userans[count][0]=groupOptions.getSelection().getActionCommand();  //ams selected stored
                }
                for(int i=0;i<userans.length;i++){
                    if(userans[i][0].equals(answers[i][1])){
                        score+=1;
                     }else{
                         score+=0;
                     }
                }
                setVisible(false);
                new Score(sname,susername,score);
                //Score frame
        }else{
            if(groupOptions.getSelection()==null){
                userans[count][0]="";
            }else{
                userans[count][0]=groupOptions.getSelection().getActionCommand();
            }
            count++;
            start(count);     }  
        }
    }
    
    public void start(int count){
        qno.setText("" + (count + 1) + ". ");
        que.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupOptions.clearSelection();
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==next){
        repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
        
        ans_given=1;
        if(groupOptions.getSelection()==null){
                userans[count][0]="";
        }else{
                userans[count][0]=groupOptions.getSelection().getActionCommand();
            }
      if(count==8){
         next.setEnabled(false);
         submit.setEnabled(true);
        }
        
        count++;
        start(count);
    }
     else if(e.getSource()==lifeline){
            if(count==2|| count==4||count==6||count==8||count==9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else
            {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
    else if(e.getSource()==submit){
         ans_given = 1;
         if(groupOptions.getSelection()==null){
            userans[count][0]="";
            }else{
                userans[count][0]=groupOptions.getSelection().getActionCommand();
            }
                 for(int i=0;i<userans.length;i++){
                     if(userans[i][0].equals(answers[i][1])){
                         score+=10;
                     }else{
                         score+=0;
                     }
                 }
                
                try {
                Conn c = new Conn(); // connection established

                 String checkQuery = "SELECT COUNT(*) FROM score WHERE username = '" +susername+ "'";
                 ResultSet rs = c.s.executeQuery(checkQuery);

                if (rs.next() && rs.getInt(1) > 0) {
        // If the record exists, update it
                String updateQuery = "UPDATE score SET java_score = '" +score+ "' WHERE username = '" +susername+ "'";
                c.s.executeUpdate(updateQuery);
                } else {
        // If the record does not exist, insert a new one
                String insertQuery = "INSERT INTO score VALUES ('" +susername+ "','" +sname+ "', '" +score+ "',null,null, null,null)";
               c.s.executeUpdate(insertQuery);
    } // execute

                setVisible(false);
                new Score(sname,susername, score);
                // Pass the name JTextField reference
               } catch (Exception ae) {
                ae.printStackTrace(); // Print the exception stack trace for debugging
                  
}
     }else{
        groupOptions.clearSelection();
    }
    }

public static void main (String [] args){
    new JavaQue("","");
}


}
