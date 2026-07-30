package task358;

import java.util.HashMap;
import java.util.Scanner;

public class ProductPriceCatalog {
    //declare variables
    HashMap<String, Double> products=new HashMap<String, Double>();
    Scanner in = new Scanner(System.in);
    int size;
    String name,searchResult,updateResult,choice,classification;
    double price;

    void main(){
        //Prompt the user to enter the number of students
        System.out.print("Enter the number of Products: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of products.");
        } else {
            //if size is valid: prompt user to enter name and price
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {
                //read id
                System.out.print(i + " - enter product name: ");
                name = in.next();
                //add to set and ensure there is no duplicate
                if (products.containsKey(name)) {
                    System.out.println("Product already exists. Record not added..");
                } else {
                    System.out.print("    enter product price: ");
                    price = in.nextDouble();
                    while (price<0){
                        System.out.print("    Invalid price. enter product price: ");
                        price = in.nextFloat();
                    }
                }
                products.put(name, price);
            }

            //prompt the user to enter a product name to search for
            System.out.print("\nSearch -----\nenter product name: ");
            name = in.next();
            if (products.containsKey(name)){
                searchResult="Product Found: [price "+products.get(name)+"]";
                System.out.print("Product Found. Do you want to update price (y/n)");
                choice=in.next().strip().toLowerCase();
                if (choice.equals("y")){
                    System.out.print("Enter product new price: ");
                    price=in.nextInt();
                    products.put(name, price);
                    updateResult="Price updated successfully. new price: "+price;
                }else{
                    updateResult="No updates";
                }
            }else{
                searchResult="Product not found.";
                updateResult="No updates";
            }

            //classify size of inventory
            if (products.size()<5)classification="Small Inventory";
            else if (products.size()<=10)classification="Medium Inventory";
            else classification="Large Inventory";

            //display results
            System.out.println("\nInformation -----\nTotal products entered: "+size);
            System.out.println("Total unique products: "+products.size());
            System.out.println("All products (name=price): "+products);
            System.out.println("Search result for ("+name+"): "+searchResult);
            System.out.println("Update result for ("+name+"): "+updateResult);
            System.out.println("Inventory classification: "+classification);
        }

        //close scanner
        in.close();
    }
}
