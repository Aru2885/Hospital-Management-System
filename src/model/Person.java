package model;

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String bloodType;

    public Person(int id, String name, int age, String bloodType) {
        setId(id);
        setName(name);
        setAge(age);
        setBloodType(bloodType);
    }

    public Person() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
    }
    public abstract String getRole();

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setBloodType(String bloodType) {
        if (bloodType == null || bloodType.trim().isEmpty()) {
            throw new IllegalArgumentException("Blood type cannot be empty");
        }
        this.bloodType = bloodType;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public void displayInfo() {
        System.out.println(getRole() + ": " + name + ", Age: " + age);
    }
}