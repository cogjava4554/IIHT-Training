package com.company.food;

import java.sql.*;
public class retrive {

    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "select * from food_delivery";
    static final String Query1 = "select oid from arpit.order Order by oid desc limit 1";


    public void getDetails() {
        try{
            Connection conn = DriverManager.getConnection(DB_url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query); {

                while(rs.next()){

                    System.out.println(" ID = " + rs.getInt("id"));
                    System.out.println(" Item Name = " + rs.getString("Item_name"));
                    System.out.println(" Item Amount = " + rs.getInt("Item_amount"));
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int getLatestOrder(){
        int oid =0;//implement this
        try{
            Connection conn = DriverManager.getConnection(DB_url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query1); {
                while(rs.next()){
                    System.out.println("Order ID = " + rs.getInt("oid"));
                    oid = rs.getInt("oid");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return oid;
    }

    public int getOrderAmount(int order){
        String Query2 = "select order_amount from food_delivery where oid =" + order;
        int order_value =0;
        try{
            Connection conn = DriverManager.getConnection(DB_url,user,pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query2); {
                while(rs.next()){
                    System.out.println("Order ID = " + rs.getInt("order_amount"));
                    order_value = rs.getInt("order_amount");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return order_value;
    }
}

