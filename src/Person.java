// Person.java
public class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String bloodType;

    public Person(int id, String name, int age, String bloodType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }

    public Person() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public void displayInfo() {
        System.out.println("Person: " + name + ", Age: " + age);
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", bloodType='" + bloodType + "'}";
    }
}

