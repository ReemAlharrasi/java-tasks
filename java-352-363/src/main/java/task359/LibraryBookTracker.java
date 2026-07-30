package task359;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LibraryBookTracker {
    //declare variables
    HashSet<Integer> bookIDs = new HashSet<Integer>();
    HashMap<Integer, String> booksIdTitles = new HashMap<Integer, String>();
    Scanner in = new Scanner(System.in);
    int size, id;
    String title, classification;

    void main() {
        //Prompt the user to enter the number of books
        System.out.print("Enter the number of Books: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of Books.");
        } else {
            //if size is valid: prompt user to enter name and price
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print(i + " - enter Book id: ");
                id = in.nextInt();
                //add to set and ensure there is no duplicate
                if (bookIDs.contains(id)) {
                    System.out.println("Duplicate Book ID. Record not added..");
                } else {
                    System.out.print("    enter Book title: ");
                    title = in.next();
                }
                bookIDs.add(id);
                booksIdTitles.put(id, title);
            }

            //prompt the user to enter a book ID to search for
            System.out.print("\nSearch a book -----\nEnter Book id: ");
            id = in.nextInt();
            if (booksIdTitles.containsKey(id)) {
                System.out.println("Book id (" + id + ") found. Title: " + booksIdTitles.get(id));
            } else {
                System.out.println("Book not found");
            }

            //classify performance based on average grade
            if (bookIDs.size() < 5) classification = "Small Library";
            else if (bookIDs.size() <= 10) classification = "Medium Library";
            else classification = "Large Library";

            //display all results
            System.out.println("\nInformation -----\nTotal Book records entered: " + size);
            System.out.println("Total unique book records: " + bookIDs.size());
            System.out.println("All Books IDs: " + bookIDs);
            System.out.println("All Books  (ID=title): " + booksIdTitles);
            System.out.println("Library classification: " + classification);
        }

        //close scanner
        in.close();
    }
}
