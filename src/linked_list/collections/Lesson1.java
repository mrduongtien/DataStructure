package linked_list.collections;

import java.util.*;

public class Lesson1<T> {
    private LinkedList<Student> linkedList;
    private Student student;
    private Scanner scanner;

    public Lesson1() {
        this.linkedList = new LinkedList<Student>();
        student = new Student();
        scanner = new Scanner(System.in);

    }

    public static void main(String[] args) {
        Lesson1 main = new Lesson1();
        main.test();
//        main.display();
//        main.sortIdASC();
//        main.sortNameASC();
//        main.sortAgeASC();
//        main.sortMediumScoreDESC();
//        main.countStudentByScoreConditions();
        main.approximateSearch();
//        main.display();
    }

    public void addStudent() {
        System.out.print("Input student number: ");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("-------------- STUDENT [" + (i + 1) + "] --------------");
            Student newStudent = student.addNewStudent();
            linkedList.add(newStudent);
        }
    }

    public Student searchStudent() {
        System.out.print("Enter the student code you want to search for: ");
        int id = scanner.nextInt();
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getId() == id) {
                System.out.println(linkedList.get(i));
                return linkedList.get(i);
            }
        }
        return null;
    }

    public void updateScore() {
        System.out.println("-------------- UPDATE DATA --------------");
        Student student = searchStudent();
        System.out.print("Input new score: ");
        double score = scanner.nextDouble();
        student.setMediumScore(score);
        System.out.println("Update successfully, new data: ");
        System.out.println(student);
    }

    public void display() {
        Iterator<Student> iterator = linkedList.iterator();
        System.out.println("\t\t\t\t\t\t\t-------------- LIST DATA --------------");
        Student.title();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void removeStudent() {
        System.out.println("\t\t\t\t\t\t\t-------------- REMOVE DATA --------------");
        Student student = searchStudent();
        linkedList.remove(student);
    }

    public void sortIdASC() {
        System.out.println("\t\t\t\t\t\t\t-------------- SORTED ID --------------");
        linkedList.sort(Comparator.comparingInt(Student::getId));
        display();
    }

    public void sortNameASC() {
        System.out.println("\t\t\t\t\t\t\t-------------- SORTED NAME --------------");
        linkedList.sort(Comparator.comparing(Student::getName));
        display();
    }

    public void sortAgeASC() {
        System.out.println("\t\t\t\t\t\t\t-------------- SORTED AGE --------------");
        linkedList.sort(Comparator.comparingInt(Student::getAge));
        display();
    }

    public void sortMediumScoreDESC() {
        System.out.println("-------------- SORTED SCORE --------------");
        linkedList.sort((o1, o2) -> {
            int compareScore = (int) (o2.getMediumScore() - o1.getMediumScore());
            if (compareScore != 0) {
                return compareScore;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void countStudentByScoreConditions() {
        int count = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getMediumScore() >= 4.0) {
                count++;
            }
        }
        System.out.println("Have " + count + " students!");
    }

    public void approximateSearch() {
        boolean isExist = false;
        System.out.println("Input text: ");
        String regex = scanner.nextLine();
        for (var e : linkedList) {
            if (e.getName().toLowerCase().matches(".*" + regex.toLowerCase() + ".*")){
                isExist = true;
                System.out.println(e);
            }
        }
        if (!isExist) {
            System.out.println("Not found");
        }
    }

    public void test() {
        linkedList.add(new Student(9, "chuong", "a", 1, 4.5));
        linkedList.add(new Student(5, "b", "b", 8, 8.5));
        linkedList.add(new Student(3, "duong", "a", 5, 4.5));
        linkedList.add(new Student(2, "f", "a", 3, 9.5));
        linkedList.add(new Student(1, "a", "a", 9, 4.5));
    }


}
