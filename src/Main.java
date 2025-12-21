public class Main {
    public static void main(String[] args) {

        System.out.println("=== Hospital Management System ===\n");
        Patient p1 = new Patient(1, "Aruzhan Rsaliyeva", 19, "A+");
        Patient p2 = new Patient();

        Doctor d1 = new Doctor(101, "Dr. Smith", "Therapist", 6);
        Doctor d2 = new Doctor();

        Appointment a1 = new Appointment(1001, "Anna Lee", "Dr. Smith", "2025-01-15", "Scheduled");

        System.out.println("--- PATIENTS ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\n--- DOCTORS ---");
        System.out.println(d1);
        System.out.println(d2);

        System.out.println("\n--- APPOINTMENTS ---");
        System.out.println(a1);
        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(p1.getName() + " is minor: " + p1.isMinor());
        System.out.println(d1.getName() + " experienced: " + d1.isExperienced());

        a1.reschedule("2025-02-01");
        System.out.println("Rescheduled appointment: " + a1);

        System.out.println("\n=== Program Complete ===");
    }
}

