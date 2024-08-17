package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class LeaderBoard extends JFrame implements ActionListener {

    JButton backButton;
    String susername,sname;
    public LeaderBoard(String susername,String sname) {
        this.susername=susername;
        this.sname=sname;
        
        setTitle("Leaderboard");
        setBounds(100, 50, 800, 400);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Setting layout to null to allow custom positioning of components

        // Display an image (e.g., a leaderboard banner or icon)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/star.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 800, 200); // Position at the top of the window
        add(image1);

        // Fetch data from the database
        ArrayList<UserScore> userScores = fetchUserScores();

        // Sort users by their overall score
        userScores.sort(Comparator.comparingDouble(UserScore::getOverallScore).reversed());

        // Create table data for leaderboard
        String[] columns = {"Rank", "Username", "Overall Percentage"};
        String[][] data = new String[userScores.size()][3];

        for (int i = 0; i < userScores.size(); i++) {
            UserScore userScore = userScores.get(i);
            data[i][0] = String.valueOf(i + 1);  // Rank
            data[i][1] = userScore.getUsername();  // Username
            data[i][2] = String.format("%.2f%%", userScore.getOverallScore());  // Overall Percentage
        }

        // Create JTable to display leaderboard data
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 700, 100); // Adjust position and size of the table
        add(scrollPane);

        // Create the "Back" button
        backButton = new JButton("Back");
        backButton.setBounds(350, 320, 100, 30); // Position the button below the leaderboard
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        add(backButton);

        setVisible(true);
    }

    // Method to fetch user scores from the database
    private ArrayList<UserScore> fetchUserScores() {
        ArrayList<UserScore> userScores = new ArrayList<>();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM score");

            while (rs.next()) {
                String username = rs.getString("username");
                int javaScore = rs.getInt("java_score");
                int pythonScore = rs.getInt("python_score");
                int cScore = rs.getInt("C_Programming_score");
                int cppScore = rs.getInt("Cpp_score");
                int sqlScore = rs.getInt("SQL_score");

                // Calculate overall score (percentage)
                int totalScore = javaScore + pythonScore + cScore + cppScore + sqlScore;
                double overallScore = (double) totalScore / 500 * 100;

                userScores.add(new UserScore(username, overallScore));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database.");
        }

        return userScores;
    }

    // Handle the "Back" button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            setVisible(false);
            new Dashboard(susername,sname);
        }
    }

    public static void main(String[] args) {
        new LeaderBoard("","");
    }
}

class UserScore {
    private String username;
    private double overallScore;

    public UserScore(String username, double overallScore) {
        this.username = username;
        this.overallScore = overallScore;
    }

    public String getUsername() {
        return username;
    }

    public double getOverallScore() {
        return overallScore;
    }
}

