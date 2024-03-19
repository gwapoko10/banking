package Ompad1;

import java.util.Scanner;

public class Ompad1 {

    private int order_id;
    private String customer_name;
    private int customer_age;
    private String customer_address;
    private String[] order_items;
    private int item;
    private static int top = 0; 

    void insertOrder(int id, String name, int age, String address, String[] items, int item) {
        this.order_id = id;
        this.customer_name = name;
        this.customer_age = age;
        this.customer_address = address;
        this.order_items = items;
        this.item = item;
    }

    void displayOrder() {
        System.out.println("\n====================================================");
        System.out.println("Order ID: " + this.order_id);
        System.out.println("Customer Name: " + this.customer_name);
        System.out.println("Customer Age: " + this.customer_age);
        System.out.println("Enter Customer Address: " + this.customer_address);
        for (int x = 0; x < this.item; x++) {
            System.out.println("Order " + (x + 1) + " : " + this.order_items[x]);
        }
        System.out.println("====================================================\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum of the stack: ");
        int size = sc.nextInt();
        
        while(!(size <=1 && size >=10)){
            System.out.print("Invalid MAX 10, Enter Again: ");
            size = sc.nextInt();
        }

        Ompad1[] order = new Ompad1[size];
        String[] items = new String[5];
        char choice;

        do {
            System.out.println("Action to perform:");
            System.out.println("\n--------------------------------------------------");
            System.out.println("1. Add Order");
            System.out.println("2. Display Orders");
            System.out.println("3. Remove Order");
            System.out.println("4. Exit");
            System.out.println("--------------------------------------------------\n");

            System.out.print("\nEnter Action: ");
            int action = sc.nextInt();
            
            while(!(action <=1 && action >=4)){
                System.out.print("Invalid Action, Enter Again: ");
                action = sc.nextInt();
            }
            
            switch (action) {
                case 1:
                    if (top < size) { 
                        System.out.print("\nEnter Order ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Customer name: ");
                        String name = sc.next();
                        System.out.print("Enter Customer age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter Customer address: ");
                        String address = sc.next();
                        System.out.print("Enter how many items: ");
                        int item = sc.nextInt();

                        while (!(item < 5)) {
                            System.out.print("Invalid!!, Enter Again: ");
                            item = sc.nextInt();
                        }

                        order[top] = new Ompad1();
                        for (int j = 0; j < item; j++) {
                            System.out.print("Enter Item " + (j + 1) + " : ");
                            items[j] = sc.next();
                        }
                        order[top].insertOrder(id, name, age, address, items, item);
                        order[top].displayOrder();
                        top++; 
                    } else {
                        System.out.println("The stack is full. Cannot add more orders.");
                    }
                    break;
                case 2:
                    if(top > 0){
                    
                        for(int i = 0; i < top; i++){
                            order[i].displayOrder();
                        }
                    }else{
                        System.out.println("The stack is empty. Cannot display orders.");
                    }
                    
                    
                    break;
                case 3:
                if (top > 0) {
                    
                    for(int i=0; i < top ; i++){
                        System.out.println((i+1)+". Order : "+ order[i].order_id);
                    }
                    
                    System.out.print("Enter Order ID to remove: ");
                    int orderIdToRemove = sc.nextInt();

                    boolean found = false;
                    for (int i = 0; i < top; i++) {
                        if (order[i].order_id == orderIdToRemove) {
                            found = true;
                            // Shift orders up to overwrite the removed order
                            for (int j = i; j < top - 1; j++) {
                                order[j] = order[j + 1];
                            }
                            top--; // Decrement the top pointer to reflect removal
                            System.out.println("Order removed successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Order ID not found!");
                    }
                } else {
                    System.out.println("The stack is empty. Cannot remove orders.");
                }
                    break;
                    
                case 4:
                    
                    break;
                
            }

            System.out.print("\nDo you want to enter again (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');
    }
}
