package task342;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeSalaryManagementSystem {
    //initialize variables
    ArrayList<String> employeeNames = new ArrayList<String>();
    ArrayList<Integer> employeeIds = new ArrayList<Integer>();
    ArrayList<Double> employeeSalaries = new ArrayList<Double>();

    double totalSalaries;
    double highestSalary;
    double lowestSalary;

    int above1000Count;
    int between500and1000Count;
    int below500Count;

    int index;
    int id;
    double salary;
    double bonus;
    String name;

    ArrayList<String> employeeNamesSorted;
    ArrayList<Double> employeeSalariesSorted;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 10 employees
        employeeNames.add("Reem");
        employeeIds.add(177835);
        employeeSalaries.add(1417.10);

        employeeNames.add("Salma");
        employeeIds.add(203681);
        employeeSalaries.add(1252.90);

        employeeNames.add("Ali");
        employeeIds.add(155851);
        employeeSalaries.add(857.14);

        employeeNames.add("Muneer");
        employeeIds.add(159390);
        employeeSalaries.add(641.46);

        employeeNames.add("Salima");
        employeeIds.add(219736);
        employeeSalaries.add(1241.43);

        employeeNames.add("Rima");
        employeeIds.add(167741);
        employeeSalaries.add(1381.70);

        employeeNames.add("Noor");
        employeeIds.add(208467);
        employeeSalaries.add(690.01);

        employeeNames.add("Hoor");
        employeeIds.add(172843);
        employeeSalaries.add(500.83);

        employeeNames.add("Hanan");
        employeeIds.add(180364);
        employeeSalaries.add(1296.98);

        employeeNames.add("Jokha");
        employeeIds.add(219112);
        employeeSalaries.add(1313.15);

        //call functions
        System.out.println("\n----- Display Employee Information -----");
        displayEmployees();

        System.out.println("\n----- Calculate Salary Statistics -----");
        calculateSalaryStatistics();

        System.out.println("\n----- Salary Category Analysis -----");
        salaryCategoryAnalysis();

        System.out.println("\n----- Search Employee -----");
        searchEmployee();

        System.out.println("\n----- Update Employee Salary -----");
        updateEmployee();

        System.out.println("\n----- Remove Employee -----");
        removeEmployee();

        System.out.println("\n----- Sorting Employees -----");
        sortEmplyees();

        System.out.println("\n----- Bonus Calculation -----");
        bonusCalculation();
    }

    //function to display all employees in table form
    public void displayEmployees() {
        System.out.printf("%-8s %-10s %-10s %-9s\n", "Index", "ID", "Name", "Salary");
        for (int i = 0; i < employeeNames.size(); i++) {
            System.out.printf("%-8s %-10d %-10s %-9.3f\n", i, employeeIds.get(i), employeeNames.get(i), employeeSalaries.get(i));
        }
    }

    //function to Calculate Salary Statistics
    public void calculateSalaryStatistics() {
        //set total to 0 as a start
        totalSalaries = 0;

        //assume largest and smallest are the first element on the list
        highestSalary = employeeSalaries.get(0);
        lowestSalary = employeeSalaries.get(0);

        //loop through numbers to update above variables
        for (int i = 0; i < employeeSalaries.size(); i++) {
            totalSalaries += employeeSalaries.get(i);
            if (employeeSalaries.get(i) > highestSalary) highestSalary = employeeSalaries.get(i);
            else if (employeeSalaries.get(i) < lowestSalary) lowestSalary = employeeSalaries.get(i);
        }

        //display header and information
        System.out.println("Total number of employees: " + employeeSalaries.size());
        System.out.println("Total Salary paid: " + totalSalaries);
        System.out.println("Average Salary: " + ((double) totalSalaries / employeeSalaries.size()));
        System.out.println("Highest Salary: " + highestSalary);
        System.out.println("Lowest Salary: " + lowestSalary);
    }

    //function to get categorize salaries
    public void salaryCategoryAnalysis() {
        //set counts to 0
        above1000Count = 0;
        between500and1000Count = 0;
        below500Count = 0;

        //loop to update counts
        for (double salary : employeeSalaries) {
            //update counts
            if (salary > 1000) above1000Count++;
            else if (salary >= 500) between500and1000Count++;
            else below500Count++;
        }

        //display results
        System.out.println("Number of employees earning more than 1000: " + above1000Count);
        System.out.println("Number of employees earning between 500 and 1000: " + between500and1000Count);
        System.out.println("Number of employees earning less than 500: " + below500Count);
    }

    //function to search employee
    public void searchEmployee() {//ask user for input
        System.out.print("Enter employee ID: ");
        id = in.nextInt();

        //check if number exists
        index = employeeIds.indexOf(id);
        if (index != -1) {
            System.out.printf("Employee found ->\n%-8s %-10s %-10s %-9s\n", "Index", "ID", "Name", "Salary");
            System.out.printf("%-8s %-10d %-10s %-9.3f\n", index, employeeIds.get(index), employeeNames.get(index), employeeSalaries.get(index));
        } else {
            System.out.println("ID not found!");
        }
    }

    //function to update employee
    public void updateEmployee() {
        //ask user for input
        System.out.print("Enter employee index: ");
        index = in.nextInt();

        //check if user exists
        if (index < employeeSalaries.size() && index >= 0) {
            //ask for new salary
            System.out.print("Enter new salary: ");
            salary = in.nextDouble();
            employeeSalaries.set(index, salary);
            System.out.printf("Updated employee ->\n%-8s %-10s %-10s %-9s\n", "Index", "ID", "Name", "Salary");
            System.out.printf("%-8s %-10d %-10s %-9.3f\n", index, employeeIds.get(index), employeeNames.get(index), employeeSalaries.get(index));
        } else {
            System.out.println("Index out of range");
        }

    }

    //function to remove employee
    public void removeEmployee() {//ask user for input
        System.out.print("Enter employee index: ");
        index = in.nextInt();

        //check if employee exist
        if (index < employeeSalaries.size() && index >= 0) {
            employeeNames.remove(index);
            employeeIds.remove(index);
            employeeSalaries.remove(index);
            System.out.println("Employee has been removed\nUpdated list--->");
            displayEmployees();
        } else {
            System.out.println("Index out of range");
        }
    }

    //function to sort employees based on salary
    public void sortEmplyees(){
        //initialize arrays
        employeeNamesSorted=new ArrayList<String>(employeeNames);
        employeeSalariesSorted=new ArrayList<Double>(employeeSalaries);

        //loop to sort arrays
        for (int i=0;i<employeeNamesSorted.size();i++){
            for (int j=i;j<employeeNamesSorted.size();j++){
                //compare each two together
                if (employeeSalariesSorted.get(i)>employeeSalariesSorted.get(j)){
                    //swap salaries (low to high)
                    salary=employeeSalariesSorted.get(i);
                    employeeSalariesSorted.set(i,employeeSalariesSorted.get(j));
                    employeeSalariesSorted.set(j,salary);
                    //swap names
                    name=employeeNamesSorted.get(i);
                    employeeNamesSorted.set(i,employeeNamesSorted.get(j));
                    employeeNamesSorted.set(j,name);
                }
            }
        }

        //display results
        //low to high
        System.out.println(" lowest to highest-----");
        for (int i=0;i<employeeNamesSorted.size();i++){
            System.out.println((i+1)+". "+ employeeNamesSorted.get(i)+" - "+ employeeSalariesSorted.get(i));
        }
        //high to low
        System.out.println("\nhighest to lowest-----");
        for (int i=employeeNamesSorted.size()-1;i>=0;i--){
            System.out.println((employeeNamesSorted.size()-i)+". "+ employeeNamesSorted.get(i)+" - "+ employeeSalariesSorted.get(i));
        }
    }

    // function for Employee Salary Bonus Calculation
    public void bonusCalculation(){
        System.out.printf("%-8s %-10s %-10s %-10s %-10s\n","Index","Name", "Salary", "Bonus", "Final Salary");
        for (int i = 0; i < employeeNames.size(); i++) {
            salary=employeeSalaries.get(i);

            //determine bonus based on salary
            if (salary>=1000) bonus=salary*1.10;
            else if (salary>=500) bonus=salary*1.05;
            else bonus=salary*1.02;

            //print employee info
            System.out.printf("%-8d %-10s %-10.3f %-10.3f %-10.3f\n", i, employeeNames.get(i), salary,bonus,(salary+bonus));

        }
    }
}
