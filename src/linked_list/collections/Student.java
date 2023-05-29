package linked_list.collections;

import java.util.Objects;
import java.util.Scanner;

public class Student {
    private int id;
    private String name, email;
    private int age;
    private double mediumScore;

    public Student() {
    }

    public Student(int id, String name, String email, int age, double mediumScore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.mediumScore = mediumScore;
    }

    public Student addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        int nId = Integer.parseInt(scanner.nextLine());
        System.out.print("Input name: ");
        String nName = scanner.nextLine();
        System.out.print("Input email: ");
        String nEmail = scanner.nextLine();
        System.out.print("Input age: ");
        int nAge = Integer.parseInt(scanner.nextLine());
        System.out.print("Input medium score: ");
        double nMediumScore = Double.parseDouble(scanner.nextLine());
        return new Student(nId, nName, nEmail, nAge, nMediumScore);
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

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student other){
            return this.id == other.id;
        }
        return false;
    }

    public static void title() {
        System.out.printf("%15s %15s %15s %15s %15s", "ID", "Name", "Email", "Age", "Score");
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("%15d %15s %15s %15d %15.2f", id, name, email, age, mediumScore );
    }
}
