package com.employeepayroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @description Create Class for Employee PayRoll DataBase service
 *
 */
public class EmployeePayRollDBService {
    /**
     * @description Create Method for get connection with Database sql
     *
     */
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "admin";
        Connection con;
        System.out.println("Connecting to database:" +jdbcURL);
        con = DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Connection is Successful!!!!!" +con);
        return con;
    }

    /**
     * @description Create Method for Reading the Employee PayRoll Data From DataBase
     *
     */
    public List<EmployeePayRollData> readData() {
        String sql = "SELECT * FROM employee_payroll";
        List<EmployeePayRollData> employeePayRollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate startDate = result.getDate("start").toLocalDate();
                employeePayRollList.add(new EmployeePayRollData(id,name,salary,startDate));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeePayRollList;
    }
}
