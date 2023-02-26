package com.bridgelabz.jdbc;

import java.sql.*;


public class EmployeePayroll {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll";
        String username = "root";
        String password = "root";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement=con.createStatement();
//            statement.execute("create table employee(id int auto_increment,name varchar(30),\n" +
//                    "salary double,department varchar(30),Joining_Date date,\n" +
//                    "primary key(id))");
            statement.execute("insert into employee(name,salary,department,\n" +
                    "joining_date) values ('R',300000,\n" +
                    "'Analyst','2019-12-09'),('P',500000,\n" +
                    "'Developer','2018-09-06'),('S',600000,\n" +
                    "'ML Engineer','2017-11-08'),('Q',900000,\n" +
                    "'DevOps Engineer','2019-03-07') ");
            ResultSet resultSet =statement.executeQuery("select * from employee");
            while(resultSet.next()){
                System.out.println("id:"+resultSet.getInt("id"));
                System.out.println("name:"+resultSet.getString("name"));
                System.out.println("salary:"+resultSet.getDouble("salary"));
                System.out.println("department:"+resultSet.getString("department"));
                System.out.println("Joining_Date:"+resultSet.getDate("Joining_Date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}