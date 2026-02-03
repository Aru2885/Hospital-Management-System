package database;

import model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PatientDAO {
    public void insertPatient(Patient patient) {
        String sql = "INSERT INTO hospital (name,age,blood_type, diagnosis, admission_date)VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getBloodType());
            statement.setString(4, patient.getDiagnosis());
            statement.setDate(5, patient.getAdmissionDate());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient has been inserted successfully.");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Patient has been inserted failed.");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

    }
    public void getAllPatients() {
        String sql = "SELECT * FROM hospital ORDER BY patient_id";
        Connection connection = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            ResultSet resultSet= statement.executeQuery();
            System.out.println("ALL PATIENTS");
            int count=0;
            while(resultSet.next()){
                displayPatientFromResultSet(resultSet);
            }
            if(count==0){
                System.out.println("No PATIENTS found.");
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException e){
            System.out.println("Select failed.");
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }

    }
    public Patient getPatientById(int patientId){
        String sql = "SELECT * FROM hospital WHERE patient_id=?";
        Connection connection= DatabaseConnection.getConnection();
        Patient patient=null;
        try {
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1,patientId);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                patient= extractPatientFromResultSet(resultSet);
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException e){
            System.out.println("Patient has been selected failed.");
            e.printStackTrace();
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return patient;
    }
    public boolean updatePatient(Patient patient){
        String sql= "UPDATE hospital SET name=?,age=?,blood_type=?,diagnosis=?,admission_date=? WHERE patient_id=?";
        Connection connection= DatabaseConnection.getConnection();
        if (connection==null) return false;
        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,patient.getName());
            statement.setInt(2,patient.getAge());
            statement.setString(3,patient.getBloodType());
            statement.setString(4,patient.getDiagnosis());
            statement.setDate(5,patient.getAdmissionDate());
            statement.setInt(6,patient.getId());
            int rowsUpdated=statement.executeUpdate();
            statement.close();
            if(rowsUpdated>0){
                System.out.println("Patient has been updated successfully.");
                return true;
            }
            else{
                System.out.println("No patient found with ID:"+patient.getId());
            }

        }
        catch (SQLException e){
            System.out.println("Patient has been updated failed.");
            e.printStackTrace();
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public boolean deletePatient(int patientId) {
        String sql = "DELETE FROM hospital WHERE patient_id = ?";
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("Patient deleted successfully!");
                return true;
            } else {
                System.out.println("No patient found with ID: " + patientId);
            }
        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }
    public List<Patient> searchByName(String name) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM hospital WHERE name ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null) return patients;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = extractPatientFromResultSet(resultSet);
                if (patient != null) {
                    patients.add(patient);
                }
            }

            System.out.println("Found " + patients.size() + " patient(s)");
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patients;
    }
    public List<Patient> searchByAgeRange(int minAge, int maxAge) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM hospital WHERE age BETWEEN ? AND ? ORDER BY age DESC";
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null) return patients;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Patient patient = extractPatientFromResultSet(resultSet);
                if (patient != null) {
                    patients.add(patient);
                }
            }

            System.out.println("Found " + patients.size() + " patient(s) in age range " + minAge + "-" + maxAge);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patients;
    }
    public List<Patient> searchByDiagnosis(String diagnosis) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM hospital WHERE diagnosis ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null) return patients;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + diagnosis + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Patient patient = extractPatientFromResultSet(resultSet);
                if (patient != null) {
                    patients.add(patient);
                }
            }

            System.out.println("Found " + patients.size() + " patient(s) with diagnosis containing '" + diagnosis + "'");
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patients;
    }
    private Patient extractPatientFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("patient_id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String bloodType = resultSet.getString("blood_type");
        String diagnosis = resultSet.getString("diagnosis");
        Date admissionDate = resultSet.getDate("admission_date");

        return new Patient(id, name, age, bloodType, diagnosis, admissionDate);
    }
    private void displayPatientFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("patient_id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String bloodType = resultSet.getString("blood_type");
        String diagnosis = resultSet.getString("diagnosis");
        Date admissionDate = resultSet.getDate("admission_date");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("---");
    }

}

