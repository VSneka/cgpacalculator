package cgpa;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GPA_CGPA_Calculator_GUI {

    private static JFrame frame;
    private static JPanel panel;
    private static JTextField semestersTextField;
    private static Map<String, Double> creditPointsMap;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        frame = new JFrame("GPA and CGPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel semestersLabel = new JLabel("Enter the number of semesters:");
        semestersLabel.setBounds(10, 20, 200, 25);
        panel.add(semestersLabel);

        semestersTextField = new JTextField(10);
        semestersTextField.setBounds(220, 20, 50, 25);
        panel.add(semestersTextField);

        JButton calculateButton = new JButton("Calculate GPA and CGPA");
        calculateButton.setBounds(10, 50, 200, 25);
        panel.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGPAAndCGPA();
            }
        });
    }

    private static void calculateGPAAndCGPA() {
        int numberOfSemesters = Integer.parseInt(semestersTextField.getText());

        initializeCreditPointsMap();

        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int semester = 1; semester <= numberOfSemesters; semester++) {
            int numberOfSubjects = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of subjects for Semester " + semester));

            double semesterCredits = 0;
            double semesterGradePoints = 0;

            for (int i = 1; i <= numberOfSubjects; i++) {
                String subjectName = JOptionPane.showInputDialog("Enter the subject name for Subject " + i + " in Semester " + semester);
                double credit = creditPointsMap.getOrDefault(subjectName, 3.0);

                String grade = JOptionPane.showInputDialog("Enter the grade for " + subjectName + " in Semester " + semester);
                double gradePoint = getGradePoint(grade);

                semesterGradePoints += gradePoint * credit;
                semesterCredits += credit;
            }

            double semesterGPA = semesterGradePoints / semesterCredits;
            JOptionPane.showMessageDialog(null, "GPA for Semester " + semester + ": " + semesterGPA);

            totalGradePoints += semesterGradePoints;
            totalCredits += semesterCredits;
        }

        double cgpa = totalGradePoints / totalCredits;
        JOptionPane.showMessageDialog(null, "CGPA: " + cgpa);
    }

    private static void initializeCreditPointsMap() {
        creditPointsMap = new HashMap<>();
        creditPointsMap.put("Maths", 4.0);
        creditPointsMap.put("Physics", 3.0);
        creditPointsMap.put("Chemistry", 3.0);
        creditPointsMap.put("Artificial intelligence", 3.0);
        creditPointsMap.put("OOPS", 3.0);
        creditPointsMap.put("Data Science", 3.0);
        creditPointsMap.put("TOC", 3.0);
        creditPointsMap.put("Computer Science", 3.0);
        creditPointsMap.put("Data Structure", 4.0);
        creditPointsMap.put("Python", 4.0);
        creditPointsMap.put("CCS", 4.0);
        creditPointsMap.put("PPL", 3.0);
        creditPointsMap.put("Algorithm", 4.0);
        creditPointsMap.put("Computer networks", 3.0);
        creditPointsMap.put("Compiler design", 3.0);

    }

    private static double getGradePoint(String grade) {

        switch (grade.toUpperCase()) {
            case "O":
                return 10.0;
            case "A+":
                return 9.0;
            case "A":
                return 8.0;
            case "B+":
                return 7.0;
            case "B":
                return 6.0;
            case "C":
                return 5.0;
            default:
                return 0.0;
        }
    }
}

