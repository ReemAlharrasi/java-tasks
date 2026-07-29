package task354;

import java.util.HashSet;
import java.util.Scanner;

public class CourseEnrollmentSet {
    //declare variables
    HashSet<String> courseNames=new HashSet<>();
    Scanner in = new Scanner(System.in);
    int size;
    String course,removalResult,classification;

    //main function
    void main(){
        //Prompt the user to enter the number of products
        System.out.print("enter the number of courses: ");
        size = in.nextInt();

        //validate input
        if (size <= 0){
            System.out.println("Invalid number of courses.");
        }
        else{
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print("enter course ("+i+"): ");
                course = in.next();
                //add to set and ensure there is no duplicate
                if (courseNames.contains(course)){
                    System.out.println("Course already exists. Duplicate entries are not allowed.");
                }else{
                    courseNames.add(course);
                }
            }

            //prompt the user to enter a course name to remove
            System.out.println("Remove course -----\nenter Course name: ");
            course = in.next();
            if (courseNames.contains(course)){
                courseNames.remove(course);
                removalResult="Course removed successfully.";
            }else{
                removalResult="Course not found.";
            }

            //classify size of course catalog
            if (courseNames.size()<4)classification="Small Course Catalog";
            else if (courseNames.size()<=8)classification="Medium Course Catalog";
            else classification="Large Course Catalog";

            //display results
            System.out.println("\nInformation -----\nTotal courses entered: "+size);
            System.out.println("Total unique courses remaining: "+courseNames.size());
            System.out.println("All remaining course names: "+courseNames);
            System.out.println("Removal result for ("+course+"): "+removalResult);
            System.out.println("Course catalog classification: "+classification);
        }

        //close scanner
        in.close();
    }
}
