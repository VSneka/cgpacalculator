package backend;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GPA_CGPA_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> gradePointMap = createGradePointMap();
        System.out.print("Enter the number of semesters: ");
        int numberOfSemesters = scanner.nextInt();
        double totalCredits = 0;
        double totalGradePoints = 0;
        if(numberOfSemesters<=8) {
            for (int semester = 1; semester <= numberOfSemesters; semester++) {
                System.out.print("Enter the number of subjects for Semester " + semester + ": ");
                int numberOfSubjects = scanner.nextInt();

                double semesterCredits = 0;
                double semesterGradePoints = 0;

                for (int i = 1; i <= numberOfSubjects; i++) {
                    System.out.print("Enter the grade for Subject " + i + " in Semester " + semester + ": ");
                    String grade = scanner.next().toUpperCase();

                    double credit = 3.0;
                    double gradePoint = gradePointMap.getOrDefault(grade, 0.0);
                    semesterGradePoints += gradePoint * credit;
                    semesterCredits += credit;
                }

                double semesterGPA = semesterGradePoints / semesterCredits;
                System.out.println("GPA for Semester " + semester + ": " + semesterGPA);

                totalGradePoints += semesterGradePoints;
                totalCredits += semesterCredits;
            }
        }
        else{
            System.out.println("Invalid semesternumber");
        }
        double cgpa = totalGradePoints / totalCredits;
        System.out.println("CGPA: " + cgpa);
    }

    private static Map<String, Double> createGradePointMap() {
        Map<String, Double> gradePointMap = new HashMap<>();

        gradePointMap.put("O", 10.0);
        gradePointMap.put("A+",9.0);
        gradePointMap.put("A", 8.0);
        gradePointMap.put("B+",7.0);
        gradePointMap.put("B",6.0);
        gradePointMap.put("C",5.0);
        gradePointMap.put("U",0.0);
        return gradePointMap;
    }
}



