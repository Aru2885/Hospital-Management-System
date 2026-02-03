package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Patient extends Person {

    private String diagnosis;
    private Date admissionDate;
    public Patient(int id, String name, int age, String bloodType, String diagnosis, Date admissionDate) {
        super(id, name, age, bloodType);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
    }
    public Patient() {
        super();
    }
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void displayInfo() {
        String dateStr = (admissionDate != null) ? new SimpleDateFormat("yyyy-MM-dd").format(admissionDate) : "N/A";
        System.out.println("Patient: " + name +
                ", Age: " + age +
                ", Blood Type: " + bloodType +
                ", Diagnosis: " + diagnosis +
                ", Admission Date: " + dateStr);
    }

    @Override
    public String toString() {
        String dateStr = (admissionDate != null) ? new SimpleDateFormat("yyyy-MM-dd").format(admissionDate) : "N/A";
        return "Patient{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", admissionDate=" + dateStr + '}';
    }
}





