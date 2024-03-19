package eew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Event {
    String name;
    String date;
    String location;
    String description;
    String status;
    List<String> attendees;

    public Event(String name, String date, String location, String description) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.status = "Scheduled";
        this.attendees = new ArrayList<>();
    }
}


public class Eew {
    private static Map<String, Event> events = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            display();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    disp();
                    break;
                case 3:
                    rsvp();
                    break;
                case 4:
                    view();
                    break;
                case 5:
                    up();
                    break;
                case 6:
                    System.out.println("Exiting Event Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void display() {
        System.out.println("\nWelcome to the Event Management System!");
        System.out.println("1. Create event");
        System.out.println("2. View events");
        System.out.println("3. RSVP to event");
        System.out.println("4. View attendees");
        System.out.println("5. Update event status");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void create() {
        System.out.println("\n- Create Event:");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter event location: ");
        String location = scanner.nextLine();
        System.out.print("Enter event description: ");
        String description = scanner.nextLine();

        Event newEvent = new Event(name, date, location, description);
        events.put(name, newEvent);

        System.out.println("Event \"" + name + "\" created successfully!");
    }

    private static void disp() {
        System.out.println("\n- Display Events:");
        System.out.println("Event Name\t|Date\t\t|Location\t\t\t|Description");
        System.out.println("-------------------------------------------------------------------------------------------");
        events.values().forEach((event) -> {
            System.out.printf("%-15s\t|%s\t|%s\t\t|%s%n", event.name, event.date, event.location, event.description);
        });
    }

    private static void rsvp() {
        System.out.println("\n- RSVP to Event:");
        System.out.print("Enter your name: ");
        String attendeeName = scanner.nextLine();
        System.out.print("Enter the event name to RSVP: ");
        String eventName = scanner.nextLine();

        Event event = events.get(eventName);

        if (event == null) {
           
            System.out.println("Event not found. Please check the event name and try again.");
        } else {
             event.attendees.add(attendeeName);
            System.out.println("RSVP successful! You are now registered for the \"" + eventName + "\" event.");
        }
    }

    private static void view() {
        System.out.println("\n- View Attendees:");
        System.out.println("Event Name\t|Date\t\t|Attendees");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Event event : events.values()) {
            System.out.printf("%-15s\t|%s\t|%s%n", event.name, event.date, String.join(", ", event.attendees));
        }
    }

    private static void up() {
        System.out.println("\n- Update Event Status:");
        System.out.print("Enter the event name: ");
        String eventName = scanner.nextLine();
        Event event = events.get(eventName);

        if (event != null) {
            System.out.print("Enter the new status (Scheduled/In Progress/Completed): ");
            String newStatus = scanner.nextLine();
            event.status = newStatus;
            System.out.println("Event status updated successfully!");
        } else {
            System.out.println("Event not found. Please check the event name and try again.");
        }
    }
}