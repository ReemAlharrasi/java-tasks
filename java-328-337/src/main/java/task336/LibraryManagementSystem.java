package task336;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    //create required lists
    ArrayList<String> bookNames = new ArrayList<String>();
    ArrayList<String> authorNames = new ArrayList<String>();
    ArrayList<String> availability = new ArrayList<String>();
    int countAvailable = 0;
    int countUnavailable = 0;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 10 books to lists
        bookNames.add("Matilda");
        authorNames.add("RoaldDahl");
        availability.add("Available");

        bookNames.add("AtomicHabits");
        authorNames.add("JamesClear");
        availability.add("Unavailable");

        bookNames.add("TheSilentPatient");
        authorNames.add("AlexMichaelides");
        availability.add("Available");

        bookNames.add("Sapiens");
        authorNames.add("YuvalNoahHarari");
        availability.add("Unavailable");

        bookNames.add("KlaraAndTheSun");
        authorNames.add("KazuoIshiguro");
        availability.add("Available");

        bookNames.add("TheAlchemist");
        authorNames.add("PauloCoelho");
        availability.add("Available");

        bookNames.add("Dune");
        authorNames.add("FrankHerbert");
        availability.add("Available");

        bookNames.add("Yellowface");
        authorNames.add("R.F.Kuang");
        availability.add("Unavailable");

        bookNames.add("ProjectHailMary");
        authorNames.add("AndyWeir");
        availability.add("Available");

        bookNames.add("TheMidnightLibrary");
        authorNames.add("MattHaig");
        availability.add("Available");

        //menu
        String name;
        int choice = 0;
        while (choice != 6) {
            //print menu
            System.out.println("-----Library Management System-----");
            System.out.print("""
                    Services:
                    1: Display all books
                    2: Search for a book
                    3: Borrow a book
                    4: Return a book
                    5: Display library report
                    6: Exit the program
                    Choose a number: """);

            //let user choose from the menu
            choice = in.nextInt();

            //switch for the input
            switch (choice) {
                case 1: //display all books
                    displayBooks();
                    break;
                case 2:
                    System.out.print("ُEnter name: ");
                    name=in.next();
                    searchBook(name);
                    break;
                case 3:
                    System.out.print("ُEnter name: ");
                    name=in.next();
                    borrowBook(name);
                    break;
                case 4:
                    System.out.print("ُEnter name: ");
                    name=in.next();
                    returnBook(name);
                    break;
                case 5:
                    displayReport();
                    break;
                case 6:
                    System.out.println("GoodBye!~");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    //display all books function
    public void displayBooks() {
        System.out.println("Book list -----------");
        //formatted print so it looks like a table
        System.out.printf("%-4s %-20s %-20s %-20s\n", "No.", "book name", "Author", "Availabilty");
        for (int i = 0; i < bookNames.size(); i++) {
            System.out.printf("%-4s %-20s %-20s %-20s\n", (i + 1), bookNames.get(i), authorNames.get(i), availability.get(i));
        }
    }

    //function to search specific book
    public void searchBook(String name) {
        System.out.println("Find book -----------");
        System.out.println("Book name: " + name);
        System.out.print("In library? ");
        //get index of the book if it is in list
        int index = bookNames.indexOf(name);
        if (index != -1) System.out.println("Yes");
        else System.out.println("Not Available in library");//print msg if not in library system
    }

    //function to borrow book
    public void borrowBook(String name) {
        System.out.println("Borrow book -----------");
        System.out.println("Book name: " + name);
        //get index of the book if it is in list
        int index = bookNames.indexOf(name);
        if (index != -1) {
            if (availability.get(index).equals("Available")) {
                System.out.println("Borrow request approved");
                availability.set(index, "Unavailable");
            } else System.out.println("Borrow request declined: book is borrow by another person");
        } else System.out.println("Not Available in library");//print msg if not in library system
    }

    //function to return a book
    public void returnBook(String name) {
        System.out.println("Return book -----------");
        System.out.println("Book name: " + name);
        //get index of the book if it is in list
        int index = bookNames.indexOf(name);
        if (index != -1) {
            if (availability.get(index).equals("Available")) {
                System.out.println("Return request failed: book is already in library");
            } else {
                System.out.println("Return request Successful");
                availability.set(index, "Available");
            }
        } else System.out.println("This book does not belong to this library");//print msg if not in library system
    }

    //function to count available books and borrowed books
    public int[] countBooks() {
        int available = 0;
        int unavailable = 0;
        for (int i = 0; i < bookNames.size(); i++) {
            if (availability.get(i).equals("Available")) available++;
            else unavailable++;
        }
        return new int[]{available, unavailable};
    }

    public void displayReport() {
        System.out.println("------- Book Library report -------");
        System.out.println("Books -----------");
        System.out.printf("%-4s %-20s %-20s %-20s\n", "No.", "Book", "Author", "Status");
        for (int i = 0; i < bookNames.size(); i++) {
            System.out.printf("%-4s %-20s %-20s %-20s\n", (i + 1), bookNames.get(i), authorNames.get(i), availability.get(i));
        }

        //get count
        int[] result = countBooks();
        countAvailable = result[0];
        countUnavailable = result[1];
        System.out.println("information -----------");
        System.out.println("Total inventory value: " + bookNames.size());
        System.out.println("Number of available books: " + countAvailable);
        System.out.println("Number of unavailable books: " + countUnavailable);
    }
}
