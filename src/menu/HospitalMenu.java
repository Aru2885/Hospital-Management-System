package menu;

import model.*;
import database.PatientDAO;
import exception.InvalidInputException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private final Scanner scanner;
    private final PatientDAO patientDAO;

    public HospitalMenu() {
        scanner = new Scanner(System.in);
        patientDAO = new PatientDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n===============================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("===============================");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. View All Patients");
        System.out.println("4. View All Doctors");
        System.out.println("5. Update Patient");
        System.out.println("6. Delete Patient");
        System.out.println("7. Search Patient by Name");
        System.out.println("8. Search Patient by Age Range");
        System.out.println("9. Search Patient by Diagnosis");
        System.out.println("10. Demonstrate Polymorphism");
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
                    case 3 -> viewAllPatients();
                    case 4 -> viewAllDoctors();
                    case 5 -> updatePatient();
                    case 6 -> deletePatient();
                    case 7 -> searchPatientByName();
                    case 8 -> searchPatientByAgeRange();
                    case 9 -> searchPatientByDiagnosis();
                    case 10 -> demonstratePolymorphism();
                    case 0 -> {
                        System.out.println("Exiting program...");
                        running = false;
                    }
                    default -> throw new InvalidInputException("Invalid menu choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number.");
            } catch (InvalidInputException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void addPatient() {
        try {
            System.out.print("Enter Patient ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Patient Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Patient Blood Type: ");
            String bloodType = scanner.nextLine();

            System.out.print("Enter Patient Diagnosis: ");
            String diagnosis = scanner.nextLine();

            System.out.print("Enter Admission Date (YYYY-MM-DD): ");
            Date admissionDate = Date.valueOf(scanner.nextLine());

            Patient patient = new Patient(id, name, age, bloodType, diagnosis, admissionDate);
            patientDAO.insertPatient(patient);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addDoctor() {
    }

    private void viewAllPatients() {
        patientDAO.getAllPatients();
    }

    private void viewAllDoctors() {
        System.out.println("Doctor viewing not implemented yet.");
    }
    private void updatePatient() {
        try {
            System.out.print("Enter Patient ID to update: ");
            int patientId = Integer.parseInt(scanner.nextLine());
            Patient existingPatient = patientDAO.getPatientById(patientId);
            if (existingPatient == null) {
                System.out.println("No patient found with ID: " + patientId);
                return;
            }
            System.out.println("\nCurrent Patient Information:");
            System.out.println("Name: " + existingPatient.getName());
            System.out.println("Age: " + existingPatient.getAge());
            System.out.println("Blood Type: " + existingPatient.getBloodType());
            System.out.println("Diagnosis: " + existingPatient.getDiagnosis());
            System.out.println("Admission Date: " + existingPatient.getAdmissionDate());
            System.out.println("\nEnter new values (press Enter to keep current):");

            System.out.print("New Name [" + existingPatient.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.trim().isEmpty()) {
                newName = existingPatient.getName();
            }

            System.out.print("New Age [" + existingPatient.getAge() + "]: ");
            String ageInput = scanner.nextLine();
            int newAge = ageInput.trim().isEmpty() ?
                    existingPatient.getAge() : Integer.parseInt(ageInput);

            System.out.print("New Blood Type [" + existingPatient.getBloodType() + "]: ");
            String newBloodType = scanner.nextLine();
            if (newBloodType.trim().isEmpty()) {
                newBloodType = existingPatient.getBloodType();
            }

            System.out.print("New Diagnosis [" + existingPatient.getDiagnosis() + "]: ");
            String newDiagnosis = scanner.nextLine();
            if (newDiagnosis.trim().isEmpty()) {
                newDiagnosis = existingPatient.getDiagnosis();
            }

            System.out.print("New Admission Date [" + existingPatient.getAdmissionDate() + "]: ");
            String dateInput = scanner.nextLine();
            Date newAdmissionDate = dateInput.trim().isEmpty() ?
                    existingPatient.getAdmissionDate() : Date.valueOf(dateInput);
            Patient updatedPatient = new Patient(patientId, newName, newAge, newBloodType,
                    newDiagnosis, newAdmissionDate);
            patientDAO.updatePatient(updatedPatient);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void deletePatient() {
        try {
            System.out.print("Enter Patient ID to delete: ");
            int patientId = Integer.parseInt(scanner.nextLine());
            Patient patient = patientDAO.getPatientById(patientId);
            if (patient == null) {
                System.out.println("No patient found with ID: " + patientId);
                return;
            }
            System.out.println("\nPatient to delete:");
            System.out.println("ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Diagnosis: " + patient.getDiagnosis());
            System.out.print("\n Are you sure you want to delete this patient? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (confirmation.equals("yes")) {
                patientDAO.deletePatient(patientId);
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }
    private void searchPatientByName() {
        System.out.print("Enter name to search (full or partial): ");
        String name = scanner.nextLine();

        List<Patient> patients = patientDAO.searchByName(name);

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n--- SEARCH RESULTS ---");
            for (Patient patient : patients) {
                patient.displayInfo();
                System.out.println("---");
            }
        }
    }
    private void searchPatientByAgeRange() {
        try {
            System.out.print("Enter minimum age: ");
            int minAge = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter maximum age: ");
            int maxAge = Integer.parseInt(scanner.nextLine());

            if (minAge > maxAge) {
                System.out.println("Error: Minimum age cannot be greater than maximum age.");
                return;
            }

            List<Patient> patients = patientDAO.searchByAgeRange(minAge, maxAge);

            if (patients.isEmpty()) {
                System.out.println("No patients found in age range " + minAge + "-" + maxAge);
            } else {
                System.out.println("\n--- SEARCH RESULTS ---");
                for (Patient patient : patients) {
                    patient.displayInfo();
                    System.out.println("---");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        }
    }
    private void searchPatientByDiagnosis() {
        System.out.print("Enter diagnosis to search (full or partial): ");
        String diagnosis = scanner.nextLine();

        List<Patient> patients = patientDAO.searchByDiagnosis(diagnosis);

        if (patients.isEmpty()) {
            System.out.println("No patients found with diagnosis containing '" + diagnosis + "'");
        } else {
            System.out.println("\n--- SEARCH RESULTS ---");
            for (Patient patient : patients) {
                patient.displayInfo();
                System.out.println("---");
            }
        }
    }


    private void demonstratePolymorphism() {
        System.out.println("Polymorphism demo needs database data.");
    }
}


