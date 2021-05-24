package com.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @description create Class for Defining the EmployeePayRollFiles Using IOService
 *
 */
public class EmployeePayRollFileIOService {
    //Variable
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";

    /**
     * @description create Method for Writing the Data From the List Using IOService to Create Files Written in Files
     *
     */
    public void writeData(List<EmployeePayRollData> employeePayRollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayRollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @description create Method for Printing the Data From the List, Using IOService to Create Files Printing in Files
     *
     */
    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @description create Method for Counting the DataEntries in the List, and Return the Entries to IOService
     *
     */
    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * @description create Method for Reading  the Data From the List, Using IOService to read Files in console
     *
     */
    public List<EmployeePayRollData> readData() {
        List<EmployeePayRollData> employeePayRollList = new ArrayList<>();
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayRollList;
    }
}
