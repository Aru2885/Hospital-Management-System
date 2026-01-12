public class Doctor extends Person {
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
    public int getExperienceYears() {
        return experienceYears;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        }
    }
    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) {
            this.specialization = specialization;
        }
    }
    public boolean isExperienced() {
        return experienceYears >= 5;
    }
    public boolean canPerformSurgery() {
        return experienceYears >= 3;
    }
    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization + ", Experience: " + experienceYears + " years");
    }
}

