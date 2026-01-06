public class Doctor extends Person {
    protected String specialization;
    protected int experienceYears;

    public Doctor(int id, String name, String specialization, int experienceYears) {
        super(id, name, 0, "N/A");
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public Doctor() {
        super();
        this.specialization = "General";
        this.experienceYears = 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization + ", Experience: " + experienceYears + " years");
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canPerformSurgery() {
        return experienceYears >= 3;
    }
}
