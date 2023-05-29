package stack.exercise;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void title() {
        System.out.printf("%5s %15s %10s %15s", "ID", "Name", "Age", "Address");
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("%5d %15s %10d %15s", id, name, age, address);
    }
}
