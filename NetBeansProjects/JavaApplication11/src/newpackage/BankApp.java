import java.util.Scanner;

public class BankApp {

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
        if (amount > 0) {
            savings += amount;
            System.out.println("Success! Fully Deposited!");
            System.out.println("Amount Deposited: " + amount);
            System.out.println("New Balance: " + savings);
            System.out.println("Account Number: " + accNo);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdrawMoney(int amount) {
        Scanner input = new Scanner(System.in);

        if (amount > 0 && amount <= savings) {
            savings -= amount;
            System.out.println("Success! Fully Withdrawn!");
            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("New Balance: " + savings);
            System.out.println("Account Number: " + accNo);
        } else {
            System.out.println("Error! Insufficient Balance!");
        }
    }

    void showDetails() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Total Balance: " + savings);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of Accounts: ");
        int numAcc = input.nextInt();

        BankApp[] bnk = new BankApp[numAcc];

        for (int i = 0; i < numAcc; ++i) {
            bnk[i] = new BankApp();

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
                    System.out.println("Select User No.: ");
                    int us = input.nextInt();
                    bnk[us - 1].displayData();

                    System.out.println("Enter Amount to Deposit: ");
                    int amount = input.nextInt();
                    bnk[us - 1].depositMoney(amount);
                    break;

                case 2:
                    System.out.println("Select User No.: ");
                    int users = input.nextInt();
                    bnk[users - 1].displayData();

                    System.out.println("Enter Amount to Withdraw: ");
                    int amounts = input.nextInt();
                    bnk[users - 1].withdrawMoney(amounts);
                    break;

                case 3:
                    for (int i = 0; i < numAcc; ++i) {
                        bnk[i].showDetails();
                    }
                    break;

                default:
                    System.out.println("Invalid!");
            }

            while (true) {
                System.out.println("Do you want another transaction? (y/n): ");
                String trans = input.next();

                if (trans.equalsIgnoreCase("n")) {
                    System.exit(0);
                } else if (trans.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        } while (true);
    }
}
