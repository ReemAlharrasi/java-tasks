package task370;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Queue<String> printJobs = new LinkedList<>();
    int size, choice;
    String name;

    //main function
    void main() {
        //Prompt the user to enter the number of print
        // jobs
        System.out.print("Enter the number of print jobs: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of print jobs.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- enter print job name: ");
                name = in.next();
                printJobs.offer(name); //add to queue
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Print Job");
                System.out.println("2. Process Next Print Job");
                System.out.println("3. View Next Print Job");
                System.out.println("4. Search Print Job");
                System.out.println("5. Remove Print Job");
                System.out.println("6. Display All Print Jobs");
                System.out.println("7. Display Queue Statistics");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        addprintJob();
                        break;
                    case 2:
                        processNextPrintJob();
                        break;
                    case 3:
                        viewNextPrintJob();
                        break;
                    case 4:
                        searchPrintJob();
                        break;
                    case 5:
                        removePrintJob();
                        break;
                    case 6:
                        displayAllPrintJobs();
                        break;
                    case 7:
                        displayQueueStatistics();
                        break;
                    //exit
                    case 8:
                        System.out.println("\nGoodBye~");
                        break;
                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 8);

        }
        //close scanner
        in.close();
    }

    //Add Print Job
    public void addprintJob() {
        System.out.println("\nAdd print job -----");
        System.out.print("Enter print job name: ");
        name = in.next(); //read from user
        printJobs.offer(name); //add to queue
        System.out.println("Print job added successfully.");
    }

    public void processNextPrintJob() {
        System.out.println("\nProcess Next Print Job -----");
        if (printJobs.isEmpty()) System.out.println("No print jobs in the queue.");//if queue is empty
        else {
            name = printJobs.poll(); //remove first item from queue
            System.out.println("processed print job: [" + name + "]");
        }
    }

    public void viewNextPrintJob() {
        System.out.println("\nView Print Job -----");
        if (printJobs.isEmpty()) System.out.println("No print jobs in the queue.");//if queue is empty
        else {
            System.out.println("Next print job: [" + printJobs.peek() + "]");
        }
    }

    public void searchPrintJob() {
        System.out.println("\nSearch Print Job -----");
        System.out.print("Enter Print Job name: ");
        name = in.next();//read from user

        if (printJobs.contains(name)) { //if found
            System.out.println("Print Job found");
        } else {
            System.out.println("Print Job not found.");
        }
    }

    public void removePrintJob() {
        System.out.println("\nRemove Print Job -----");
        System.out.print("Enter Print Job name: ");
        name = in.next();//read from user

        if (printJobs.contains(name)) { //if found
            printJobs.remove(name);
            System.out.println("Print Job Removed");
        } else {
            System.out.println("Print Job not found.");
        }
    }

    public void displayAllPrintJobs() {
        System.out.println("\nDisplay All print Jobs -----");
        if (printJobs.isEmpty()) System.out.println("No print jobs in the queue.");//if queue is empty
        else {
            int i = 1;
            for (String customer : printJobs) {
                System.out.println(i + "- " + customer);
                i++;
            }
        }
    }

    public void displayQueueStatistics() {
        System.out.println("\nDisplay Queue Statistics -----");
        System.out.println("Total number of print Jobs: " + printJobs.size());
        System.out.println("Next print job: " + printJobs.peek());
        System.out.println("queue is empty? " + printJobs.isEmpty());
    }
}
