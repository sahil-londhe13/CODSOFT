import java.util.Scanner;

public class GradeEvaluator {

    // Method to decide grade based on average percentage
    private static String decideGrade(double avgScore) {
        if (avgScore >= 90) {
            return "O";
        } else if (avgScore >= 80) {
            return "A+";
        } else if (avgScore >= 70) {
            return "A";
        } else if (avgScore >= 60) {
            return "B+";
        }
        else if (avgScore >= 50) {
            return "B";
        } 
        else if (avgScore >= 40) {
            return "P";
        } 
         else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");

        System.out.print("Enter number of subjects: ");
        int subjectCount = inputReader.nextInt();

        if (subjectCount <= 0) {
            System.out.println("Invalid subject count. Program terminated.");
            return;
        }

        int accumulatedMarks = 0;

        for (int index = 1; index <= subjectCount; index++) {
            int markValue;

            while (true) {
                System.out.print("Enter marks for subject " + index + " (0 - 100): ");
                markValue = inputReader.nextInt();

                if (markValue >= 0 && markValue <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter value between 0 and 100.");
                }
            }

            accumulatedMarks += markValue;
        }

        double averagePercentage = (double) accumulatedMarks / subjectCount;
        String finalGrade = decideGrade(averagePercentage);

        System.out.println("\n----- Result Summary -----");
        System.out.println("Total Marks       : " + accumulatedMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade Achieved    : " + finalGrade);
        System.out.println("--------------------------");

        inputReader.close();
    }
}
