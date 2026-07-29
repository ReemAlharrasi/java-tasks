package task355;

import java.util.Scanner;
import java.util.TreeSet;

public class CityDirectorySet {
    //declare variables
    TreeSet<String> cityNames= new TreeSet<>();
    Scanner in = new Scanner(System.in);
    int size;
    String city,searchResult,classification;

    //main function
    void main(){
        //Prompt the user to enter the number of cities
        System.out.print("enter the number of cities: ");
        size = in.nextInt();

        //validate input
        if (size <= 0){
            System.out.println("Invalid number of cities.");
        }
        else{
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print("enter course ("+i+"): ");
                city = in.next();
                //add to set and ensure there is no duplicate
                if (cityNames.contains(city)){
                    System.out.println("City already exists. Duplicate entries are not allowed.");
                }else{
                    cityNames.add(city);
                }
            }

            //prompt the user to enter a city name to search for
            System.out.print("\nSearch -----\nenter city name: ");
            city = in.next();
            if (cityNames.contains(city)){
                searchResult="City found in Directory.";
            }else{
                searchResult="City not found in Directory.";
            }

            //classify size of course catalog
            if (cityNames.size()<5)classification="Small Directory";
            else if (cityNames.size()<=10)classification="Medium Directory";
            else classification="Large Directory";

            //display results
            System.out.println("\nInformation -----\nTotal cities entered: "+size);
            System.out.println("Total unique cities: "+cityNames.size());
            System.out.println("All remaining course names: "+cityNames);
            System.out.println("Search result for ("+city+"): "+searchResult);
            System.out.println("Course catalog classification: "+classification);

        }
        //close scanner
        in.close();
    }
}
