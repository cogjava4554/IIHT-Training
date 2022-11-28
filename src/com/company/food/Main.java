package com.company.food;

import java.util.Scanner;

public class Main {
    public static String loggedInUser = "";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        signup sp = new signup();
        signin si = new signin();
        retrive rv = new retrive();
        insert in = new insert();
        delete dl = new delete();
        update up = new update();

        //logic to call signup and signin for user .
        System.out.println("Welcome to Food Delivery App");
        System.out.println("Choose one of the below option ");
        System.out.println("1. Signup (For new User) ");
        System.out.println("2. Signin (For Existing User) ");
        int choice = sc.nextInt();
        while ( choice > 2 || choice < 1 ) {
            System.out.println("Invalid option selected Please enter the valid choice");
            choice = sc.nextInt();
        }
        if(choice == 1){
            sp.signupUser();
        }else {
            si.signinUser();
        }

        System.out.println("Please select food Items that needs to be added in your order ");
        rv.getDetails();
        int orderId = rv.getLatestOrder() + 1;

        System.out.println("Enter the food item needs to add or 0 to close the order ");
        int selection = sc.nextInt();
        int order_amount = 0;
        in.insertDetails(orderId,loggedInUser); // logic to update user and oid
        while (selection < 5 || selection >= 0){
            switch (selection){
                case 0 :
                    System.out.println("clear cart");
                    order_amount = 0;
                    up.updateDetails(order_amount,orderId);
                    break;
                case 1 :
                    System.out.println("omelette is been added to your order ");
                    order_amount = order_amount + 60;
                    up.updateDetails(order_amount,orderId);
                    break;
                case 2 :
                    System.out.println("boiled egg is been added to your order ");
                    order_amount = order_amount + 10;
                    up.updateDetails(order_amount,orderId);
                    break;
                case 3 :
                    System.out.println("Benzo is been added to your order ");
                    order_amount = order_amount + 70;
                    up.updateDetails(order_amount,orderId);
                    break;
                case 4 :
                    System.out.println("EggRoll is been added to your order ");
                    order_amount = order_amount + 70;
                    up.updateDetails(order_amount,orderId);
                    break;
            }
            System.out.println("1.Add omelette\n2.Add boiled egg\n 3.Add Benzo \n 4.Add EggRoll \n ");
            selection = sc.nextInt();
            order_amount = rv.getOrderAmount(orderId);
        }
        System.out.println("Your order is placed with details");
        rv.getDetails();
    }
}
