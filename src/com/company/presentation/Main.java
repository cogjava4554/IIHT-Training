package com.company.presentation;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Tweet Application");
        System.out.println("1.Register \n2.login\n3.Forgot Password");
        int selection;
        String line = sc.nextLine();
        while(!isNumber(line)){
            System.out.println("Please enter a valid input");
            line = sc.nextLine();
        }
        selection = Integer.parseInt(line);
        while ( (selection > 4) || (selection < 0 )){
            System.out.println("Please enter a valid integer ");
            if(sc.hasNextInt()){
                selection = sc.nextInt();
            }
        }
        //Code to call methods from other class depending on choicex
        //code to register
        //code to login
        //code to forgot password
        System.out.println("User is logged in ");
        System.out.println("1.Post a Tweet\n2.View my tweets\n3.view all tweets\n4.View all Users\n5.Reset Password\n6.Logout");
        String line_user = sc.nextLine();
        while(!isNumber(line_user)){
            System.out.println("Please enter a valid input");
            line_user = sc.nextLine();
        }
        int user_choice = Integer.parseInt(line_user);
        while ( (user_choice > 7) || (user_choice < 0 )){
            System.out.println("Please enter a valid integer ");
            if(sc.hasNextInt()){
                user_choice = sc.nextInt();
            }
        }

        while(user_choice != 6){
            System.out.println("1.Post a Tweet\n2.View my tweets\n3.view all tweets\n4.View all Users\n5.Reset Password\n6.Logout");
            user_choice = sc.nextInt();
            int check = user_choice;
            switch (check){
                case 1 :
                    System.out.println("Post a Tweet");
                    break;
                case 2 :
                    System.out.println("View my tweets");
                    break;
                case 3 :
                    System.out.println("view all tweets");
                    break;
                case 4 :
                    System.out.println(".View all Users");
                    break;
                case 5 :
                    System.out.println(".Reset Password");
                    break;
                case 6 :
                    System.out.println("Logout");
                    break;
            }
        }
        System.out.println("Thank you");
    }

    static boolean isNumber(String s) {
        for(int i=0; i< s.length();i++)
            if (Character.isDigit(s.charAt(i)) == false)
                    return false;

         return true;
    }


}