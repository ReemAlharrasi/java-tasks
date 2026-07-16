package task335;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductInventorySystem {
    void main() {
        //initialize scanner to read input
        Scanner in=new Scanner(System.in);

        //create required lists
        ArrayList<String> productNames = new ArrayList<String>();
        ArrayList<Float> prices = new ArrayList<Float>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();
        ArrayList<String> stockStatus = new ArrayList<String>();

        //initialize required variables
        int quantity;

        //loop to allow user to enter 10 products
        System.out.println("-----Products inputs-----");
        for (int i=1;i<=10;i++){
            System.out.println("Product "+ i);
            System.out.print("Enter name: ");
            productNames.add(in.next());
            System.out.print("Enter price: ");
            prices.add(in.nextFloat());
            System.out.print("Enter quantity: ");
            quantity=in.nextInt();
            quantities.add(quantity);
            //call function to check stock status
            stockStatus.add(checkStockStatus(quantity));
            System.out.println(); //skip line
        }

        //initialize required variables
        float total;
        int countAvailable;
        int countOutOfStock;
        String mostExpensiveProduct;

        //call function to calculate inventory value
        total=calculateTotalValue(prices,quantities);

        //call function to get number of items that are available and items that are out of stock
        int[] result=countStockStatus(quantities);
        countAvailable=result[0];
        countOutOfStock=result[1];

        //call function to get the name of most expensive item
        mostExpensiveProduct=findMostExpensiveProduct(productNames,prices);

        //call display report function
        displayReport(productNames, prices,quantities, stockStatus, total, countAvailable,countOutOfStock, mostExpensiveProduct);

        //close scanner
        in.close();
    }

    //function that calculates inventory value
    public float calculateTotalValue(ArrayList<Float> prices,ArrayList<Integer> quantities){
        float total=0f;
        for (int i=0;i<prices.size();i++){
            total+= (prices.get(i)*quantities.get(i));
        }
        return total;
    }

    // function that gives status by quantity value
    public String checkStockStatus(int quantity){
        if (quantity>10) return  "High Stock";
        else if (quantity>=1) return  "Available";
        else return "Out of Stock";
    }

    // countStockStatus
    public int[] countStockStatus(ArrayList<Integer> quantities){
        int available=0;
        int outOfStock=0;
        for (int num:quantities){
            if (num>0)available++;
            else outOfStock++;
        }
        return new int[]{available, outOfStock};
    }

    //function that returns the name of the most expensive product
    public String findMostExpensiveProduct(ArrayList<String> products,ArrayList<Float> prices){
        //assume it is the first item in list
        String mostExpensive=products.get(0);
        float highestPrice=prices.get(0);

        //loop to compare highest with all items
        for (int i=0;i<products.size();i++){
            if (prices.get(i)>highestPrice) {
                highestPrice=prices.get(i);
                mostExpensive=products.get(i);
            }
        }
        return mostExpensive;
    }

    //function to display report of the inventory
    public void displayReport(ArrayList<String> products,ArrayList<Float> prices,ArrayList<Integer> quantities,ArrayList<String> status,float total,int available,int outOfStock,String mostExpensive){
        System.out.println("------- Product inventory report -------");
        System.out.println("Products -----------");
        System.out.printf("%-4s %-8s %-8s %-9s %-8s\n","No.","Product","Price","Quantity","Status");
        for (int i=0;i<products.size();i++){
            System.out.printf("%-4s %-8s %-8.3f %-9d %-8s\n",(i+1),products.get(i),prices.get(i),quantities.get(i),status.get(i));
        }
        System.out.println("information -----------");
        System.out.println("Total inventory value: "+total);
        System.out.println("Number of available products: "+available);
        System.out.println("Number of out-of-stock products: "+outOfStock);
        System.out.println("Most expensive product: "+mostExpensive);
    }

}
