package com.company;

import java.util.*;
import java.sql.*;
public class Update {
    static final String DB_url= "jdbc:mysql://localhost:3306/arpit";
    static final String user = "root";
    static final String pass = "pass@word1";
    static final String Query = "update customers c set c.id = ?,c.name = ?,c.age =?,c.address = ? ,c.salary =? where c.id = ? " ;

    public static void main(String[] args){
        try {
            Connection conn = DriverManager.getConnection(DB_url, user, pass);
            PreparedStatement ps = conn.prepareStatement(Query);
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter customer id whose value needs to be changed ");
                int oid = sc.nextInt();
                System.out.println("Enter customer id ");
                int nid = sc.nextInt();
                System.out.println("Enter customer name");
                String ename = sc.next();
                System.out.println("Enter customer age ");
                int eage = sc.nextInt();
                System.out.println("Enter customer address ");
                String eaddress = sc.next();
                System.out.println("Enter customer Salary");
                int esalary = sc.nextInt();
                ps.setInt(1, nid);
                ps.setString(2, ename);
                ps.setInt(3, eage);
                ps.setString(4, eaddress);
                ps.setInt(5, esalary);
                ps.setInt(6,oid);
                System.out.println(ps);
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
