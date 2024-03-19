
package bankapp;

import java.util.Scanner;

Public class Bankapp {
    
    int acc_no;
    String name;
    double savings;
   
    void insertAccount(int a_n, String nm, double svs){
        acc_no = a_n;
        name = nm;
        savings = svs;
    }
   
    void displayAccount(){
        System.out.println("Account No: "+acc_no);
        System.out.println("Name: "+name);
        System.out.println("Savings: "+savings);
    }
   
    void checkBalance(){
        System.out.println("Total Savings: "+savings);
    }
   
    void accDeposit(double amount){
        savings += amount;
        System.out.println("Sucessfully Deposited: "+amount);
        checkBalance();
        displayAccount();
    }
   
   
    void accWithdraw(double amount){
        Scanner sc = new Scanner(System.in);
        
        double withdrawalLimit = 10000;
        
        while(savings < amount || amount >= withdrawalLimit){
            if(savings < amount){
            System.out.println("Insufficient Balance!");
            
            }else{
            System.out.print("Withdrawal amount exceeds the limit of transaction: ");
            }
            System.out.println("Enter again:");
            amount = sc.nextDouble();
        }
        savings = savings - amount;
        System.out.println("Sucess!");
        displayAccount();
   
    }
   
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter no. of Users: ");
        int num = sc.nextInt();
       
        Bankapp[] user = new Bankapp[num];
       
        for(int x = 0; x < num; x++){
            user[x] = new Bankapp();
                System.out.println("Enter Details for User "+(x+1));
                System.out.print("Enter Account No.: ");
                int accno = sc.nextInt();
                System.out.print("Entert Account Name: ");
                String nm = sc.next();
                System.out.print("Enter total Savings: ");
                double sv = sc.nextDouble();
            user[x].insertAccount(accno, nm, sv);
        }
       
        for(int x = 0; x < num; x++){
            System.out.println("-------------------------------------------");
            user[x].displayAccount();
           
        }
       
       
        System.out.println("Actions:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Checking");
       
        System.out.println("Select Action: ");
        int act = sc.nextInt();
       
        switch(act){
            case 1:
           
                for(int y = 0; y < num; y++){
                    System.out.println((y+1) +". User "+(y+1));
                }
               
                System.out.println("Enter user no.: ");
                int us = sc.nextInt();
                System.out.println("Selected User: "+us);
                System.out.println("Enter Amount to Deposit");
                int amt = sc.nextInt();
                user[us-1].accDeposit(amt);
            break;
            case 2:
               
                for(int y = 0; y < num; y++){
                    System.out.println((y+1) +". User "+(y+1));
                }
               
                System.out.println("Enter user no.: ");
                int us1 = sc.nextInt();
                System.out.println("Selected User: "+us1);
                System.out.println("Enter Amount to Withdraw");
                int amt1 = sc.nextInt();
                user[us1-1].accWithdraw(amt1);
               
            break;
            
            case 3:
                
                
                for(int y = 0; y < num; y++){
                    System.out.println((y+1) +". User "+(y+1));
                }
               
                System.out.println("Enter user no.: ");
                int us2 = sc.nextInt();
                System.out.println("Selected User: "+us2);
                
                user[us2-1].checkBalance();
                break;
}
   

    }
    
}


    
   