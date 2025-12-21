public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String bloodType;
    public Patient(int patientId, String name, int age, String bloodType) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }
    public Patient() {
        this.patientId = 0;
        this.name = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
    }
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBloodType() {
        return bloodType;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public boolean isMinor() {
        return age < 18;
    }
    public String getAgeGroup() {
        if (age < 18) {
            return "Child";
        }
        return "Adult";
    }
    @Override
    public String toString() {
        return "Patient{id=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}

