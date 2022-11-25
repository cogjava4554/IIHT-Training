package com.company;

import java.sql.*;
public class Retrive {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "select * from customers";

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(DB_url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query); {

                System.out.println("Connection created" + rs );
                while(rs.next()){

                    System.out.println(" ID = " + rs.getInt("id"));
                    System.out.println(" Name = " + rs.getString("name"));
                    System.out.println(" age = " + rs.getString("age"));
                    System.out.println(" address = " + rs.getString("address"));
                    System.out.println(" salary = " + rs.getString("salary"));
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

