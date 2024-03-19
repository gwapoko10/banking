package obj;

import java.util.Scanner;

public class libApp {
   
    int isbn;
    String title;
    int author;
    String status;
    
   
    void insertRecord(int isn, String tle, int autr, String stat){
        isbn = isn;
        title = tle;
        author = autr;
        status = stat;
        
    }
   
    void displayRecord(){
        System.out.println("ISBN No: "+isbn);
        System.out.println("Title: "+title);
        System.out.println("Author1: "+author);
        System.out.println("Status: "+status);
       
    }
   
   
    void bookReturn(){
        System.out.println("Book Received!");
        System.out.println("Title: "+title);
        System.out.println("Returned By: "+author);
        status = "Returned";
     
        System.out.println("-------------------------------------");
        displayRecord();

    }
   
   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter no. of book: ");
        int book = sc.nextInt();
       
        libApp[] rec = new libApp[book];
       
        for(int x = 0; x < book; x++){
            rec[x] = new libApp();
           
            System.out.print("ISBN: ");
            int isbn = sc.nextInt();
            System.out.print("Title: ");
            String title = sc.next();
            System.out.print("Author: ");
            int author = sc.nextInt();
            System.out.print("Status (Borrowed/Available): ");
            String stat = sc.next();
        
           
            rec[x].insertBook(isbn, title, author, stat);
        }
       
        for(int x = 0; x < book; x++){
           
            System.out.println("----------------------------------------");
            rec[x].displayRecord();        
        }
       
       
        System.out.println("Actions");
        System.out.println("1. Borrow");
        System.out.println("2. Return");
        System.out.println("3. Check");
      
        System.out.print("Enter Actions: ");
        int act = sc.nextInt();
       
        if(act == 1){
           
            System.out.println("Borrowers:");
            for(int y = 0; y < book; y++){
                System.out.println((y+1)+". User "+(y+1));
            }
           
            System.out.print("Enter User No.: ");
            int us = sc.nextInt();
           
            rec[us-1].bookReturn();
       
        }else if(act == 2){
        for(int i=0; i < book; i++){
        rec[book].displayRecord();
        }
        
        }
       
       
    }

    private void insertBook(int bn, String title, int author, String stat) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}