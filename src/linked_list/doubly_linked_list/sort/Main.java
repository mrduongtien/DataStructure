package linked_list.doubly_linked_list.sort;

public class Main {
    public static void main(String[] args) {
        Sorted<Student> main = new Sorted<Student>();
        Student s1 = new Student(5, "Tien", 9.5);
        Student s2 = new Student(3, "Duong", 8.0);
        Student s3 = new Student(6, "Dinh", 7.5);
        Student s4 = new Student(1, "Pham", 9.0);
        Student s5 = new Student(2, "Thi", 6.5);
        main.addLast(s1);
        main.addLast(s2);
        main.addLast(s3);
        main.addLast(s4);
        main.addLast(s5);

        main.display();

        System.out.println("Sort ID ASC");
        main.sortASC();
        main.display();

        System.out.println("Sort ID ASC");
        main.sortDESC();
        main.display();
    }
}
