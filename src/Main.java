import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static final ArrayList<Person> people = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        people.add(new Patient(1, "Aruzhan Rsaliyeva", 19, "A+"));
        people.add(new Patient());
        people.add(new Doctor(101, "Dr. Smith", "Therapist", 6));
        people.add(new Doctor());
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
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
    private static void showMenu() {
        System.out.println("\n=================================");
        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("=================================");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All People");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("5. View Doctors Only");
        System.out.println("6. View Patients Only");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
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
        System.out.println("Patient added.");
    }
    private static void addDoctor() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Experience Years: ");
        int experience = scanner.nextInt();
        scanner.nextLine();
        people.add(new Doctor(id, name, specialization, experience));
        System.out.println("Doctor added.");
    }
    private static void viewAllPeople() {
        System.out.println("\n--- ALL PEOPLE ---");
        if (people.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Person p : people) {
            p.displayInfo();
            System.out.println();
        }
    }
    private static void demonstratePolymorphism() {
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        for (Person p : people) {
            p.displayInfo();
            if (p instanceof Patient pat) {
                if (pat.isMinor()) {
                    System.out.println("This patient is a minor.");
                }
            } else if (p instanceof Doctor doc) {
                System.out.println("Specialization: " + doc.getSpecialization());
                System.out.println("Experience Years: " + doc.getExperienceYears());
                if (doc.isExperienced()) {
                    System.out.println("This doctor is experienced.");
                }
            }

            System.out.println("---------------------------------"); // separator for clarity
        }
    }
    private static void viewDoctorsOnly() {
        System.out.println("\n--- DOCTORS ONLY ---");
        for (Person p : people) {
            if (p instanceof Doctor d) {
                d.displayInfo();
                System.out.println("Experienced: " + d.isExperienced());
                System.out.println();
            }
        }
    }
    private static void viewPatientsOnly() {
        System.out.println("\n--- PATIENTS ONLY ---");
        for (Person p : people) {
            if (p instanceof Patient pat) {
                pat.displayInfo();
                System.out.println("Minor: " + pat.isMinor());
                System.out.println();
            }
        }
    }
}
