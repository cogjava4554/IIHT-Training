package com.company.food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class signup {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "Insert into login(first_name,email,password) values(?,?,?) ";

    public static void signupUser() {
                signin si = new signin();
        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter first Name ");
                String firstName = sc.nextLine();
                System.out.println("Enter email ");
                String email = sc.nextLine();
                System.out.println("Enter password ");
                String password = sc.nextLine();

                ps.setString(1, firstName);
                ps.setString(2, email);
                ps.setString(3, password);

                ps.executeUpdate();
                System.out.println("Redirecting to sign in .please enter the details");
                si.signinUser();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
