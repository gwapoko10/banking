import java.util.Scanner;

public class Ompad1 {

    private int order_id;
    private String customer_name;
    private int customer_age;
    private String customer_address;
    private String[] order_items;
    private int item;
    private static int top = 0; // Top variable to track the position in the array

    void insertOrder(int id, String name, int age, String address, String[] items, int item) {
        this.order_id = id;
        this.customer_name = name;
        this.customer_age = age;
        this.customer_address = address;
        this.order_items = items;
        this.item = item;
    }

    void displayOrder() {
        System.out.println("Order ID: " + this.order_id);
        System.out.println("Customer Name: " + this.customer_name);
        System.out.println("Customer Age: " + this.customer_age);
        System.out.println("Enter Customer Address: " + this.customer_address);
        for (int x = 0; x < this.item; x++) {
            System.out.println("Order " + (x + 1) + " : " + this.order_items[x]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum of the stack: ");
        int size = sc.nextInt();

        Ompad1[] order = new Ompad1[size];
        String[] items = new String[5];
        char choice;

        do {
            System.out.println("Action to perform:");
            System.out.println("\n--------------------------------------------------");
            System.out.println("1. Add Order");
            System.out.println("2. Display Orders");
            System.out.println("3. Process Order");
            System.out.println("4. Remove Order");
            System.out.println("5. Exit");
            System.out.println("\n--------------------------------------------------");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    if (top < size) { // Check if the stack is not full
                        System.out.print("Enter Order ID: ");
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
                        top++; // Increment top after successfully adding an order
                    } else {
                        System.out.println("The stack is full. Cannot add more orders.");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

            System.out.print("Do you want to enter again (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');
    }
}
