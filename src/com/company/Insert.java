package com.company;

import java.sql.*;
import java.util.Scanner;
public class Insert {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "Insert into customers(id,name,age,address,salary) values(?,?,?,?,?) ";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter employee id ");
                int eid = sc.nextInt();
                System.out.println("Enter customer name ");
                String ename = sc.next();
                System.out.println("Enter customer age ");
                int eage = sc.nextInt();
                System.out.println("Enter customer address ");
                String eaddress = sc.next();
                System.out.println("Enter customer Salary");
                int esalary = sc.nextInt();
                ps.setInt(1, eid);
                ps.setString(2, ename);
                ps.setInt(3, eage);
                ps.setString(4, eaddress);
                ps.setInt(5, esalary);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
