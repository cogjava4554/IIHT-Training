package com.company.food;

import java.sql.*;
import java.util.Scanner;
public class insert {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "Insert into order(oid,user_email,order_amount) values(?,?,?) ";

    public void insertDetails(int order, String user) {

        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                int eoid = order;
                String euser = user ;
                int eamount = 0;
                ps.setInt(1, eoid);
                ps.setString(2, euser);
                ps.setInt(3, eamount);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
