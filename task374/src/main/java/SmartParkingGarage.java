import java.util.*;

public class SmartParkingGarage {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Queue<String> waitingVehicles = new LinkedList<>();
    Stack<String> parkedVehicles = new Stack<>();
    int choice,parkingCounter, departedCounter;
    int parkLimit=10;

    String vehicle;

    //declare required variables
    void main() {
        //set starting values
        parkingCounter = 0;
        departedCounter = 0;
        choice = 0;

        //menu
        while (choice != 13) {
            //print menu
            System.out.println("\n========= Smart Parking Garage =========");
            System.out.println("1. Add Vehicle to Waiting Queue");
            System.out.println("2. Park Next Vehicle");
            System.out.println("3. Remove Parked Vehicle");
            System.out.println("4. View Next Waiting Vehicle");
            System.out.println("5. View Last Parked Vehicle");
            System.out.println("6. Display Waiting Queue");
            System.out.println("7. Display Parked Vehicles");
            System.out.println("8. Search Vehicle");
            System.out.println("9. Display Garage Statistics");
            System.out.println("10. Clear Waiting Queue");
            System.out.println("11. Clear Parking Garage");
            System.out.println("12. Reset Entire System");
            System.out.println("13. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    parkNextVehicle();
                    break;
                case 3:
                    removeParkedVehicle();
                    break;
                case 4:
                    viewNextWaitingVehicle();
                    break;
                case 5:
                    viewLastParkedVehicle();
                    break;
                case 6:
                    displayWaitingQueue();
                    break;
                case 7:
                    displayParkedVehicles();
                    break;
                case 8:
                    searchVehicle();
                    break;
                case 9:
                    displayGarageStatistics();
                    break;
                case 10:
                    clearWaitingQueue();
                    break;
                case 11:
                    clearParkingGarage();
                    break;
                case 12:
                    resetEntireSystem();
                    break;
                case 13:
                    System.out.println("\nThank you for using Smart Parking Garage");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }
        //close scanner
        in.close();
    }

    public void addVehicle() {
        System.out.println("\nAdd Vehicle -----");
        //prompt user to enter vehicle plate number
        System.out.print("Enter vehicle number: ");
        vehicle = in.next().strip().toLowerCase();
        //validate input
        if (vehicle.isEmpty()) {
            System.out.println("vehicle number cannot be empty.");
        } else if (waitingVehicles.contains(vehicle) || parkedVehicles.search(vehicle) != -1) {
            System.out.println("vehicle number already exists.");
        } else {
            waitingVehicles.add(vehicle); //add student to queue
            System.out.println("Vehicle added to waiting queue.");
        }
    }

    public void parkNextVehicle() {
        System.out.println("\nPark Next Vehicle -----");
        //check if waiting queue is empty
        if (waitingVehicles.isEmpty()) System.out.println("Waiting queue is empty.");
        else if (parkedVehicles.size() >= parkLimit) System.out.println("Parking garage is Full.");
        else {
            vehicle = waitingVehicles.poll();
            parkedVehicles.push(vehicle);
            parkingCounter++; //increase parked counter
            System.out.println("Vehicle [" + vehicle + "] is Parked.");
        }
    }

    public void removeParkedVehicle() {
        System.out.println("\nRemove Parked Vehicle -----");
        if (parkedVehicles.isEmpty()) System.out.println("Parking garage is Empty.");
        else {
            vehicle = parkedVehicles.pop();//remove car from parking garage
            System.out.println("Vehicle [" + vehicle + "] departed the parking the parking garage.");
            departedCounter++;
            parkNextVehicle(); //park next vehicle
        }
    }

    public void viewNextWaitingVehicle() {
        System.out.println("\nView Next Waiting Vehicle -----");
        if (waitingVehicles.isEmpty()) System.out.println("Waiting queue is Empty.");
        else {
            System.out.println("Next waiting vehicle: " + waitingVehicles.peek());
        }
    }

    public void viewLastParkedVehicle() {
        System.out.println("\nView Last Parked Vehicle -----");
        if (parkedVehicles.isEmpty()) System.out.println("Parking garage is Empty.");
        else {
            System.out.println("Last parked vehicele: " + parkedVehicles.peek());
        }
    }

    public void displayWaitingQueue() {
        System.out.println("\nDisplay Waiting Queue -----");
        if (waitingVehicles.isEmpty()) System.out.println("No vehicles are waiting.");
        else {
            System.out.println("Waiting vehicle numbers: "+waitingVehicles.toString());
            System.out.println("Total waiting vehicles: "+waitingVehicles.size());
        }
    }

    public void displayParkedVehicles() {
        System.out.println("\nDisplay Parked Vehicles -----");
        if (parkedVehicles.isEmpty()) System.out.println("No vehicles are Parked.");
        else {
            System.out.println("Vehicles: "+parkedVehicles.toString());
            System.out.println("Garage Capacity: "+parkLimit);
            System.out.println("Occupied Spaces: "+parkedVehicles.size());
            System.out.println("Available Spaces: "+(parkLimit-parkedVehicles.size()));
        }
    }

    public void searchVehicle() {
        System.out.println("\nSearch Vehicle -----");
        //prompt user to enter vehicle plate number
        System.out.print("Enter vehicle number: ");
        vehicle = in.next().strip().toLowerCase();
        if (waitingVehicles.contains(vehicle)) { //is waiting?
            System.out.println("Vehicle is Waiting in queue.");
        } else if (parkedVehicles.search(vehicle) != -1){ // is parked?
            System.out.println("Vehicle is in Parked.");
        } else { //not in system
            System.out.println("Vehicle is not in the system.");
        }
    }

    public void displayGarageStatistics() {
        System.out.println("\nDisplay Garage Statistics -----");
        System.out.println("Maximum Capacity: "+parkLimit);
        System.out.println("Current Parked Vehicles: "+parkedVehicles.size());
        System.out.println("Waiting Vehicles: "+waitingVehicles.size());
        System.out.println("Available Spaces: "+(parkLimit-parkedVehicles.size()));

        System.out.println("Total Vehicles Parked Today: "+parkingCounter);
        System.out.println("Total Vehicles Departed Today: "+departedCounter);
        System.out.println("Total Vehicles Processed: "+(parkingCounter+departedCounter) );
        System.out.println("Garage Occupancy Percentage: "+((float)(parkLimit-parkedVehicles.size())/parkLimit)+"%");
    }

    public void clearWaitingQueue() {
        System.out.println("\nClear Waiting Queue -----");
        waitingVehicles.clear();
        System.out.println("Waiting queue is cleared");
    }

    public void clearParkingGarage() {
        System.out.println("\nClear Parking Garage -----");
        parkedVehicles.clear();
        System.out.println("Parking garage is cleared");
    }

    public void resetEntireSystem() {
        System.out.println("\nReset Entire System -----");
        waitingVehicles.clear();
        parkedVehicles.clear();
        System.out.println("Parking garage is cleared");
    }
}
