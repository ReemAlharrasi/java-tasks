package task371;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketQueueManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Queue<String> customerNames = new LinkedList<>();
    int size, choice;
    String name;

    //main function
    void main() {
        //Prompt the user to enter the number of customers
        System.out.print("Enter the number of customers: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of customers.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- Enter customer name: ");
                name = in.next();
                customerNames.add(name); //add customer
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Serve Customer");
                System.out.println("3. View Next Customer");
                System.out.println("4. Search Customer");
                System.out.println("5. Display All Customers");
                System.out.println("6. Display Queue Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        serveCustomer();
                        break;
                    case 3:
                        viewNextCustomer();
                        break;
                    case 4:
                        searchCustomer();
                        break;
                    case 5:
                        displayAllCustomers();
                        break;
                    case 6:
                        displayQueueStatistics();
                        break;
                    case 7:
                        System.out.println("\nGoodBye~");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 7);
        }

        //close scanner
        in.close();
    }

    //Add Customer
    public void addCustomer() {
        System.out.println("\nAdd Customer -----");
        System.out.print("Enter customer name: ");
        name = in.next();
        customerNames.add(name); //add customer
        System.out.println("Customer added successfully.");
    }

    //Serve Customer
    public void serveCustomer() {
        System.out.println("\nServe Customer -----");

        if (customerNames.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            name = customerNames.remove(); //remove first customer
            System.out.println("Served customer: [" + name + "]");
        }
    }

    //View Next Customer
    public void viewNextCustomer() {
        System.out.println("\nView Next Customer -----");

        if (customerNames.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Next customer: [" + customerNames.element() + "]");
        }
    }

    //Search Customer
    public void searchCustomer() {
        System.out.println("\nSearch Customer -----");
        System.out.print("Enter customer name: ");
        name = in.next();

        if (customerNames.contains(name)) {
            System.out.println("Customer found in queue.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    //Display All Customers
    public void displayAllCustomers() {
        System.out.println("\nDisplay All Customers -----");

        if (customerNames.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            int i = 1;
            for (String customer : customerNames) {
                System.out.println(i + "- " + customer);
                i++;
            }
        }
    }

    //Display Queue Statistics
    public void displayQueueStatistics() {
        System.out.println("\nDisplay Queue Statistics -----");
        System.out.println("Total number of customers: " + customerNames.size());
        if (customerNames.isEmpty()) {
            System.out.println("First customer: None");
            System.out.println("Last customer: None");
        } else {
            System.out.println("First customer: " + customerNames.peek());
            System.out.println("Last customer: " + ((LinkedList<String>) customerNames).getLast()); //convert queue to linkedlist to use getLast());
        }
        System.out.println("Queue is empty? " + customerNames.isEmpty());
    }
}