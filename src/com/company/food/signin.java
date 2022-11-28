package com.company.food;

import java.sql.*;
import java.util.Scanner;

public class signin {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "select * from login where email=? and password = ?;";
    static Main mn = new Main();
    public static void signinUser() {
        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter email ");
                String email = sc.nextLine();
                System.out.println("Enter password ");
                String password = sc.nextLine();

                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    System.out.println("login successful");
                    mn.loggedInUser = email;
                }else {
                    System.out.println("login fail");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
