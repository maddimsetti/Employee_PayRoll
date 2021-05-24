package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @description create class for Defining  the Employee PayRoll  service Testing
 *
 */
public class EmployeePayRollServiceTest {
    /**
     * @description create Method for Testing the 3 Employees When Writing to Files should match the Employee Entries
     *
     */
    @Test
    public void given3EmployeeWhenWrittenToFilesShouldMatchEmployeeEntries() {
        EmployeePayRollData[] arrayOfEmployees = {
                new EmployeePayRollData(1,"Krishna",60000),
                new EmployeePayRollData(2,"SatyaNarayana",75000),
                new EmployeePayRollData(3,"Lakshmi",50000)
        };
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(Arrays.asList(arrayOfEmployees));
        employeePayRollService.writeEmployeePayuRollData(EmployeePayRollService.IOService.FILE_IO);
    }
}
