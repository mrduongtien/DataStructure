package linked_list.singly_linked_list.update;

import java.util.Objects;

public class Student {
    private String id;
    private String fullName;
    private String email;
    private int age;
    private double gpa;

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student(String id, String fullName, String email, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student other) {
            return this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}
