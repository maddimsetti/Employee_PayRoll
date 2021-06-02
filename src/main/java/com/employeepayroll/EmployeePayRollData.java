package com.employeepayroll;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @description create Class for Defining the Employee PayRoll Data
 *
 */
public class EmployeePayRollData {
    //Variables
    public int id;
    public String name;
    public double salary;
    public LocalDate startDate;

    /**
     * @description Create Constructor for Initializing the Variables
     *
     */
    public EmployeePayRollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    //Constructor for defining variables
    public EmployeePayRollData(int id, String name, double salary, LocalDate statDate) {
        this(id,name,salary);
        this.startDate = statDate;
    }

    //Printing the Result OverRide
    @Override
    public String toString () {
        return "Id = " +id+ " , Name = " +name+ " , salary = " +salary;
    }

    //equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayRollData that = (EmployeePayRollData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate);
    }
}
