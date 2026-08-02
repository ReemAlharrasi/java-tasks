package task366;

import java.util.Scanner;
import java.util.Stack;

public class BookStackManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare variables
    Stack<String> bookTitles = new Stack<>();
    int size, choice;
    String title;

    void main() {
        //Prompt the user to enter the number of books
        System.out.print("Enter the number of Books: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of Books.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- enter Book title: ");
                title = in.next();
                bookTitles.push(title);
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Top Book");
                System.out.println("3. View Top Book");
                System.out.println("4. Search Book");
                System.out.println("5. Display All Books");
                System.out.println("6. Display Stack Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {

                    //add student
                    case 1:
                        addBook();
                        break;

                    //search student
                    case 2:
                        removeTopBook();
                        break;

                    //update attendance
                    case 3:
                        viewTopBook();
                        break;

                    //remove student
                    case 4:
                        searchBook();
                        break;

                    //display all records
                    case 5:
                        displayAllBooks();
                        break;

                    //display statistics
                    case 6:
                        displayStackStatistics();
                        break;

                    //exit
                    case 7:
                        System.out.println("GoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 7);

            //close scanner
            in.close();
        }
    }

    public void addBook(){
        System.out.println("\nAdd Book -----");
        System.out.print("Enter Book title: ");
        title = in.next();
        bookTitles.push(title);
        System.out.println("Book added successfully.");
    }

    public void removeTopBook(){
        System.out.println("\nRemove Top Book -----");
        if (bookTitles.empty()) System.out.println("No books available.");
        else {
            title=bookTitles.pop();
            System.out.println("Book removed successfully: ["+title+"]");
        }
    }
    public void viewTopBook(){
        System.out.println("\nView Top Book -----");
        if (bookTitles.empty()) System.out.println("No books available.");
        else {
            System.out.println("Top Book: ["+bookTitles.peek()+"]");
        }
    }
    public void searchBook(){

    }
    public void displayAllBooks(){}
    public void displayStackStatistics(){}

}