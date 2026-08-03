package task367;

import java.util.Scanner;
import java.util.Stack;

public class UndoActionManager {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    Stack<String> userActions = new Stack<>();
    int size,choice;
    String action;
    //main function
    void main(){
        //Prompt the user to enter the number of actions
        System.out.print("Enter the number of actions : ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of actions.");
        } else {
            //get input
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + "- enter Action: ");
                action = in.next();
                userActions.push(action);
            }

            //menu
            choice = 0;
            do {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Action");
                System.out.println("2. Undo Last Action");
                System.out.println("3. View Last Action");
                System.out.println("4. Search Action");
                System.out.println("5. Display All Actions");
                System.out.println("6. Display Action Statistics");
                System.out.println("7. Clear All Actions");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {

                    //Add Action
                    case 1:
                        addAction();
                        break;

                    //Undo Last Action
                    case 2:
                        undoLastAction();
                        break;

                    //View Last Action
                    case 3:
                        viewLastAction();
                        break;

                    //search Action
                    case 4:
                        searchAction();
                        break;

                    //display all records
                    case 5:
                        displayAllActions();
                        break;

                    //display statistics
                    case 6:
                        displayActionStatistics();
                        break;

                    //Clear All Actions
                    case 7:
                        clearAllActions();
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

    public void addAction(){
        System.out.println("\nAdd Action -----");
        System.out.print("Enter Action: ");
        action = in.next();//read from user
        userActions.push(action); //add to stack
        System.out.println("Action added successfully.");
    }
    public void undoLastAction(){
        System.out.println("\nUndo Last Action -----");
        if (userActions.empty()) System.out.println("No actions to undo."); //if stack is empty
        else {
            action = userActions.pop();
            System.out.println("Action removed successfully: [" + action + "]");
        }
    }
    public void viewLastAction(){
        System.out.println("\nView Last Action -----");
        if (userActions.empty()) System.out.println("No actions available.");//if stack is empty
        else {
            System.out.println("Last action: [" + userActions.peek() + "]");
        }
    }
    public void searchAction(){
        System.out.println("\nSearch Action -----");
        System.out.print("Enter Action: ");
        action = in.next();//read from user

        if (userActions.search(action) != -1) { //if found
            System.out.println("Action found. position from top: " + userActions.search(action));
        } else {
            System.out.println("Action not found.");
        }
    }
    public void displayAllActions(){
        System.out.println("\nDisplay All Actions -----");
        if (userActions.isEmpty()){
            System.out.println("No actions available.");//if stack is empty
            return;
        }
        for (int i = 0; i < userActions.size(); i++) { //display each name with index
            System.out.println((i + 1) + ". " + userActions.get(i));
        }
    }
    public void displayActionStatistics(){
        //display stats
        System.out.println("\nDisplay Action Statistics -----");
        if (userActions.isEmpty()){
            System.out.println("No actions available.");//if stack is empty
            return;
        }
        System.out.println("Total number of actions: "+userActions.size());
        System.out.println("Most recent action: "+ userActions.peek());
        System.out.print("stack is empty? ");
        if (userActions.isEmpty()) System.out.println("yes");
        else System.out.println("No");
    }
    public void clearAllActions(){
        System.out.println("\nClear All Actions -----");
        //Remove all actions using the clear()
        userActions.clear();
        System.out.println("All actions have been cleared.");
    }
}
