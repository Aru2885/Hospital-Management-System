package model;

public class Doctor extends Person implements Treatable {
    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String specialization, int experienceYears) {
        super(id, name, 0, "N/A");
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public Doctor() {
        super();
        this.specialization = "General";
        this.experienceYears = 0;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void treatPatient() {
        System.out.println("Doctor " + getName() + " is treating a patient.");
    }
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }
    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + getName() +
                ", Specialization: " + specialization +
                ", Experience: " + experienceYears + " years");
    }
}