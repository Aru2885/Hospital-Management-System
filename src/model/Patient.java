package model;

public class Patient extends Person {

    public Patient(int id, String name, int age, String bloodType) {
        super(id, name, age, bloodType);
    }

    public Patient() {
        super();
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient: " + name +
                ", Age: " + age +
                ", Blood Type: " + bloodType);
    }
}




