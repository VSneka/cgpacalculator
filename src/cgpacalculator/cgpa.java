package cgpacalculator;

import java.util.Scanner;

public class cgpa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of semesters: ");
        int numSemesters = scanner.nextInt();

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 1; i <= numSemesters; i++) {
            System.out.println("\nSemester " + i + ":");
            System.out.print("Enter GPA for the semester: ");
            double semesterGPA = scanner.nextDouble();

            System.out.print("Enter total credits for the semester: ");
            int semesterCredits = scanner.nextInt();

            totalGradePoints += semesterGPA * semesterCredits;
            totalCredits += semesterCredits;
        }

        double cgpa = totalGradePoints / totalCredits;

        System.out.println("\nYour CGPA is: " + cgpa);

        scanner.close();
    }
}

