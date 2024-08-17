package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class Dashboard extends JFrame implements ActionListener {
    String susername, sname;
    Map<String, Integer> scores;
    JLabel heading, percentageLabel, rankLabel;

    Dashboard(String susername, String sname) {
        this.susername = susername;
        this.sname = sname;
        this.scores = new HashMap<>(); // Initialize the scores map

        setBounds(200, 50, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
          ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icon/back.png"));
        Image i12 = i11.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image5 = new JLabel(i13);
        image5.setBounds(0, 0, 1000, 600);
        image5.setLayout(null); // Setting layout to null so we can add components with custom positions
        add(image5);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/quiz2.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(400, 150, 500, 300);
        image5.add(image1); 
        
        heading = new JLabel("Welcome " + susername);
        heading.setBounds(250, 50, 500, 50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading.setForeground(Color.BLACK);
        image5.add(heading);
        
   
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icon/rank.png"));
        Image i6 = i5.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i7= new ImageIcon(i6);
        JLabel image2 = new JLabel(i7);
        image2.setBounds(100, 150, 200, 200);
        image5.add(image2);
        

        percentageLabel = new JLabel("Overall Percentage: ");
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        percentageLabel.setBounds(100, 370, 300, 30);
        image5.add(percentageLabel);

        rankLabel = new JLabel("Rank: ");
        rankLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rankLabel.setBounds(100, 400, 300, 30);
        image5.add(rankLabel);

        // Initialize the menu bar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu profile = new JMenu("Profile");
        profile.setForeground(Color.BLUE);

        JMenuItem details = new JMenuItem("Student Details");
        details.setFont(new Font("monospaced", Font.PLAIN, 12));
        details.setBackground(Color.white);
        details.setMnemonic('D');
        details.addActionListener(this);
        details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        profile.add(details);

        JMenuItem update = new JMenuItem("Update Details");
        update.setFont(new Font("monospaced", Font.PLAIN, 12));
        update.setBackground(Color.white);
        update.setMnemonic('U');
        update.addActionListener(this);
        update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        profile.add(update);

        JMenu quiz = new JMenu("Quiz");
        quiz.setForeground(Color.blue);

        JMenuItem notepad = new JMenuItem("List Of Quiz");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.white);
        notepad.setMnemonic('Q');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        quiz.add(notepad);

        JMenuItem score = new JMenuItem("Check Your Scores");
        score.setFont(new Font("monospaced", Font.PLAIN, 12));
        score.setBackground(Color.white);
        score.setMnemonic('L');
        score.addActionListener(this);
        score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        quiz.add(score);

        JMenuItem progress = new JMenuItem("Progress");
        progress.setFont(new Font("monospaced", Font.PLAIN, 12));
        progress.setBackground(Color.white);
        progress.setMnemonic('P');
        progress.addActionListener(this);
        progress.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        quiz.add(progress);

            JMenu board = new JMenu("LeaderBoard");
        board.setForeground(Color.BLUE);

        JMenuItem leaderboard = new JMenuItem("LeaderBoard");
        leaderboard.setFont(new Font("monospaced", Font.PLAIN, 12));
        leaderboard.setBackground(Color.white);
        leaderboard.setMnemonic('D');
        leaderboard.addActionListener(this);
        leaderboard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        board.add(leaderboard);
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);

        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced", Font.PLAIN, 12));
        eexit.setBackground(Color.white);
        eexit.setMnemonic('V');
        eexit.addActionListener(this);
        eexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        exit.add(eexit);
        
        

        mb.add(profile);
        mb.add(quiz);
        mb.add(board);
        mb.add(exit);

        // Fetch scores and calculate overall percentage and rank
        displayOverallPercentageAndRank();

        setVisible(true);
    }

    private void displayOverallPercentageAndRank() {
        // Fetch scores from the database and populate the scores map
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM score WHERE username ='" + susername + "'");
            if (rs.next()) {
                scores.put("Java", rs.getInt("java_score"));
                scores.put("Python", rs.getInt("python_score"));
                scores.put("C Programming", rs.getInt("C_Programming_score"));
                scores.put("C++", rs.getInt("Cpp_score"));
                scores.put("SQL", rs.getInt("SQL_score"));
            } else {
                JOptionPane.showMessageDialog(this, "No data found for the user.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database.");
            return;
        }

        // Calculate total percentage
        int totalScore = 0;
        int numSubjects = scores.size();

        for (int score : scores.values()) {
            totalScore += score;
        }

        double percentage = (double) totalScore / (numSubjects * 100) * 100;
        percentageLabel.setText("Overall Percentage: " + String.format("%.2f", percentage) + "%");

        // Determine and display rank
        String rank = determineRank(percentage);
        rankLabel.setText("Rank: " + rank);
    }

    // Method to determine the rank based on the percentage
    private String determineRank(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Student Details")) {
            setVisible(false);
            new StudentDetails(susername, sname);
        } else if (msg.equals("Update Details")) {
            setVisible(false);
            new UpdateDetails(susername, sname);
        } else if (msg.equals("List Of Quiz")) {
            setVisible(false);
            new ListOfQuiz(susername, sname);
        } else if (msg.equals("Check Your Scores")) {
            setVisible(false);
            new CheckScore(susername, sname);
        } else if (msg.equals("Progress")) {
            setVisible(false);
            new Progress(susername, sname);
        } 
        else if (msg.equals("LeaderBoard")) {
            setVisible(false);
            new LeaderBoard(susername, sname);
        }else if (msg.equals("Exit")) {
            setVisible(false);
            new Login(sname);
        }
    }

    public static void main(String[] args) {
        new Dashboard("student123", "John Doe");
    }
}

    
