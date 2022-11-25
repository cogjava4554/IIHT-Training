package com.company;


import java.util.*;
import java.sql.*;
public class Delete {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "delete from customers where id = ? ";

    public static void main(String[] args){
        try{
            Connection conn = DriverManager.getConnection(DB_url,user,pass);
            PreparedStatement st = conn.prepareStatement(Query);
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Customer ID ");
                int cid = sc.nextInt();
                st.setInt(1,cid);
                System.out.println(st);
                int rs = st.executeUpdate();
                System.out.println(rs);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
