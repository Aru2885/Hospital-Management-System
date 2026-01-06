public class Patient extends Person {

    public Patient(int id, String name, int age, String bloodType) {
        super(id, name, age, bloodType);
    }

    public Patient() {
        super();
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient: " + name + ", Age: " + age + ", Blood Type: " + bloodType);
    }

    public boolean isMinor() {
        return age < 18;
    }

    public String getAgeGroup() {
        return (age < 18) ? "Child" : "Adult";
    }
}
