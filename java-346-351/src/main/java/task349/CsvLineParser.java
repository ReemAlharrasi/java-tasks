package task349;

import java.util.Scanner;

public class CsvLineParser {

    //initialize scanner
    Scanner in = new Scanner(System.in);

    //initialize variables
    String[] input;
    String name,city,ageClass;
    int age;

    void main() {
        //read record from user
        System.out.print("Enter record (name, age, city): ");
        input =in.nextLine().strip().split(",");

        //validate input
        if (input.length>3){
            System.out.println("Invalid record." );
        } else{
            name=input[0].trim();
            age=Integer.parseInt(input[1].trim());
            city=input[2].trim();

            //classify age
            if (age<18) ageClass="Minor";
            else if (age<=64) ageClass="Adult";
            else ageClass="Senior";

            //print results
            System.out.println("Name: "+name);
            System.out.println("age: "+age);
            System.out.println("City: "+city);
            System.out.println("Age group: "+ageClass);

            //close scanner
            in.close();
        }
    }
}
