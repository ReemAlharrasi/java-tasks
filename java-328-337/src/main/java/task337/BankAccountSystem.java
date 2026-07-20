package task337;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem {
    //create required variables
    ArrayList<Integer> accountNumbers = new ArrayList<Integer>();
    ArrayList<String> customerNames = new ArrayList<String>();
    ArrayList<Double> balances = new ArrayList<Double>();
    int accountId;
    double money;
    double total = 0.0;
    double balance;
    int index;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 5 customers to the bank system
        accountNumbers.add(639362863);
        customerNames.add("Reem");
        balances.add(3231.0);

        accountNumbers.add(403245588);
        customerNames.add("Salwa");
        balances.add(9231.0);

        accountNumbers.add(746005412);
        customerNames.add("Salima");
        balances.add(7631.0);

        accountNumbers.add(958883469);
        customerNames.add("Ali");
        balances.add(465231.0);

        accountNumbers.add(724153638);
        customerNames.add("Omar");
        balances.add(231.0);


        //menu
        int choice = 0;

        while (choice != 6) {
            //print menu
            System.out.println("-----Bank Management System-----");
            System.out.print("""
                    Services:
                    1: Display all accounts
                    2: Deposit money
                    3: Withdraw money
                    4: Check account balance
                    5: Display account statistics
                    6: Exit the program
                    Choose a number: """);

            //let user choose from the menu
            choice = in.nextInt();

            //switch for the input
            switch (choice) {
                case 1: //display all accounts
                    displayAccounts();
                    break;
                case 2:
                    System.out.print("ُEnter Account ID: ");
                    accountId = in.nextInt();
                    depositMoney(accountId);
                    break;
                case 3:
                    System.out.print("ُEnter Account ID: ");
                    accountId = in.nextInt();
                    withdrawMoney(accountId);
                    break;
                case 4:
                    System.out.print("ُEnter Account ID: ");
                    accountId = in.nextInt();
                    checkBalance(accountId);
                    break;
                case 5:
                    calculateStatistics();
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

    //display all accounts function
    public void displayAccounts() {
        System.out.println("account list -----------");
        //formatted print so it looks like a table
        System.out.printf("%-4s %-20s %-20s %-20s\n", "No.", "Account ID", "Customer Name", "Balance");
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.printf("%-4s %-20d %-20s %-20.3f\n", (i + 1), accountNumbers.get(i), customerNames.get(i), balances.get(i));
        }
    }

    //deposit money account
    public void depositMoney(int id) {
        //check if account exists
        index = accountNumbers.indexOf(id);
        if (index != -1) {
            //update balance if account exists
            System.out.print("ُEnter Amount to be deposited: ");
            money = in.nextDouble();
            balance = balances.get(index);
            balances.set(index, (balance + money));
            System.out.println(money + " has been deposited into account: " + id);
            System.out.println("New balance : " + (balance + money));
        } else {
            System.out.println("Fail: Account does not exist");
        }
    }

    //withdraw money
    public void withdrawMoney(int id) {
        //check if account exists
        index = accountNumbers.indexOf(id);
        if (index != -1) {//if account exists
            //check if amount is <= balance
            System.out.print("ُEnter Amount to be deposited: ");
            money = in.nextDouble();
            balance = balances.get(index);
            if (money <= balance) { //can withdraw
                balances.set(index, balance - money);
                System.out.println(money + " has been withdrawn from the account: " + id);
                System.out.println("New balance : " + (balance - money));
            } else {
                System.out.println("Fail: Insufficient balance");
            }

        } else {
            System.out.println("Fail: Account does not exist");
        }
    }

    //deposit money account
    public void checkBalance(int id) {
        //check if account exists
        if (accountNumbers.contains(id)) {
            System.out.println("Account balance: " + balances.get(accountNumbers.indexOf(id)));
        } else {
            System.out.println("Fail: Account does not exist");
        }
    }

    //show statistics function
    public void calculateStatistics() {
        double highestBalance = balances.get(0);
        double lowestBalance = balances.get(0);
        double current;
        for (int i = 0; i < balances.size(); i++) {
            current = balances.get(i);

            if (current > highestBalance) {
                highestBalance = current;
            } else if (current < lowestBalance) {
                lowestBalance = current;
            }
        }
        //display results
        System.out.println("Total balances: " + total);
        System.out.println("Highest account balance: " + highestBalance);
        System.out.println("Lowest account balance: " + lowestBalance);
    }

}

