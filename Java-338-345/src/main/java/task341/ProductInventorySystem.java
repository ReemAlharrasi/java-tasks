package task341;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductInventorySystem {
    //initialize variables
    ArrayList<String> productNames = new ArrayList<String>();
    ArrayList<Integer> productQuantities = new ArrayList<Integer>();
    ArrayList<Double> productPrices = new ArrayList<Double>();

    int index;

    int totalQuantity;
    double inventoryValue;

    ArrayList<String> low;
    ArrayList<String> outOfStock;
    ArrayList<String> available;

    ArrayList<String> productsSortedAlpha;
    ArrayList<String> productsNamesSortedPriceDesc;
    ArrayList<Double> productSortedPrices;

    char letter1;
    char letter2;
    String product;
    double price;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 10 products
        productNames.add("Milk");
        productQuantities.add(10);
        productPrices.add(3.0);

        productNames.add("Eggs");
        productQuantities.add(0);
        productPrices.add(12.0);

        productNames.add("Cheese");
        productQuantities.add(19);
        productPrices.add(50.6);

        productNames.add("Yogurt");
        productQuantities.add(7);
        productPrices.add(1.5);

        productNames.add("Onion");
        productQuantities.add(103);
        productPrices.add(0.5);

        productNames.add("Garlic");
        productQuantities.add(100);
        productPrices.add(0.56);

        productNames.add("Ginger");
        productQuantities.add(56);
        productPrices.add(1.1);

        productNames.add("Pepper");
        productQuantities.add(15);
        productPrices.add(5.3);

        productNames.add("Pumpkin");
        productQuantities.add(3);
        productPrices.add(90.1);

        productNames.add("Carrot");
        productQuantities.add(80);
        productPrices.add(4.5);

        //call functions
        System.out.println("\n----- Display Product inventory -----");
        displayInventory();

        System.out.println("\n----- Add New Product -----");
        addProduct();

        System.out.println("\n----- Update Product Information -----");
        updateProduct();

        System.out.println("\n----- Search Product -----");
        searchProduct();

        System.out.println("\n----- Search Product -----");
        stockAnalysis();

        System.out.println("\n----- Stock Status Checking -----");
        stockStatus();

        System.out.println("\n----- Remove Product -----");
        removeProduct();

        System.out.println("\n----- Sorting -----");
        sortingProducts();
    }

    //display inventory
    public void displayInventory() {
        System.out.printf("%-8s %-10s %-10s %-9s\n", "Product", "Name", "Quantity", "Price");
        for (int i = 0; i < productNames.size(); i++) {
            System.out.printf("%-8s %-10s %-10d %-9.3f\n", i, productNames.get(i), productQuantities.get(i), productPrices.get(i));
        }
    }

    //add new product
    public void addProduct() {
        System.out.print("Enter name: ");
        productNames.add(in.next());
        System.out.print("Enter quantity: ");
        productQuantities.add(in.nextInt());
        System.out.print("Enter price: ");
        productPrices.add(in.nextDouble());
        //display updated list
        System.out.println("Updated list-----");
        displayInventory();
    }

    // Update Product Information
    public void updateProduct() {
        System.out.print("Enter index: ");
        index = in.nextInt();
        if (index < productNames.size() && index >= 0) {
            //display selected product
            System.out.printf("Selected product:\n%-8s %-10s %-10s %-9s\n", "Product", "Name", "Quantity", "Price");
            System.out.printf("%-8s %-10s %-10d %-9.3f\nupdate----->\n", index, productNames.get(index), productQuantities.get(index), productPrices.get(index));
            //get input and replace name, quantity, and price
            System.out.print("Enter new name: ");
            productNames.set(index, in.next());
            System.out.print("Enter new quantity: ");
            productQuantities.set(index, in.nextInt());
            System.out.print("Enter new price: ");
            productPrices.set(index, in.nextDouble());
            //display updated list
            System.out.println("Updated list-----");
            displayInventory();
        } else {
            System.out.println("index out of range");
        }

    }

    //Search Product System
    public void searchProduct() {
        System.out.print("Enter name: ");
        index = productNames.indexOf(in.next());
        if (index != -1) {
            //display selected product
            System.out.printf("Product Found:\n%-8s %-10s %-10s %-9s\n", "Product", "Name", "Quantity", "Price");
            System.out.printf("%-8s %-10s %-10d %-9.3f\n", index, productNames.get(index), productQuantities.get(index), productPrices.get(index));
        } else {
            System.out.println("Product not found!");
        }
    }

    //stock analysis
    public void stockAnalysis() {
        //initialize variables to zero
        totalQuantity = 0;
        inventoryValue = 0.0;

        //loop to update above variables
        for (int i = 0; i < productNames.size(); i++) {
            totalQuantity += productQuantities.get(i);
            inventoryValue += (productQuantities.get(i) * productPrices.get(i));
        }
        //display stats
        System.out.println("Total number of products: " + productNames.size());
        System.out.println("Total quantity of all products: " + totalQuantity);
        System.out.println("Total inventory value: " + inventoryValue);
    }

    //stock status
    public void stockStatus() {
        //initialize variables
        low = new ArrayList<String>();
        outOfStock = new ArrayList<String>();
        available = new ArrayList<String>();

        //loop to update above variables
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i)>0){
                available.add(productNames.get(i)); //add to available list
                if (productQuantities.get(i)<5) low.add(productNames.get(i)); //add to low list
            }else{
                outOfStock.add(productNames.get(i)); //add to outOfStock list
            }
        }

        //display stats
        System.out.println("Low Stock: " + low.toString());
        System.out.println("Out of Stock: " + outOfStock.toString());
        System.out.println("Available: " + available.toString());
    }

    //remove Product System
    public void removeProduct() {
        System.out.print("Enter index: ");
        index = in.nextInt();
        if (index != -1) {
            //remove product from all lists
            productNames.remove(index);
            productQuantities.remove(index);
            productPrices.remove(index);
            //display updates list
            System.out.println("Product removed successfully\nUpdated list-----");
            displayInventory();
        } else {
            System.out.println("Product not found!");
        }
    }

    //sorting alphabetically and by price (descending)
    public void sortingProducts(){
        //alphabetically
        productsSortedAlpha=new ArrayList<String>(productNames);
        for (int i = 0; i < productsSortedAlpha.size(); i++) {
            for (int j = i + 1; j < productsSortedAlpha.size(); j++) {

                //get the first character of two items to compare
                letter1 = productsSortedAlpha.get(i).toLowerCase().charAt(0);
                letter2 = productsSortedAlpha.get(j).toLowerCase().charAt(0);

                //compare and swap if smaller
                if ((int) letter1 > (int) letter2) {
                    //update current
                    product = productsSortedAlpha.get(i);
                    productsSortedAlpha.set(i, productsSortedAlpha.get(j));
                    productsSortedAlpha.set(j, product);
                }
            }
        }

        //display results
        System.out.println("\nAlphabetically Sorted list-----");
        System.out.printf("%-8s %-10s %-10s %-9s\n", "Product", "Name", "Quantity", "Price");
        for (String product:productsSortedAlpha) {
            index=productNames.indexOf(product);
            System.out.printf("%-8s %-10s %-10d %-9.3f\n", index, productNames.get(index), productQuantities.get(index), productPrices.get(index));
        }

        //price (descending)
        productsNamesSortedPriceDesc=new ArrayList<String>(productNames);
        productSortedPrices=new ArrayList<Double>(productPrices);
        for (int i = 0; i < productSortedPrices.size(); i++) {
            for (int j = i + 1; j < productSortedPrices.size(); j++) {

                //compare and swap if smaller
                if (productSortedPrices.get(j) > productSortedPrices.get(i)) {
                    //update current price
                    price = productSortedPrices.get(i);
                    productSortedPrices.set(i, productSortedPrices.get(j));
                    productSortedPrices.set(j, price);

                    //update current name
                    product = productsNamesSortedPriceDesc.get(i);
                    productsNamesSortedPriceDesc.set(i, productsNamesSortedPriceDesc.get(j));
                    productsNamesSortedPriceDesc.set(j, product);
                }
            }
        }
        //display results
        System.out.println("\nprice (descending) Sorted list-----");
        System.out.printf("%-8s %-10s %-10s %-9s\n", "Product", "Name", "Quantity", "Price");
        for (String product:productsNamesSortedPriceDesc) {
            index=productNames.indexOf(product);
            System.out.printf("%-8s %-10s %-10d %-9.3f\n", index, productNames.get(index), productQuantities.get(index), productPrices.get(index));
        }
    }
}
