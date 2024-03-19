import java.util.ArrayList;
import java.util.Scanner;

class Adopter {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String contactDetails;

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

    private final int id;
    private final String name;
    private final String breed;
    private final int age;
    private final int adopterId;
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

        while (true) {
            System.out.println("\nPet Adoption Platform");
            System.out.println("1. Add Adopter");
            System.out.println("2. View Adopters");
            System.out.println("3. Add Adopted Pet");
            System.out.println("4. View Adopted Pets");
            System.out.println("5. Update Adoption Status");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addAdopter(scanner);
                    break;
                case 2:
                    viewAdopters();
                    break;
                case 3:
                    addPet(scanner);
                    break;
                case 4:
                    viewPets();
                    break;
                case 5:
                    updateAdoptionStatus(scanner);
                    break;
                case 6:
                    System.out.println("Thank You!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAdopter(Scanner scanner) {
        System.out.println("\n- Adding Adopter");
        System.out.print("Enter adopter's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = scanner.nextLine();

        Adopter adopter = new Adopter(name, contactDetails);
        adopters.add(adopter);

        System.out.println("Adopter added successfully! Adopter ID: " + adopter.getId());
    }

    private static void viewAdopters() {
        System.out.println("\n- Viewing Adopters\n");
        System.out.println("| ID | Name       | Contact Details      |");
        System.out.println("----------------------------------------");

        adopters.forEach((adopter) -> {
            System.out.printf("| %-2d | %-10s | %-20s |\n", adopter.getId(), adopter.getName(), adopter.getContactDetails());
        });
    }

    private static void addPet(Scanner scanner) {
        System.out.println("\n- Adding Pet");
        System.out.print("Enter pet's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet's breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter pet's age: ");
        int age = scanner.nextInt();
        System.out.print("Enter adopter's ID: ");
        int adopterId = scanner.nextInt();

        // Check if the adopter with the given ID exists
        Adopter adopter = findAdopterById(adopterId);
        if (adopter == null) {
            System.out.println("Adopter with ID " + adopterId + " not found. Please add the adopter first.");
            return;
        }

        Pet pet = new Pet(name, breed, age, adopterId);
        pets.add(pet);

        System.out.println("Pet added successfully!");
    }

    private static void viewPets() {
        System.out.println("\n- Viewing Adopted Pets\n");
        System.out.println("| Name  | Breed    | Age | Adopter  | Status  |");
        System.out.println("---------------------------------------------");

        pets.forEach((pet) -> {
            Adopter adopter = findAdopterById(pet.getAdopterId());
            System.out.printf("| %-5s | %-8s | %-3d | %-8s | %-8s |\n",
                    pet.getName(), pet.getBreed(), pet.getAge(), adopter.getName(), pet.getStatus());
        });
    }

    private static void updateAdoptionStatus(Scanner scanner) {
        System.out.println("\n- Updating Pet Status");
        System.out.print("Enter pet's name or ID: ");
        String petNameOrId = scanner.nextLine();

        Pet pet = findPetByNameOrId(petNameOrId);
        if (pet == null) {
            System.out.println("Pet with name or ID " + petNameOrId + " not found. Please try again.");
            return;
        }

        System.out.print("Enter new status (Available, Adopted, Returned): ");
        String newStatus = scanner.nextLine();
        pet.setStatus(newStatus);

        System.out.println("Adoption status updated successfully!");
    }

    private static Adopter findAdopterById(int adopterId) {
        for (Adopter adopter : adopters) {
            if (adopter.getId() == adopterId) {
                return adopter;
            }
        }
        return null;
    }

    private static Pet findPetByNameOrId(String petNameOrId) {
        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petNameOrId) || Integer.toString(pet.getId()).equals(petNameOrId)) {
                return pet;
            }
        }
        return null;
    }
}
