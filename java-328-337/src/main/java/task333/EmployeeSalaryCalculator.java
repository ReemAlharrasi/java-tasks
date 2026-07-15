package task333;

public class EmployeeSalaryCalculator {
    void main() {
        //declare variables
        String employeeName = "Reem";
        float basicSalary = 800.0F;
        float bonus = 100F;
        float deduction = 5.0F;
        String status;

        //call functions
        float netSalary = calculateNetSalary(basicSalary, bonus, deduction);
        status = checkSalaryStatus(netSalary);
        displaySalaryDetails(employeeName, basicSalary, bonus, deduction, netSalary, status);


    }

    //function to calculate net salary
    public float calculateNetSalary(float salary, float bonus, float decuct) {
        return (salary + bonus - decuct);
    }

    //function to check salary range and status
    public String checkSalaryStatus(float netSalary) {
        if (netSalary < 500) return "Low Salary";
        else if (netSalary <= 1500) return "Medium Salary";
        else return "High  Salary";
    }

    //function to display all information
    public void displaySalaryDetails(String name, float salary, float bonus, float deduction, float netsalary, String salarystatus) {
        System.out.println("-----Employee Salary-----");
        System.out.println("Employee name: " + name);
        System.out.println("Basic salary: " + salary);
        System.out.println("Bonus amount: " + bonus);
        System.out.println("deduction amount: " + deduction);
        System.out.println("Salary classification: " + salarystatus);
    }
}
