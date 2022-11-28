package com.company.food;

import java.util.*;
import java.sql.*;
public class update {
    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "update order c set c.order_amount=? where c.oid = ? " ;

    public void updateDetails(int amount,int orderId ){
        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                ps.setInt(1, amount);
                ps.setInt(2, orderId);

                int result = ps.executeUpdate();

                if(result == 0 ){
                    System.out.println("Records is not updated");
                }else{
                    System.out.println("Records is updated");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
