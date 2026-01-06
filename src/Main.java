import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Person> people = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Hospital Management System ===");

        people.add(new Patient(1, "Aruzhan Rsaliyeva", 19, "A+"));
        people.add(new Patient());
        people.add(new Doctor(101, "Dr. Smith", "Therapist", 6));
        people.add(new Doctor());

        appointments.add(new Appointment(1001, "Anna Lee", "Dr. Smith", "2025-01-15", "Scheduled"));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> viewAllPeople();
                case 4 -> demonstratePolymorphism();
                case 5 -> viewDoctorsOnly();
                case 6 -> viewPatientsOnly();
                case 0 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All People (Polymorphic)");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. View Doctors Only");
        System.out.println("6. View Patients Only");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addPatient() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();
        people.add(new Patient(id, name, age, bloodType));
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Enter Experience Years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();
        people.add(new Doctor(id, name, spec, exp));
        System.out.println("Doctor added successfully!");
    }

    private static void viewAllPeople() {
        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) {
            p.displayInfo();
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : people) {
            p.displayInfo();
        }
    }

    private static void viewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        for (Person p : people) {
            if (p instanceof Doctor doc) {
                doc.displayInfo();
                System.out.println("Experienced: " + doc.isExperienced());
            }
        }
    }

    private static void viewPatientsOnly() {
        System.out.println("\n--- PATIENTS ONLY ---");
        for (Person p : people) {
            if (p instanceof Patient pat) {
                pat.displayInfo();
                System.out.println("Minor: " + pat.isMinor());
            }
        }
    }
}
