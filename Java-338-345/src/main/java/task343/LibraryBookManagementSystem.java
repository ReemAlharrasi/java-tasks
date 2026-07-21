package task343;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManagementSystem {
    //initialize variables
    ArrayList<String> bookTitles = new ArrayList<String>();
    ArrayList<String> authors = new ArrayList<String>();
    ArrayList<String> availability = new ArrayList<String>();

    int index;
    String title;
    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 10 books to lists
        bookTitles.add("Matilda");authors.add("RoaldDahl");availability.add("Available");
        bookTitles.add("AtomicHabits");authors.add("JamesClear");availability.add("Unavailable");
        bookTitles.add("TheSilentPatient");authors.add("AlexMichaelides");availability.add("Available");
        bookTitles.add("Sapiens");authors.add("YuvalNoahHarari");availability.add("Unavailable");
        bookTitles.add("KlaraAndTheSun");authors.add("KazuoIshiguro");availability.add("Available");
        bookTitles.add("TheAlchemist");authors.add("PauloCoelho");availability.add("Available");
        bookTitles.add("Dune");authors.add("FrankHerbert");availability.add("Available");
        bookTitles.add("Yellowface");authors.add("R.F.Kuang");availability.add("Unavailable");
        bookTitles.add("ProjectHailMary");authors.add("AndyWeir");availability.add("Available");
        bookTitles.add("TheMidnightLibrary");authors.add("MattHaig");availability.add("Available");

        //call functions
        System.out.println("\n----- Display Book list -----");
        displayBooks();

        System.out.println("\n----- Add new Book -----");
        addNewBook();

        System.out.println("\n----- Update Book Information -----");
        updateBook();

        System.out.println("\n----- Search Book System -----");
        searchBook();

    }

    //display all books function
    public void displayBooks() {
        //formatted print so it looks like a table
        System.out.printf("%-4s %-20s %-20s %-20s\n", "No.", "book name", "Author", "Availabilty");
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.printf("%-4s %-20s %-20s %-20s\n", (i + 1), bookTitles.get(i), authors.get(i), availability.get(i));
        }
    }

    //add new book
    public void addNewBook(){
        System.out.print("Enter book name: ");
        bookTitles.add(in.next());
        System.out.print("Enter book author: ");
        authors.add(in.next());
        System.out.print("Enter book availability: ");
        availability.add(in.next());
        System.out.println("Book added successfully");
    }

    //update book
    public void updateBook(){
        //read index from user
        System.out.print("Enter book index: ");
        index=in.nextInt();

        //if index acceptable then update book
        if (index < bookTitles.size() && index >= 0){
            System.out.print("Enter new Title: ");
            bookTitles.add(in.next());
            System.out.print("Enter new author: ");
            authors.add(in.next());
            System.out.print("Enter new availability: ");
            availability.add(in.next());
            System.out.println("Book updated successfully");
        }else{
            System.out.println("Index out of range!");
        }

    }

    //function to search specific book
    public void searchBook() {
        System.out.print("Enter book name: ");
        title=in.next();
        System.out.print("In library? ");

        //get index of the book if it is in list
        int index = bookTitles.indexOf(title);
        if (index != -1) System.out.println("Yes");
        else System.out.println("Not Available in library");//print msg if not in library system
    }
}
