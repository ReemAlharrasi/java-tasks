package task350;

import java.util.HashSet;

public class CsvTablePrinter {
    //initialize variables
    String[] csvRows, header, input;

    void main() {
        //initialize rows
        csvRows = new String[]{"Name,Age,City", "Ali,25,Muscat",
                "Sara,30,Nizwa", "Reem,26,Barka", "Dhikra,31,Nakhal,3",
        };

        //get header columns and print them
        header = csvRows[0].strip().split(",");
        System.out.println(String.format("%-10s %-10s %-10s", header[0].trim(), header[1].trim(), header[2].trim()));

        //print seperator
        System.out.println("-".repeat(33));

        //loop through csv rows
        for (int i = 1; i < csvRows.length; i++) { //1 to skip header
            input = csvRows[i].strip().split(",");

            //validate input
            if (input.length > 3) {
                System.out.println("Skipping malformed row: Invalid record.");
            } else {
                //print results
                System.out.println(String.format("%-10s %-10s %-10s",input[0].trim(), input[1].trim(), input[2].trim()));

            }
        }
    }
}