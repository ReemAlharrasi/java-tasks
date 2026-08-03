package task373;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HospitalPatientManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Queue<String> waitingPatients = new LinkedList<>();
    Stack<String> treatedPatients = new Stack<>();
    int size, choice;
    String name;

    //main function
    void main() {
        //Prompt the user to enter the number of patients
        System.out.print("Enter the number of patients waiting for treatment: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of patients.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- Enter patient name: ");
                name = in.next();
                waitingPatients.offer(name); //add patient to queue
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Patient");
                System.out.println("2. Treat Patient");
                System.out.println("3. View Next Patient");
                System.out.println("4. Undo Last Treatment");
                System.out.println("5. Search Patient");
                System.out.println("6. Display Waiting Patients");
                System.out.println("7. Display Treated Patients");
                System.out.println("8. Display Hospital Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        treatPatient();
                        break;
                    case 3:
                        viewNextPatient();
                        break;
                    case 4:
                        undoLastTreatment();
                        break;
                    case 5:
                        searchPatient();
                        break;
                    case 6:
                        displayWaitingPatients();
                        break;
                    case 7:
                        displayTreatedPatients();
                        break;
                    case 8:
                        displayHospitalStatistics();
                        break;
                    case 9:
                        System.out.println("\nGoodBye~");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 9);
        }

        //close scanner
        in.close();
    }

    //Add Patient
    public void addPatient() {
        System.out.println("\nAdd Patient -----");
        System.out.print("Enter patient name: ");
        name = in.next();
        waitingPatients.offer(name); //add patient
        System.out.println("Patient added successfully.");
    }

    //Treat Patient
    public void treatPatient() {
        System.out.println("\nTreat Patient -----");

        if (waitingPatients.isEmpty()) {
            System.out.println("No patients waiting for treatment.");
        } else {
            name = waitingPatients.poll(); //remove first patient
            treatedPatients.push(name); //add to stack
            System.out.println("Patient treatment completed successfully.");
        }
    }

    //View Next Patient
    public void viewNextPatient() {
        System.out.println("\nView Next Patient -----");

        if (waitingPatients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("Next patient: [" + waitingPatients.peek() + "]");
        }
    }

    //Undo Last Treatment
    public void undoLastTreatment() {
        System.out.println("\nUndo Last Treatment -----");

        if (treatedPatients.isEmpty()) {
            System.out.println("No completed treatments available.");
        } else {
            name = treatedPatients.pop(); //remove last treated patient
            System.out.println("Treatment undone for patient: [" + name + "]");
        }
    }

    //Search Patient
    public void searchPatient() {
        System.out.println("\nSearch Patient -----");
        System.out.print("Enter patient name: ");
        name = in.next();

        if (waitingPatients.contains(name)) {
            System.out.println("Patient is waiting for treatment.");
        } else if (treatedPatients.search(name) != -1) {
            System.out.println("Patient treatment completed.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    //Display Waiting Patients
    public void displayWaitingPatients() {
        System.out.println("\nDisplay Waiting Patients -----");

        if (waitingPatients.isEmpty()) {
            System.out.println("No waiting patients.");
        } else {
            int i = 1;
            for (String patient : waitingPatients) {
                System.out.println(i + "- " + patient);
                i++;
            }
        }
    }

    //Display Treated Patients
    public void displayTreatedPatients() {
        System.out.println("\nDisplay Treated Patients -----");

        if (treatedPatients.isEmpty()) {
            System.out.println("No treated patients.");
        } else {
            int i = 1;
            for (String patient : treatedPatients) {
                System.out.println(i + "- " + patient);
                i++;
            }
        }
    }

    //Display Hospital Statistics
    public void displayHospitalStatistics() {
        System.out.println("\nDisplay Hospital Statistics -----");

        System.out.println("Total waiting patients: " + waitingPatients.size());
        System.out.println("Total treated patients: " + treatedPatients.size());

        if (waitingPatients.isEmpty()) {
            System.out.println("Next patient waiting: None");
        } else {
            System.out.println("Next patient waiting: " + waitingPatients.peek());
        }

        if (treatedPatients.isEmpty()) {
            System.out.println("Last treated patient: None");
        } else {
            System.out.println("Last treated patient: " + treatedPatients.peek());
        }

        System.out.println("Queue is empty? " + waitingPatients.isEmpty());
        System.out.println("Stack is empty? " + treatedPatients.isEmpty());
    }
}