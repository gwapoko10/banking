package obj;

import java.util.Scanner;

public class libApp {
   
    int isbn;
    String title;
    int user_id;
    String name;
    String status;
    int quantity;
   
    void insertRecord(int isn, String tle, int user, String nm, String stat, int qty){
        isbn = isn;
        title = tle;
        user_id = user;
        name = nm;
        status = stat;
        quantity = qty;
    }
   
    void displayRecord(){
        System.out.println("ISBN No: "+isbn);
        System.out.println("Title: "+title);
        System.out.println("User ID: "+user_id);
        System.out.println("Name: "+name);
        System.out.println("Status: "+status);
        System.out.println("Availability: "+quantity);
    }
   
   
    void bookReturn(){
        System.out.println("Book Received!");
        System.out.println("Title: "+title);
        System.out.println("Returned By: "+user_id);
        status = "Returned";
        quantity += 1;
        System.out.println("Updated Availabity: "+quantity);
       
        System.out.println("-------------------------------------");
        displayRecord();

    }
   
   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter no. of records: ");
        int record = sc.nextInt();
       
        libApp[] rec = new libApp[record];
       
        for(int x = 0; x < record; x++){
            rec[x] = new libApp();
           
            System.out.print("Enter isbn: ");
            int isbn = sc.nextInt();
            System.out.print("Enter Title: ");
            String title = sc.next();
            System.out.print("Enter User ID: ");
            int user_id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Status: ");
            String stat = sc.next();
            System.out.print("Enter Availability: ");
            int quantity = sc.nextInt();
           
            rec[x].insertRecord(isbn, title, user_id, name, stat, quantity);
        }
       
        for(int x = 0; x < record; x++){
           
            System.out.println("----------------------------------------");
            rec[x].displayRecord();        
        }
       
       
        System.out.println("Actions");
        System.out.println("1. Return");
        System.out.println("2. Check Status");
        System.out.println("3. Borrow");
       
        System.out.println("Enter Actions: ");
        int act = sc.nextInt();
       
        if(act == 1){
           
            System.out.println("Borrowers:");
            for(int y = 0; y < record; y++){
                System.out.println((y+1)+". User "+(y+1));
            }
           
            System.out.println("Enter User No.: ");
            int us = sc.nextInt();
           
            rec[us-1].bookReturn();
       
        }
       
       
    }
   
}