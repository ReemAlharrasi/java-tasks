package task320;

public class StudentGradeCalculator {
    public void main() {
        //Initialize variables
        double grade1 = 85;
        double grade2 = 90;
        double grade3 = 80;

        //display grades
        System.out.println("Grade 1: " + grade1);
        System.out.println("Grade 2: " + grade2);
        System.out.println("Grade 3: " + grade3);

        //calculate average and display it
        double average = (grade1 + grade2 + grade3) / 3;
        System.out.println("average: " + average);

        //determine status and display it
        String status = "";
        if (average >= 90) {
            status = "Excellent";
        } else if (average >= 75) {
            status = "Good";
        } else if (average >= 60) {
            status = "Pass";
        } else {
            status = "Fail";
        }
        System.out.println("Status: " + status);
    }
}
