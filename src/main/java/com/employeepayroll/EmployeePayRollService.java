package com.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description create Class for Defining the Employee PayRoll Service
 *
 */
public class EmployeePayRollService {
    //variables
    private final List<EmployeePayRollData> employeePayRollList = new ArrayList<>();

    /**
     * @description create main Method for Printing the Welcome Message to Employee PaYRoll Service
     * param: Create an Employee PayRoll Service to Read and Write Employee PayRoll to a Console
     */
    public static void main(String[] args) {
        System.out.println("Welcome To Employee PayRoll Service Program");
        EmployeePayRollService employeePayRollService = new EmployeePayRollService();
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayuRollData();
    }

    /**
     * @description Create Method for Reading the Employee PayRoll Data From Console
     *
     */
    private void readEmployeePayRollData(Scanner consoleInputReader) {
        System.out.println("Enter The Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter The Employee Name: ");
        consoleInputReader.nextLine();
        String name = consoleInputReader.nextLine();
        System.out.println("Enter The Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayRollList.add(new EmployeePayRollData(id,name,salary));    //Adding Employee PaYRoll to ArrayList
    }

    /**
     * @description create Method for Writing the Employee PayRoll Data In Console
     *
     */
    private void writeEmployeePayuRollData() {
        System.out.println("\n Writing Employee PayRoll Roaster to Console\n " +employeePayRollList);
    }
}
