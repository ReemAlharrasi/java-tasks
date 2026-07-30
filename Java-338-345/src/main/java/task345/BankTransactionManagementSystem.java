package task345;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BankTransactionManagementSystem {
    //initialize variables
    ArrayList<Integer> accountNumbers = new ArrayList<Integer>();
    ArrayList<String> customerNames = new ArrayList<String>();
    ArrayList<Double> balances = new ArrayList<Double>();
    ArrayList<String> accountTypes = new ArrayList<String>();
    ArrayList<String> accountStatus = new ArrayList<String>();

    //sorted lists
    ArrayList<String> customerNamesSortedAlpha;
    ArrayList<String> customerNamesSortedDesc;
    ArrayList<Double> balancesSortedDesc;

    //sets
    HashSet<String> allowedTypes=new HashSet<>();
    HashSet<String> allowedStatus=new HashSet<>();

    int number,index, senderIndex,receiverIndex;
    double balance,deposit,withdraw,transfer;
    String status,type,customer;
    char letter1, letter2;

    double totalMoney,average,highestBalance,lowestBalance;
    int activeCount,suspendedCount,closedCount;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    // Creating the instance of Random class
    Random r = new Random();

    //main function
    void main(){
        //add allowed types and status to set
        allowedTypes.add("savings");
        allowedTypes.add("current");

        allowedStatus.add("active");
        allowedStatus.add("suspended");
        allowedStatus.add("closed");


        //add 10 customer accounts
        accountNumbers.add(10001);customerNames.add("Ali");balances.add(2500.0);accountTypes.add("Savings");accountStatus.add("Active");
        accountNumbers.add(10002);customerNames.add("Sara");balances.add(1400.50);accountTypes.add("Current");accountStatus.add("Active");
        accountNumbers.add(10003);customerNames.add("Omer");balances.add(3200.0);accountTypes.add("Savings");accountStatus.add("Active");
        accountNumbers.add(10004);customerNames.add("Fatima");balances.add(850.75);accountTypes.add("Current");accountStatus.add("Active");
        accountNumbers.add(10005);customerNames.add("Zaid");balances.add(5000.0);accountTypes.add("Savings");accountStatus.add("Active");
        accountNumbers.add(10006);customerNames.add("Mona");balances.add(120.0);accountTypes.add("Savings");accountStatus.add("Suspended");
        accountNumbers.add(10007);customerNames.add("Khaled");balances.add(4100.25);accountTypes.add("Current");accountStatus.add("Active");
        accountNumbers.add(10008);customerNames.add("Huda");balances.add(950.0);accountTypes.add("Savings");accountStatus.add("Closed");
        accountNumbers.add(10009);customerNames.add("Tariq");balances.add(6700.80);accountTypes.add("Current");accountStatus.add("Active");
        accountNumbers.add(10010);customerNames.add("Reem");balances.add(310.50);accountTypes.add("Savings");accountStatus.add("Active");

        //call functions
        System.out.println("\n----- Display Account Information -----");
        displayAccounts();

        System.out.println("\n----- create Account -----");
        addNewAccount();

        System.out.println("\n----- Deposit Money System -----");
        depositMoney();

        System.out.println("\n----- Withdraw Money System -----");
        withdrawMoney();

        System.out.println("\n----- Transfer Money System -----");
        transferMoney();

        System.out.println("\n----- Account Search System -----");

        //by account number
        System.out.print("by account number -----\nEnter Account number: ");
        number = in.nextInt();
        searchAccount(number);

        //by customer name
        System.out.print("Enter Customer name: ");
        customer=in.next().strip();
        searchAccount(customer);

        System.out.println("\n----- Banking Statistics Report -----");
        statisticsReport();

        System.out.println("\n----- Account Status Report -----");
        accountStatusAnalysis();

        System.out.println("\n----- Update Account Information -----");
        updateAccount();

        System.out.println("\n----- Remove Account -----");
        removeAccount();

        System.out.println("\n----- Sort Accounts -----");
        sortingAccounts();

        //close scanner
        in.close();
    }

    //Display all customer accounts with complete details
    public void displayAccounts(){
        //formatted print so it looks like a table
        System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", i, accountNumbers.get(i), customerNames.get(i), accountTypes.get(i), balances.get(i), accountStatus.get(i));
        }
    }

    //add new account
    public void addNewAccount() {
        System.out.print("Enter Customer name: ");
        customerNames.add(in.next().strip());

        System.out.print("Enter Initial balance: ");
        balance = in.nextDouble();
        while (balance < 0) { //ensure balance is not negative
            System.out.print("Invalid input. Enter initial balance: ");
            balance = in.nextDouble();
        }
        balances.add(balance);

        System.out.print("Enter Account type: ");
        type=in.next().strip();
        while (!allowedTypes.contains(type)) { //validate type
            System.out.print("Invalid input. Enter Account type: ");
            type = in.next().strip().toLowerCase();
        }
        accountTypes.add(type);

        accountStatus.add("Active");

        number = r.nextInt(89999) + 10000; //gives random int between 10000 and 99999
        while (accountNumbers.contains(number)) number = r.nextInt(89999) + 10000;//ensure id is not repeated
        accountNumbers.add(number);

        System.out.println("Account created successfully with account number: " + number + "\n");
    }

    //function Deposit Money System
    public void depositMoney(){
        //prompt user
        System.out.print("Enter Account number: ");
        number = in.nextInt();

        //search account
        index=accountNumbers.indexOf(number);
        if (index!=-1){
            balance=balances.get(index);
            //Ask for deposit amount and validate it
            System.out.print("Enter deposit amount: ");
            deposit = in.nextDouble();
            while (deposit <= 0) { //ensure balance is not negative
                System.out.print("Invalid input. Enter deposit amount: ");
                deposit = in.nextDouble();
            }
            //update account balance and display it
            balances.set(index,balance+deposit);
            System.out.print("Deposit completed. New balance: "+balances.get(index));
        }else{
            System.out.print("Account not found");
        }
    }

    //function withdraw Money System
    public void withdrawMoney(){
        //prompt user
        System.out.print("Enter Account number: ");
        number = in.nextInt();

        //search account
        index=accountNumbers.indexOf(number);
        if (index!=-1){
            balance=balances.get(index);
            //Ask for deposit amount and validate it
            System.out.print("Account Balance: "+balance+"\nEnter withdrawal  amount: ");
            withdraw = in.nextDouble();
            while (withdraw <= 0 || withdraw >balance) { //ensure balance is not negative
                System.out.print("Invalid input. Enter withdrawal amount: ");
                withdraw = in.nextDouble();
            }
            //update account balance and display it
            balances.set(index,balance-withdraw);
            System.out.print("withdrawal successful. Remaining balance: "+balances.get(index));
        }else{
            System.out.print("Account not found");
        }
    }

    //function transfer Money System
    public void transferMoney(){
        //prompt user and search accounts
        //sender
        System.out.print("Enter sender account number: ");
        number = in.nextInt();
        senderIndex=accountNumbers.indexOf(number);
        //receiver
        System.out.print("Enter receiver account number: ");
        number = in.nextInt();
        receiverIndex=accountNumbers.indexOf(number);

        if (senderIndex!=-1 && receiverIndex!=-1){
            //withdraw from sender
            balance=balances.get(senderIndex); //sender
            //Ask for transfer amount and validate it
            System.out.print("Account Balance: "+balance+"\nEnter amount to be transferred: ");
            transfer = in.nextDouble();
            while (transfer <= 0 || transfer >balance) { //ensure balance is not negative
                System.out.print("Invalid input. Enter amount to be transferred: ");
                transfer = in.nextDouble();
            }
            //update sender account balance
            balances.set(senderIndex,balance-transfer);

            // add money to receiver and update account balance
            balance=balances.get(receiverIndex);
            balances.set(receiverIndex,balance+transfer);

            //display new balances
            System.out.println("\nTransfer successful\nTransferred amount: "+transfer);

        }else{
            System.out.println("Accounts not found");
        }
    }

    //functions search an account
    //by account number
    public void searchAccount(int num){ //by account number
        index=accountNumbers.indexOf(num);
        if (index!=-1){
            //display account information if found
            System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", index, accountNumbers.get(index), customerNames.get(index), accountTypes.get(index), balances.get(index), accountStatus.get(index));

        }else{
            System.out.println("Account not found");
            System.out.println();

        }

    }
    //by customer name
    public void searchAccount(String name){ //by customer name
        index=customerNames.indexOf(name);
        if (index!=-1){
            //display account information if found
            System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", index, accountNumbers.get(index), customerNames.get(index), accountTypes.get(index), balances.get(index), accountStatus.get(index));

        }else{
            System.out.println("Account not found");

        }

    }

    // function to generate Banking Statistics Report
    public void statisticsReport(){
        //initialize start values
        totalMoney=0;
        highestBalance=balances.getFirst();
        lowestBalance=balances.getFirst();

        //loop through balances to update above variables
        for (double balance:balances){
            totalMoney+=balance;
            if(balance>highestBalance) highestBalance=balance;
            else if (balance<lowestBalance) lowestBalance=balance;
        }

        //calculate average
        average= (double) totalMoney/balances.size();

        //display results
        System.out.println("Total number of accounts: "+balances.size());
        System.out.println("Total money stored in all accounts: "+totalMoney);
        System.out.println("Average account balance: "+String.format("%.3f", average));
        System.out.println("Highest account balance: "+highestBalance);
        System.out.println("Lowest account balance: "+lowestBalance);

    }

    // function to coun t active, suspended and closed accounts
    public void accountStatusAnalysis(){
        //initialize start values
        activeCount=0;
        suspendedCount=0;
        closedCount=0;

        //loop to update above values
        for (String status:accountStatus){
            if (status.toLowerCase().equals("active")) activeCount++;
            else if (status.toLowerCase().equals("suspended")) suspendedCount++;
            else if (status.toLowerCase().equals("closed")) closedCount++;
        }

        //display results
        System.out.println("Active Accounts: "+activeCount);
        System.out.println("Suspended Accounts: "+suspendedCount);
        System.out.println("Closed Accounts: "+closedCount);

    }

    //function to update account
    public void updateAccount(){
        //ask for account index
        System.out.print("Enter Account Index: ");
        index=in.nextInt();

        //validate index
        if (index>=0 && index<accountNumbers.size()){
            //name
            System.out.print("Enter Customer name: ");
            customerNames.set(index,in.next().strip());

            //type
            System.out.print("Enter Account type: ");
            type=in.next().strip();
            while (!allowedTypes.contains(type)) { //validate type
                System.out.print("Invalid input. Enter Account type: ");
                type = in.next().strip().toLowerCase();
            }
            accountTypes.set(index,type);

            //status
            System.out.print("Enter Account Status: ");
            status=in.next().strip();
            while (!allowedStatus.contains(status)) { //validate type
                System.out.print("Invalid input. Enter Account Status: ");
                status = in.next().strip().toLowerCase();
            }
            accountStatus.set(index,status);
            System.out.println("Account updated successfully -----");
            System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", index, accountNumbers.get(index), customerNames.get(index), accountTypes.get(index), balances.get(index), accountStatus.get(index));

        }else{
            System.out.println("Index out of range!");
        }
    }

    //function to remove account
    public void removeAccount(){
        //ask for account index
        System.out.print("Enter Account Index: ");
        index=in.nextInt();

        //validate index
        if (index>=0 && index<accountNumbers.size()){
            accountNumbers.remove(index);
            customerNames.remove(index);
            accountTypes.remove(index);
            balances.remove(index);
            accountStatus.remove(index);

            //display result and updated list
            System.out.println("Account removed Successfully.\n");
            displayAccounts();
        } else {
            System.out.println("Index out of range");
        }
    }

    //sorting alphabetically and by price (descending)
    public void sortingAccounts() {
        //alphabetically
        customerNamesSortedAlpha = new ArrayList<String>(customerNames);
        for (int i = 0; i < customerNamesSortedAlpha.size(); i++) {
            for (int j = i + 1; j < customerNamesSortedAlpha.size(); j++) {

                //get the first character of two items to compare
                letter1 = customerNamesSortedAlpha.get(i).toLowerCase().charAt(0);
                letter2 = customerNamesSortedAlpha.get(j).toLowerCase().charAt(0);

                //compare and swap if smaller
                if ((int) letter1 > (int) letter2) {
                    //update current
                    customer = customerNamesSortedAlpha.get(i);
                    customerNamesSortedAlpha.set(i, customerNamesSortedAlpha.get(j));
                    customerNamesSortedAlpha.set(j, customer);
                }
            }
        }

        //display results
        System.out.println("\nAlphabetically Sorted list-----\n");
        System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
        for (int i = 0; i < accountNumbers.size(); i++) {
            index=customerNames.indexOf(customerNamesSortedAlpha.get(i));
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", index, accountNumbers.get(index), customerNames.get(index), accountTypes.get(index), balances.get(index), accountStatus.get(index));
        }

        //price (descending)
        customerNamesSortedDesc = new ArrayList<String>(customerNames);
        balancesSortedDesc = new ArrayList<Double>(balances);
        for (int i = 0; i < balancesSortedDesc.size(); i++) {
            for (int j = i + 1; j < balancesSortedDesc.size(); j++) {

                //compare and swap if smaller
                if (balancesSortedDesc.get(j) > balancesSortedDesc.get(i)) {
                    //update current price
                    balance = balancesSortedDesc.get(i);
                    balancesSortedDesc.set(i, balancesSortedDesc.get(j));
                    balancesSortedDesc.set(j, balance);

                    //update current name
                    customer = customerNamesSortedDesc.get(i);
                    customerNamesSortedDesc.set(i, customerNamesSortedDesc.get(j));
                    customerNamesSortedDesc.set(j, customer);
                }
            }
        }
        //display results
        System.out.println("\nAccounts (descending) Sorted list-----\n" + balancesSortedDesc.toString());
        System.out.printf("%-8s %-18s %-18s %-18s %-18s %-18s\n", "Index", "Account numbe", "Customer Name", "Account type", "Balance", "Status");
        for (int i = 0; i < accountNumbers.size(); i++) {
            index=balances.indexOf(balancesSortedDesc.get(i));
            System.out.printf("%-8d %-18s %-18s %-18s %-18.3f %-18s\n", index, accountNumbers.get(index), customerNames.get(index), accountTypes.get(index), balances.get(index), accountStatus.get(index));
        }
    }
}
