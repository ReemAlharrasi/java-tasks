package task362;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeSalaryManager {
    //declare variables
    HashMap<Integer, Double> employeeSalaries = new HashMap<Integer, Double>();
    Scanner in = new Scanner(System.in);

    int size, id, choice;
    double salary;

    double highestSalary, lowestSalary, totalSalaries, averageSalary;
    int highestEmployee, lowestEmployee;

    void main() {
        //prompt user to enter number of employees
        System.out.print("Enter the number of Employees: ");
        size = in.nextInt();

        //validate input
        if (size <= 0) {
            System.out.println("Invalid number of employees.");
        } else {

            //read employee records
            System.out.println("Input -----");
            for (int i = 0; i < size; i++) {

                //read employee ID
                System.out.print(i + " - Enter Employee ID: ");
                id = in.nextInt();

                //check duplicate employee ID
                if (employeeSalaries.containsKey(id)) {
                    System.out.println("Employee ID already exists. Record not added.");
                } else {
                    //read salary
                    System.out.print("    Enter Salary: ");
                    salary = in.nextDouble();

                    //store employee record
                    employeeSalaries.put(id, salary);
                }
            }

            //menu
            choice = 0;
            while (choice != 7) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee");
                System.out.println("3. Update Salary");
                System.out.println("4. Remove Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Display Salary Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {

                    //add employee
                    case 1:
                        addEmployee();
                        break;

                    //search employee
                    case 2:
                        searchEmployee();
                        break;

                    //update salary
                    case 3:
                        updateSalary();
                        break;

                    //remove employee
                    case 4:
                        removeEmployee();
                        break;

                    //display all employees
                    case 5:
                        displayEmployees();
                        break;

                    //display salary statistics
                    case 6:
                        displayStatistics();
                        break;

                    //exit
                    case 7:
                        System.out.println("GoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }

            }
            //display final summary
            System.out.println("\nFinal Employee Summary -----");
            displayEmployees();
            displayStatistics();
        }

        //close scanner
        in.close();
    }

    public void addEmployee() {
        //ask for employee ID
        System.out.print("Enter Employee ID: ");
        id = in.nextInt();

        //check duplicate employee ID
        if (employeeSalaries.containsKey(id)) {
            System.out.println("Employee ID already exists.");
        } else {

            //read salary
            System.out.print("Enter Salary: ");
            salary = in.nextDouble();

            //store employee
            employeeSalaries.put(id, salary);
            System.out.println("Employee added successfully.");
        }
    }

    public void searchEmployee() {
        //ask for employee ID
        System.out.print("Enter Employee ID: ");
        id = in.nextInt();

        //check if employee exists
        if (employeeSalaries.containsKey(id)) {
            System.out.println("Salary: " + employeeSalaries.get(id));
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateSalary() {
        //ask for employee ID
        System.out.print("Enter Employee ID: ");
        id = in.nextInt();

        //check if employee exists
        if (employeeSalaries.containsKey(id)) {

            //read new salary
            System.out.print("Enter New Salary: ");
            salary = in.nextDouble();

            //update salary
            employeeSalaries.replace(id, salary);
            System.out.println("Salary updated successfully.");

        } else {
            System.out.println("Employee not found.");
        }
    }

    public void removeEmployee() {
        //ask for employee ID
        System.out.print("Enter Employee ID: ");
        id = in.nextInt();

        //check if employee exists
        if (employeeSalaries.containsKey(id)) {

            //remove employee
            employeeSalaries.remove(id);
            System.out.println("Employee removed successfully.");

        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        //display employees in ascending order
        ArrayList<Integer> ids = new ArrayList<Integer>(employeeSalaries.keySet());
        Collections.sort(ids);

        System.out.println("\nAll Employees -----");
        System.out.printf("%-18s | %-18s\n", "Employee ID", "Salary");
        System.out.println("_".repeat(40));

        for (int employeeId : ids) {
            System.out.printf("%-18d | %-18.2f\n", employeeId, employeeSalaries.get(employeeId));
        }
    }

    public void displayStatistics() {
        //set starting values
        highestSalary = -1;
        lowestSalary = Double.MAX_VALUE;
        totalSalaries = 0;
        highestEmployee = 0;
        lowestEmployee = 0;

        //calculate statistics
        for (int employeeId : employeeSalaries.keySet()) {

            salary = employeeSalaries.get(employeeId);

            totalSalaries += salary;

            if (salary > highestSalary) {
                highestSalary = salary;
                highestEmployee = employeeId;
            }

            if (salary < lowestSalary) {
                lowestSalary = salary;
                lowestEmployee = employeeId;
            }
        }

        averageSalary = totalSalaries / employeeSalaries.size();

        //display statistics
        System.out.println("\nSalary Statistics -----");
        System.out.println("Total Employees: " + employeeSalaries.size());
        System.out.println("Highest Salary: " + highestSalary + " (Employee ID: " + highestEmployee + ")");
        System.out.println("Lowest Salary: " + lowestSalary + " (Employee ID: " + lowestEmployee + ")");
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Total Payroll: " + totalSalaries);
    }
}