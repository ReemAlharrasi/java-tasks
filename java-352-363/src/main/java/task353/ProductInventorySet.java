package task353;

import java.util.HashSet;
import java.util.Scanner;

public class ProductInventorySet {
    //declare variables
    HashSet<String> productNames=new HashSet<>();
    Scanner in = new Scanner(System.in);
    int size;
    String product,searchResult,inventorySize;

    void main(){
        //Prompt the user to enter the number of products
        System.out.print("enter the number of products: ");
        size = in.nextInt();

        //validate input
        if (size <= 0){
            System.out.println("Invalid number of products.");
        }
        else{
            //if size is valid
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print("enter Product ("+i+"): ");
                product = in.next();
                //add to set and ensure there is no duplicate
                if (productNames.contains(product)){
                    System.out.println("Product already exists. Duplicate entries are not allowed.");
                }else{
                    productNames.add(product);
                }
            }

            //prompt the user to enter a product name to search for
            System.out.print("\nSearch -----\nenter Product name: ");
            product = in.next();
            if (productNames.contains(product)){
                searchResult="Product found in inventory.";
            }else{
                searchResult="Product not found in inventory.";
            }

            //classify inventory
            if (productNames.size()<5)inventorySize="Small Inventory";
            else if (productNames.size()<=10)inventorySize="Medium Inventory";
            else inventorySize="Large Inventory";

            //display results
            System.out.println("\nTotal products entered: "+size);
            System.out.println("Total unique products: "+productNames.size());
            System.out.println("All products in the inventory: "+productNames);
            System.out.println("Search result for ("+product+"): "+searchResult);
            System.out.println("Inventory classification: "+inventorySize);
        }

        //close scanner
        in.close();
    }
}
