import java.util.ArrayList;
import java.util.Scanner;

class Adopter {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String contactDetails;

    public Adopter(String name, String contactDetails) {
        this.id = idCounter++;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }
}

class Pet {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String breed;
    private int age;
    private int adopterId;
    private String status;

    public Pet(String name, String breed, int age, int adopterId) {
        this.id = idCounter++;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.adopterId = adopterId;
        this.status = "Available";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getAdopterId() {
        return adopterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
}

public class PetAdoptionPlatform {
    private static ArrayList<Adopter> adopters = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
                System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addAdopter(scanner);
                    break;
                case 2:
                    viewAdopters();
                    break;
                case 3:
                    addAdoptedPet(scanner);
                    break;
                case 4:
                    viewAdoptedPets();
                    break;
                case 5:
                    updateAdoptionStatus(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the Pet Adoption Platform. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Pet Adoption Platform");
        System.out.println("1. Add Adopter");
        System.out.println("2. View Adopters");
        System.out.println("3. Add Adopted Pet");
        System.out.println("4. View Adopted Pets");
        System.out.println("5. Update Adoption Status");
        System.out.println("6. Exit");
    }

    private static void addAdopter(Scanner scanner) {
        System.out.print("Enter adopter's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = scanner.nextLine();

        Adopter adopter = new Adopter(name, contactDetails);
        adopters.add(adopter);

        System.out.println("Adopter added successfully! Adopter ID: " + adopter.getId());
    }

    private static void viewAdopters() {
        System.out.println("Adopters:");
        System.out.println("| ID | Name      | Contact Details   |");
        System.out.println("|---------------------------------|");
        for (Adopter adopter : adopters) {
            System.out.printf("| %-2d | %-10s | %-18s |%n", adopter.getId(), adopter.getName(), adopter.getContactDetails());
        }
        System.out.println("|---------------------------------|");
    }

    private static void addAdoptedPet(Scanner scanner) {
        System.out.print("Enter pet's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet's breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter pet's age: ");
        int age = scanner.nextInt();
        System.out.print("Enter adopter's ID: ");
        int adopterId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Pet pet = new Pet(name, breed, age, adopterId);
        pets.add(pet);

        System.out.println("Pet added successfully! Pet ID: " + pet.getId());
    }

    private static void viewAdoptedPets() {
        System.out.println("Adopted Pets:");
        System.out.println("| ID | Name  | Breed    | Age | Adopter  | Status    |");
        System.out.println("|-----------------------------------------------------|");
        for (Pet pet : pets) {
            if (pet.getStatus().equals("Adopted")) {
                Adopter adopter = findAdopterById(pet.getAdopterId());
                System.out.printf("| %-2d | %-5s | %-8s | %-3d | %-8s | %-9s |%n",
                        pet.getId(), pet.getName(), pet.getBreed(), pet.getAge(), adopter.getName(), pet.getStatus());
            }
        }
        System.out.println("|-----------------------------------------------------|");
    }

    private static void updateAdoptionStatus(Scanner scanner) {
        System.out.print("Enter pet's name or ID: ");
        String input = scanner.nextLine();

        Pet pet = findPet(input);

        if (pet != null) {
            System.out.print("Enter new status (Available, Adopted, Returned): ");
            String newStatus = scanner.nextLine();
            pet.setStatus(newStatus);
            System.out.println("Pet status updated successfully!");
        } else {
            System.out.println("Pet not found. Please check the name or ID and try again.");
        }
    }

    private static Pet findPet(String input) {
        for (Pet pet : pets) {
            if (String.valueOf(pet.getId()).equals(input) || pet.getName().equalsIgnoreCase(input)) {
                return pet;
            }
        }
        return null;
    }

    private static Adopter findAdopterById(int adopterId) {
        for (Adopter adopter : adopters) {
            if (adopter.getId() == adopterId) {
                return adopter;
            }
        }
        return null;
    }
}
