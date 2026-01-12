import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Patient(1, "Aruzhan Rsaliyeva", 19, "A+"));
        people.add(new Doctor(101, "Dr. Smith", "Therapist", 6));

        people.add(new Patient(-5, "", -20, ""));
        people.add(new Doctor(0, "Bad Doctor", "", -10));

        for (Person p : people) {
            p.displayInfo();

            if (p instanceof Doctor d) {
                System.out.println("Experienced: " + d.isExperienced());
            }

            if (p instanceof Patient pat) {
                System.out.println("Minor: " + pat.isMinor());
            }

            System.out.println();
        }
    }
}
