package task369;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerQueueManager {
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
                System.out.print((i + 1) + "- enter customer name: ");
                name = in.next();
                customerNames.offer(name); //add to queue
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

                    //add Customer
                    case 1:
                        addCustomer();
                        break;

                    //serve Customer
                    case 2:
                        serveCustomer();
                        break;

                    //View Next Customer
                    case 3:
                        viewNextCustomer();
                        break;

                    //search Customer
                    case 4:
                        searchCustomer();
                        break;

                    //display all Customer
                    case 5:
                        displayAllCustomers();
                        break;

                    //display statistics
                    case 6:
                        displayQueueStatistics();
                        break;

                    //exit
                    case 7:
                        System.out.println("\nGoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 7);

        }
        //close scanner
        in.close();
    }

    public void addCustomer() {
        System.out.println("\nAdd Customer -----");
        System.out.print("Enter Customer name: ");
        name = in.next(); //read from user
        customerNames.offer(name); //add to queue
        System.out.println("Customer added successfully.");
    }

    public void serveCustomer() {
        System.out.println("\nServe Customer -----");
        if (customerNames.isEmpty()) System.out.println("No customers in the queue.");//if queue is empty
        else {
            name = customerNames.poll(); //remove first item from queue
            System.out.println("Customer Served successfully: [" + name + "]");
        }
    }

    public void viewNextCustomer() {
        System.out.println("\nView  Next Customer -----");
        if (customerNames.isEmpty()) System.out.println("No customers in the queue.");//if queue is empty
        else {
            System.out.println("Next Customer: [" + customerNames.peek() + "]");
        }
    }

    public void searchCustomer() {
        System.out.println("\nSearch Customer -----");
        System.out.print("Enter Customer name: ");
        name = in.next();//read from user

        if (customerNames.contains(name)) { //if found
            System.out.println("Customer found");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void displayAllCustomers() {
        System.out.println("\nDisplay All Books -----");
        if (customerNames.isEmpty()) System.out.println("No customers in the queue.");//if queue is empty
        else {
            int i = 1;
            for (String customer : customerNames) {
                System.out.println(i + "- " + customer);
                i++;
            }
        }
    }

    public void displayQueueStatistics() {
        System.out.println("\nDisplay Queue Statistics -----");
        System.out.println("Total number of customers: "+customerNames.size());
        if (!customerNames.isEmpty()){
            System.out.println("First customer in the queue: "+customerNames.peek());
            System.out.println("Last customer in the queue: "+((LinkedList<String>) customerNames).getLast()); //convert queue to linkedlist to use getLast()
        }
        System.out.println("queue is empty? "+customerNames.isEmpty());
    }

}
