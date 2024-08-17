package QuizApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class Progress extends JFrame implements ActionListener {

    private Map<String, Integer> scores;
    private String susername, sname;
    private JButton closeButton;

    public Progress(String susername, String sname) {
        this.susername = susername;
        this.sname = sname;
        this.scores = new HashMap<>();

        // Fetch scores from the database
        fetchScoresFromDatabase();

        setBounds(300, 50, 700, 700);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Set layout to null for absolute positioning

        // Header Label
        JLabel welcomeLabel = new JLabel("Progress for: " + susername);
        welcomeLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 35));
        welcomeLabel.setBounds(150, 20, 500, 35); // Set bounds (x, y, width, height)
        add(welcomeLabel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/progress.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(100, 400, 500, 200);
        add(image1); 

        // Progress Bars and Labels with setBounds
        int yOffset = 50;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            // Subject Label
            JLabel subjectLabel = new JLabel(entry.getKey() + " Progress:");
            subjectLabel.setBounds(50, yOffset, 250, 50); 
            subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Position the label
            add(subjectLabel);

            // Progress Bar
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setValue(entry.getValue()); // Multiply by 10 to scale to 0-100
            progressBar.setStringPainted(true);
            progressBar.setBounds(350, yOffset + 10, 250, 30); // Position the progress bar
            add(progressBar);

            yOffset += 70; // Move the yOffset down for the next row
        }

        // Close Button
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 600, 150, 40);
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.white);
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);
    }

    private void fetchScoresFromDatabase() {
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
              //  System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database.");
           // System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == closeButton) {
            setVisible(false);
            new Dashboard(susername, sname); // Go back to Dashboard
        }
    }

    public static void main(String[] args) {
        // Test with sample data (replace with actual username)
        new Progress("student123", "");
    }
}
