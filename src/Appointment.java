public class Appointment {

    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String status;

    public Appointment(int appointmentId, String patientName, String doctorName, String date, String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.status = status;
    }

    public Appointment() {
        this.appointmentId = 0;
        this.patientName = "Unknown";
        this.doctorName = "Unknown";
        this.date = "Not set";
        this.status = "Scheduled";
    }
    public int getAppointmentId() {
        return appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void reschedule(String newDate) {
        this.date = newDate;
    }
    public void cancel() {
        this.status = "Cancelled";
    }

    @Override
    public String toString() {
        return "Appointment{id=" + appointmentId +
                ", patient='" + patientName + '\'' +
                ", doctor='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

