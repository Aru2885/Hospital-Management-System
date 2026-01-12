public class Person {

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public void setBloodType(String bloodType) {
        if (bloodType != null && !bloodType.isEmpty()) {
            this.bloodType = bloodType;
        }
    }

    public boolean isMinor() {
        return age < 18;
    }

    public void displayInfo() {
        System.out.println("Person: " + name + ", Age: " + age);
    }
}

