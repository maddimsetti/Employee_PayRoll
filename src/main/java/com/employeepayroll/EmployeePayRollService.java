package com.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description create Class for Defining the Employee PayRoll Service
 *
 */
public class EmployeePayRollService {
    public enum IOService {
        CONSOLE_IO,FILE_IO,DB_IO,REST_IO
    }
    //variables
    private static List<EmployeePayRollData> employeePayRollList;

    public EmployeePayRollService(List<EmployeePayRollData> employeePayRollList) {
        this.employeePayRollList = employeePayRollList;
    }

    public EmployeePayRollService () { }

    /**
     * @description create main Method for Printing the Welcome Message to Employee PaYRoll Service
     * param: Create an Employee PayRoll Service to Read and Write Employee PayRoll to a Console
     */
    public static void main(String[] args) {
        System.out.println("Welcome To Employee PayRoll Service Program");
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayuRollData(IOService.CONSOLE_IO);
    }

    /**
     * @description Create Method for Reading the Employee PayRoll Data From Console
     *
     */
    public void readEmployeePayRollData(Scanner consoleInputReader) {
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
    public void writeEmployeePayuRollData(EmployeePayRollService.IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writing Employee PayRoll Roaster to Console\n " +employeePayRollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayRollFileIOService().writeData(employeePayRollList);
    }

    /**
     * @description create Method for Printing the Data of  the Employee PayRoll Data In Console
     *
     */
    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            new EmployeePayRollFileIOService().printData();
    }

    /**
     * @description create Method for Counting the Entries of  the Employee PayRoll Data In Console
     *
     */
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            return new EmployeePayRollFileIOService().countEntries();
        }
        return 0;
    }

    /**
     * @description create Method for Reading the Data From the List, To Read Files in console
     *
     */
    public List<EmployeePayRollData> readEmployeePayRollData (IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayRollList = new EmployeePayRollFileIOService().readData();
        return employeePayRollList;
    }

}
