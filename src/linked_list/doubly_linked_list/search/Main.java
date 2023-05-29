package linked_list.doubly_linked_list.search;

public class Main {

    public static void main(String[] args) {
        Search<Student> main = new Search<Student>();
        Student s1 = new Student(1, "Duong", 9.5);
        Student s2 = new Student(2, "Dinh", 8.5);
        Student s3 = new Student(3, "Tien", 9.5);
        Student s4 = new Student(4, "Dev", 7.5);
        Student s5 = new Student(5, "Hehe", 8.5);
        main.addLast(s1);
        main.addLast(s2);
        main.addLast(s3);
        main.addLast(s4);
        main.addLast(s5);

        main.display();
        Search.Node<Student> currentSearch = main.search(s3);
        if (currentSearch != null) {
            System.out.println("Success: ");
            System.out.println(currentSearch.getData());
        } else {
            System.out.println("Not found");
        }

    }
}
