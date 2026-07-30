package task344;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class CustomerOrderManagementSystem {
    //initialize variables
    ArrayList<Integer> orderIds = new ArrayList<Integer>();
    ArrayList<String> customerNames = new ArrayList<String>();
    ArrayList<String> productNames = new ArrayList<String>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();
    ArrayList<Double> prices = new ArrayList<Double>();
    ArrayList<Double> totalPrices = new ArrayList<Double>();
    ArrayList<String> orderStatus = new ArrayList<String>();

    //sorted lists
    ArrayList<String> customerNamesSortedAlpha;
    ArrayList<String> customerNamesSortedDesc;
    ArrayList<Double> pricesSortedDesc;

    double totalsales;
    double average;
    double highestorder, lowestOrder;

    int pendingCount;
    int completedCount;
    int cancelledCount;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    // Creating the instance of Random class
    Random r = new Random();
    int index, id;
    String customer;
    double discount;
    char letter1, letter2;
    double price;

    int quantity;
    String status;
    HashSet<String> statusAllowed = new HashSet<>();


    void main() {
        //add status allowed inputs to set
        statusAllowed.add("pending");
        statusAllowed.add("cancelled");
        statusAllowed.add("completed");

        //Store information for at least 15 orders
        System.out.println("\n----- Add 15 entries -----");
        for (int i = 0; i < 15; i++) addNewOrder();

        //call functions
        System.out.println("\n----- Display Order list -----");
        displayOrders();

        System.out.println("\n----- Add New Order -----");
        addNewOrder();

        System.out.println("\n----- Calculate Order Statistics -----");
        orderStatistics();

        System.out.println("\n----- Order Status Analysis -----");
        statusAnalysis();

        System.out.println("\n----- Search Order System -----");
        System.out.print("Search by ID -----\nEnter ID: ");
        id = in.nextInt();
        searchOrder(id);
        System.out.print("\nSearch by name -----\nEnter Customer name: ");
        customer = in.next();
        searchOrder(customer);

        System.out.println("\n----- Update Order System -----");
        updateOrder();

        System.out.println("\n----- Discount Calculation System -----");
        discount();

        System.out.println("\n----- Remove Order -----");
        removeOrder();

        System.out.println("\n----- Sorting Orders -----");
        sortingOrders();

        //close scanner
        in.close();
    }

    //display all orders
    public void displayOrders() {
        //formatted print so it looks like a table
        System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s %-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
        for (int i = 0; i < orderIds.size(); i++) {
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", i, orderIds.get(i), customerNames.get(i), productNames.get(i), quantities.get(i), prices.get(i), totalPrices.get(i), orderStatus.get(i));
        }
    }

    //add new order
    public void addNewOrder() {
       System.out.print("Enter Customer name: ");
        customerNames.add(in.next().strip());

        System.out.print("Enter product Name: ");
        productNames.add(in.next().strip());

        System.out.print("Enter quantity: ");
        quantity = in.nextInt();
        while (quantity <= 0) {
            System.out.print("Invalid input. Enter quantity: ");
            quantity = in.nextInt();
        }
        quantities.add(quantity);

        System.out.print("Enter price: ");
        price = in.nextDouble();
        while (price < 0) {
            System.out.print("Invalid input. Enter price: ");
            price = in.nextDouble();
        }
        prices.add(price);
        totalPrices.add(prices.getLast() * quantities.getLast());

        System.out.print("Enter order status: ");
        status = in.next().strip().toLowerCase();
        while (!statusAllowed.contains(status)) {
            System.out.print("Invalid input. Enter order status: ");
            status = in.next().strip().toLowerCase();
        }
        orderStatus.add(status);

        id = r.nextInt(8999) + 1000; //gives random int between 1000 and 9999
        while (orderIds.contains(id)) id = r.nextInt(8999) + 1000;//ensure id is not repeated
        orderIds.add(id);
        System.out.println("Order added successfully. Total orders count: " + orderIds.size() + "\n");
    }

    //Calculate Order Statistics
    public void orderStatistics() {
        //initialize variables to zero
        totalsales = 0;
        highestorder = totalPrices.getFirst(); //assume they are the first item on the list
        lowestOrder = totalPrices.getFirst();

        //loop to update above values
        for (int i = 0; i < totalPrices.size(); i++) {
            totalsales += totalPrices.get(i);
            if (totalPrices.get(i) > highestorder) highestorder = totalPrices.get(i);
            else if (totalPrices.get(i) < lowestOrder) lowestOrder = totalPrices.get(i);
        }

        //calculate average
        average = (double) totalsales / orderIds.size();

        //display results
        System.out.println("Total number of orders: " + orderIds.size());
        System.out.println("Total sales amount: " + totalsales);
        System.out.println("Total number of orders: " + average);
    }

    //Order Status Analysis
    public void statusAnalysis() {
        //set variables to zero
        pendingCount = 0;
        completedCount = 0;
        cancelledCount = 0;

        //loop to update above variables
        for (int i = 0; i < prices.size(); i++) {
            if (orderStatus.get(i) == "Pending") pendingCount++;
            else if (orderStatus.get(i) == "Completed") completedCount++;
            else cancelledCount++;
        }

        //display results
        System.out.println("Pending Orders: " + pendingCount);
        System.out.println("Completed Orders: " + completedCount);
        System.out.println("Cancelled Orders: " + cancelledCount);
    }

    //Search Order System
    public void searchOrder(int id) {
        //get index of the book if it is in list
        int index = orderIds.indexOf(id);
        if (index != -1) {
            System.out.println("Order Details:");
            System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s %-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", index, orderIds.get(index), customerNames.get(index), productNames.get(index), quantities.get(index), prices.get(index), totalPrices.get(index), orderStatus.get(index));

        } else System.out.println("Order not found.");//print msg if not in library system
    }

    public void searchOrder(String name) {
        //get index of the order if it is in list
        int index = customerNames.indexOf(name);
        if (index != -1) {
            System.out.println("Order Details:");
            System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s %-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", index, orderIds.get(index), customerNames.get(index), productNames.get(index), quantities.get(index), prices.get(index), totalPrices.get(index), orderStatus.get(index));
        } else System.out.println("Order not found.");//print msg if not in library system
    }

    public void updateOrder() {
        System.out.print("Enter Index: ");
        index = in.nextInt();
        if (index >= 0 && index < orderIds.size()) {
            System.out.println("New Order Details:");
            System.out.print("Enter New Customer name: ");
            customerNames.set(index, in.next().strip());
            System.out.print("Enter New product Name: ");
            productNames.set(index, in.next().strip());
            System.out.print("Enter New quantity: ");
            quantities.set(index, in.nextInt());
            System.out.print("Enter New price: ");
            prices.set(index, in.nextDouble());
            totalPrices.set(index, (prices.get(index) * quantities.get(index)));
            System.out.print("Enter New order status: ");
            orderStatus.set(index, in.next().strip());

            System.out.println("Updated Order Details:");
            System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s%-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", index, orderIds.get(index), customerNames.get(index), productNames.get(index), quantities.get(index), prices.get(index), totalPrices.get(index), orderStatus.get(index));
        } else {
            System.out.println("Invalid index: out of range.");
        }
    }

    //discount funtion
    public void discount() {
        //formatted print so it looks like a table
        System.out.printf("%-8s %-12s %-12s %-12s\n", "ID", "Total price", "Discount ", "Final price");
        for (int i = 0; i < totalPrices.size(); i++) {
            if (totalPrices.get(i) >= 5000) discount = totalPrices.get(i) * 0.85;
            else if (totalPrices.get(i) >= 2000) discount = totalPrices.get(i) * 0.90;
            else if (totalPrices.get(i) >= 1000) discount = totalPrices.get(i) * 0.95;
            else discount = 0;
            System.out.printf("%-8d %-12.3f %-12.3f %-12.3f\n", orderIds.get(i), totalPrices.get(i), discount, (totalPrices.get(i) - discount));
        }
    }

    //remove order
    public void removeOrder() {
        //get index of the order if it is in list
        System.out.print("Enter index: ");
        index = in.nextInt();
        if (index >= 0 && index < orderIds.size()) {
            orderIds.remove(index);
            customerNames.remove(index);
            productNames.remove(index);
            quantities.remove(index);
            prices.remove(index);
            totalPrices.remove(index);
            orderStatus.remove(index);

            //display updated list
            displayOrders();
        } else System.out.println("Order not found.");//print msg if not in library system

    }

    //sorting alphabetically and by price (descending)
    public void sortingOrders() {
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
        System.out.println("\nAlphabetically Sorted list -----\n");
        System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s %-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
        for (int i = 0; i < customerNamesSortedAlpha.size(); i++) {
            index=customerNames.indexOf(customerNamesSortedAlpha.get(i));
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", index, orderIds.get(index), customerNames.get(index), productNames.get(index), quantities.get(index), prices.get(index), totalPrices.get(index), orderStatus.get(index));
        }

        //price (descending)
        customerNamesSortedDesc = new ArrayList<String>(customerNames);
        pricesSortedDesc = new ArrayList<Double>(totalPrices);
        for (int i = 0; i < pricesSortedDesc.size(); i++) {
            for (int j = i + 1; j < pricesSortedDesc.size(); j++) {

                //compare and swap if smaller
                if (pricesSortedDesc.get(j) > pricesSortedDesc.get(i)) {
                    //update current price
                    price = pricesSortedDesc.get(i);
                    pricesSortedDesc.set(i, pricesSortedDesc.get(j));
                    pricesSortedDesc.set(j, price);

                    //update current name
                    customer = customerNamesSortedDesc.get(i);
                    customerNamesSortedDesc.set(i, customerNamesSortedDesc.get(j));
                    customerNamesSortedDesc.set(j, customer);
                }
            }
        }
        //display results
        System.out.println("\nprice (descending) Sorted list -----\n");
        System.out.printf("%-8s %-8s %-18s %-18s %-12s %-12s %-12s %-20s \n", "Index", "ID", "Customer Name", "Product Name", "Quantity", "Price", "Total price", "Status");
        for (int i = 0; i < customerNamesSortedAlpha.size(); i++) {
            index=totalPrices.indexOf(pricesSortedDesc.get(i));
            System.out.printf("%-8d %-8d %-18s %-18s %-12d %-12.3f %-12.3f %-20s\n", index, orderIds.get(index), customerNames.get(index), productNames.get(index), quantities.get(index), prices.get(index), totalPrices.get(index), orderStatus.get(index));
        }
    }
}
