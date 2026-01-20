package menu;
import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;
public class HospitalMenu implements Menu {
    private final ArrayList<Person> people;
    private final Scanner scanner;
    public HospitalMenu() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
        people.add(new Patient(1, "Aruzhan Rsaliyeva", 19, "A+"));
        people.add(new Doctor(101, "Dr. Smith", "Therapist", 6));
    }
    @Override
    public void displayMenu() {
        System.out.println("\n===============================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("===============================");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All People");
        System.out.println("4. Demonstrate Polymorphism");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> addDoctor();
                    case 3 -> viewAllPeople();
                    case 4 -> demonstratePolymorphism();
                    case 0 -> {
                        System.out.println("Exiting program...");
                        running = false;
                    }
                    default -> throw new InvalidInputException("Invalid menu choice!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number.");
            }
            catch (InvalidInputException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void addPatient() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Blood Type: ");
            String bloodType = scanner.nextLine();

            Patient patient = new Patient(id, name, age, bloodType);
            people.add(patient);

            System.out.println("Patient added successfully!");

        }
        catch (NumberFormatException e) {
            System.out.println("Error: ID and Age must be numbers.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addDoctor() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();

            System.out.print("Enter Experience Years: ");
            int experience = Integer.parseInt(scanner.nextLine());

            Doctor doctor = new Doctor(id, name, specialization, experience);
            people.add(doctor);

            System.out.println("Doctor added successfully!");

        }
        catch (NumberFormatException e) {
            System.out.println("Error: ID and experience must be numbers.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAllPeople() {
        if (people.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n--- ALL PEOPLE ---");
        for (Person p : people) {
            p.displayInfo();
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO» ---");

        for (Person p : people) {
            p.displayInfo();

            if (p instanceof Treatable t) {
                t.treatPatient();
            }

            if (p.isMinor()) {
                System.out.println("This person is a minor.");
            }

            System.out.println("---------------------------");
        }
    }
}


