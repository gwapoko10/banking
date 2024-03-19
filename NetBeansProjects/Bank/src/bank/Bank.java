
import java.util.Scanner;

public class Bank {

    int id, accNo, savings;
    String name, stat;

    void insertData(int ids, String user, int accn, int save, String userStats) {

        id = ids;
        name = user;
        accNo = accn;
        savings = save;
        stat = userStats;

    }

    void displayData() {

        System.out.println("User ID: " + id);
        System.out.println("User Name: " + name);
        System.out.println("Account No.: " + accNo);
        System.out.println("Savings: " + savings);
        System.out.println("Status: " + stat);

    }

    void depositMoney(int amount) {
        savings += amount;
        System.out.println("Success!, Fully Deposited!");
        System.out.println("Amount Deposited: " + amount);
        System.out.println("New Balance: " + savings);
        System.out.println("Account Number: " + accNo);
    }

    void withdrawMoney(int amount) {

        Scanner input = new Scanner(System.in);

        savings -= amount;

        System.out.println("Balance: " + savings);

        while (savings < amount) {
            for (int i = 3; i >= 1; --i) {
                System.out.println("You have " + (i) + "Chances left");
                System.out.println("Error!, insufficient Balance!");
                amount = input.nextInt();

                if (i == 1) {
                    System.exit(0);
                }
            }

            System.out.println("Successfuly Withdrawed!");

        }

        System.out.println("Success!, Fully Withdrawed!");
        System.out.println("Amount Deposited: " + amount);
        System.out.println("New Balance: " + savings);
        System.out.println("Account Number: " + accNo);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of Accounts: ");
        int numAcc = input.nextInt();

        Bank[] bnk = new Bank[numAcc];

        for (int i = 0; i < numAcc; ++i) {

            bnk[i] = new Bank();

            System.out.println("Enter User ID: ");
            int id = input.nextInt();
            System.out.println("Enter User Name: ");
            String name = input.next();
            System.out.println("Enter User Account: ");
            int acc = input.nextInt();
            System.out.println("Enter User Savings: ");
            int saving = input.nextInt();
            System.out.println("Enter User Status: ");
            String stat = input.next();

            bnk[i].insertData(id, name, acc, saving, stat);

        }

        for (int i = 0; i < numAcc; ++i) {
            bnk[i].displayData();
        }

        do {
            System.out.println("Actions: ");
            System.out.println("1.) Deposit");
            System.out.println("2.) Withdraw");
            System.out.println("3.) Check Balance");

            System.out.println("Enter action selected: ");
            int act = input.nextInt();

            switch (act) {

                case 1:

                    for (int j = 0; j < numAcc; ++j) {
                        System.out.println("User List: ");
                        System.out.println((j + 1) + " User " + (j + 1));
                    }

                    System.out.println("Select User No.: ");
                    int us = input.nextInt();

                    System.out.println("Selected User: ");
                    bnk[us - 1].displayData();

                    System.out.println("Enter Amount to Deposit: ");
                    int amount = input.nextInt();

                    while (amount > (10000 * 5)) {
                        System.out.println("Exceed!, Try Again: ");
                        amount = input.nextInt();
                    }

                    bnk[us - 1].depositMoney(amount);

                    break;
                case 2:

                    for (int j = 0; j < numAcc; ++j) {
                        System.out.println("User List: ");
                        System.out.println((j + 1) + " User " + (j + 1));
                    }

                    System.out.println("Select User No.: ");
                    int users = input.nextInt();

                    System.out.println("Selected User: ");
                    bnk[users - 1].displayData();

                    System.out.println("Enter Amount to Withdraw: ");
                    int amounts = input.nextInt();
                    
                    
                    
                    while (amounts > (1000 * 10)) {
                        System.out.println("Exceed!, Try Again: ");
                        amounts = input.nextInt();
                    }

                    bnk[users - 1].withdrawMoney(amounts);

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid!");

            }

            System.out.println("Do you want another transaction?: ");
            String trans = input.next();

            if (trans.equalsIgnoreCase("n")) {
                break;
            }

        } while (true);

    }

}
