package com.employeepayroll;

/**
 * @description create Class for Defining the Employee PayRoll Data
 *
 */
public class EmployeePayRollData {
    //Variables
    public int id;
    public String name;
    public double salary;

    /**
     * @description Create Constructor for Initializing the Variables
     *
     */
    public EmployeePayRollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //Printing the Result OverRide
    @Override
    public String toString () {
        return "Id = " +id+ "\n Name = " +name+ "\n salary = " +salary;
    }
}
