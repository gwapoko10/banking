import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    String plate;
    String type;
    String make;
    String model;
    int year;
    double dailyRate;
    Customer bookedCustomer;

    Vehicle(String plate, String type, String make, String model, int year, double dailyRate) {
        this.plate = plate;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        
    }

    Vehicle(String newVehicleType, String newMake, String newModel, int newYear, double newDailyRate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Customer bookVehicle(Customer customer) { 
        return this.bookedCustomer = customer;
    }
    
}

class Customer {
    String name;
    String contactNumber;
    double rentalDuration;

    Customer(String name, String contactNumber, double rentalDuration) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.rentalDuration = rentalDuration;
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String response;

        ArrayList<Vehicle> availableVehicles = new ArrayList<>();
        availableVehicles.add(new Vehicle("ILY143", "Sedan", "Toyota", "Camry", 2023, 50.00));
        availableVehicles.add(new Vehicle("RB0897","SUV", "Honda", "Cr-V", 2023, 60.00));
        availableVehicles.add(new Vehicle("XXX888","Compact", "Ford", "Focus", 2023, 45.00));

        do{
            System.out.println("\n_________________________________");
            System.out.println("\nWelcome to the Car Rental System!"); 
            System.out.println("1. Check vehicle availability\n2. View available vehicles\n3. Book a vehicle\n" +
                "4. View booked vehicles\n5. Process payment\n6. Add a vehicle\n7. Exit");
            System.out.print("\n___________________________________");
            System.out.print("\nPlease enter your choice: ");
            int choice = scan.nextInt();
            
            switch (choice) {
            case 1:
                System.out.print("\nEnter the number of the vehicle to check: ");
                int selectedcheckVehicleIndex = scan.nextInt() - 1;
                
                System.out.println("\n__________________________________________________________________________");
                System.out.println("\n Vehicle Details");
                System.out.println("\tVehicle Type: " + availableVehicles.get(selectedcheckVehicleIndex).type);
                System.out.println("\tPlate Number: " + availableVehicles.get(selectedcheckVehicleIndex).plate);
                System.out.println("\tMake: " + availableVehicles.get(selectedcheckVehicleIndex).make);
                System.out.println("\tModel: " + availableVehicles.get(selectedcheckVehicleIndex).model);
                System.out.println("\tYear: " + availableVehicles.get(selectedcheckVehicleIndex).year);
                System.out.println("\tDaily Rate: $" + availableVehicles.get(selectedcheckVehicleIndex).dailyRate);
                System.out.println("\n__________________________________________________________________________");
                
                
                break;
                
            case 2:
                System.out.println("\n__________________________________________________________");
                System.out.println("\nAvailable Vehicles:");               
                for (int i = 0; i < availableVehicles.size(); i++) {
                    Vehicle availVehicle = availableVehicles.get(i);
                    System.out.println((i + 1) + " - " +  availVehicle.make + availVehicle.model + " (" + availVehicle.type + ")" + " "+ availVehicle.plate + " - $"+availVehicle.dailyRate + " per day" );
                }
                System.out.println("\n__________________________________________________________");
                break;
                
            case 3:
                System.out.println("\n__________________________________________");
                System.out.print("\nEnter the number of the vehicle to book: ");
                int selectedbookVehicleIndex = scan.nextInt() - 1;
                
                System.out.println("\nEnter Customer Details:");
                System.out.print("Customer Name: ");
                scan.nextLine(); 
                String customerName = scan.nextLine();
                System.out.print("Contact Number: ");
                String contactNumber = scan.nextLine();
                System.out.print("Rental Duration (in days): ");
                double rentalDuration = scan.nextInt();               
                System.out.println("Processing...");
                System.out.println("\n__________________________________________");
                Customer customer = new Customer(customerName, contactNumber, rentalDuration);
                availableVehicles.get(selectedbookVehicleIndex).bookVehicle(customer);
                
                break;
            
            case 4:
                System.out.println("\n__________________________________________");
                System.out.println("\nBooked Vehicles:");
                for (int i = 0; i < availableVehicles.size(); i++) {
                    Vehicle currentVehicle = availableVehicles.get(i);
                    if(currentVehicle.bookedCustomer != null) {
                        System.out.println((i + 1) + ". " + currentVehicle.make + " " + currentVehicle.model + " (" + currentVehicle.type + ")");
                        System.out.println("\tCustomer: " + currentVehicle.bookedCustomer.name);
                        System.out.println("\tContact Number: " + currentVehicle.bookedCustomer.contactNumber);
                        System.out.println("\tRental Duration: " + currentVehicle.bookedCustomer.rentalDuration + " days");
                        System.out.println("\nSucessfully Processed! ");
                        System.out.println("\n__________________________________");
                    }
                }
                
                        
                break;
                
            case 5:
                System.out.println("\n__________________________________________________");
                System.out.print("\nEnter the number of the vehicle to process payment: ");
                int selectedprocessVehicleIndex = scan.nextInt() - 1;
                Vehicle processVehicle = availableVehicles.get(selectedprocessVehicleIndex);
                double totalpayment = (processVehicle.dailyRate * processVehicle.bookedCustomer.rentalDuration);
                System.out.println("1. " + processVehicle.make + " " + processVehicle.model + " (" + processVehicle.type + ") - $" + processVehicle.dailyRate + " per day");
                System.out.println("\tCustomer: " + processVehicle.bookedCustomer.name);
                System.out.println("\tContact Number: " + processVehicle.bookedCustomer.contactNumber);
                System.out.println("\tRental Duration: " + processVehicle.bookedCustomer.rentalDuration + " days");
                System.out.println("\tPrice: "+ totalpayment);
                System.out.println("\nYour Payment Has Been Processed!");
                System.out.println("\n__________________________________________________");
                
                break;
                
            
            case 6:
                System.out.println("__________________________________________");
                System.out.println("\nAdd a Vehicle:");
                System.out.print("Enter Vehicle Type: ");
                String newVehicleType = scan.next();
                System.out.print("Enter Make: ");
                String newMake = scan.next();
                System.out.print("Enter Model: ");
                String newModel = scan.next();
                System.out.print("Enter Year: ");
                int newYear = scan.nextInt();
                System.out.print("Enter Daily Rate: $");
                double newDailyRate = scan.nextDouble();
                System.out.println("__________________________________________");
                Vehicle newVehicle = new Vehicle(newVehicleType, newMake, newModel, newYear, newDailyRate);
                availableVehicles.add(newVehicle);
                
                System.out.println("\nNew Vehicle Added:");
                System.out.println(newVehicle.make + " " + newVehicle.model + " (" + newVehicle.type + ") - $" + newVehicle.dailyRate + " per day");
                break;
                
            case 7:                
                System.out.println("Exiting Car Rental System. Thank you!");
                System.exit(0);
            break;

            default:
                System.out.println("Invalid choice. Exiting Car Rental System.");
                
            }
        
            
            System.out.print("\nMake another transaction? (y/n): ");
            response = scan.next();        
            
            while(!(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("N"))){
                System.out.print("Invalid response! Enter again: ");
                response = scan.next();
            }
            
        }while(!response.equalsIgnoreCase("N"));
        
    }
}