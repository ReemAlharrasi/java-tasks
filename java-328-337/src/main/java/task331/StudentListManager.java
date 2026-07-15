package task331;

import java.util.ArrayList;

public class StudentListManager {
    void main(){
        //create student list
        ArrayList<String> students = new ArrayList<String>();

        //add 10 names to student list
        students.add("Reem");
        students.add("Salwa");
        students.add("Salima");
        students.add("Jokha");
        students.add("Shadha");
        students.add("Intisar");
        students.add("Mayada");
        students.add("Taqwa");
        students.add("Ikhlas");
        students.add("Fatma");

        //loop to display all student names
        System.out.println("-----Student List-----");
        for (int i=0;i<students.size();i++){
            System.out.println((i+1)+" - "+students.get(i));
        }
        System.out.println("----------------------");

        //display list information
        System.out.println("Number of students: "+students.size());
        System.out.println("First student in the list: "+students.get(0));
        System.out.println("Last student in the list: "+students.get(students.size()-1));
        System.out.println("----------------------");

        //check if reem is on the last and display result
        String name= "Reem";
        System.out.print("Is Reem on the list: ");
        if (students.contains(name)) System.out.println("Yes");
        else System.out.println("No");

        //remove reem from the list
        students.remove("Reem");
        System.out.println("Reem has been removed from the list");

        //display updated list
        System.out.println("-----Updated Student List-----");
        for (int i=0;i<students.size();i++){
            System.out.println((i+1)+" - "+students.get(i)); //print student name with index
        }
    }
}
