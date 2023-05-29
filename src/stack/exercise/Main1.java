package stack.exercise;

public class Main1 {
    public static void main(String[] args) {
        Lesson1<Student> studentStack = new Lesson1<>(Student.class, 5);
        studentStack.push(new Student(1, "Duong Dinh", 22, "Ha Noi"));
        studentStack.push(new Student(1, "Duong Tien", 23, "Ha Tinh"));
        studentStack.push(new Student(1, "Duong Duong", 21, "Ha Long"));
        studentStack.push(new Student(1, "Duong Anh", 20, "Ha Anh"));


        System.out.println("Stack is empty: " + studentStack.isEmpty());
        System.out.println("Stack is full: " + studentStack.isFull());
        System.out.println("Stack have length: " + studentStack.getCapacity());

        studentStack.pop();
        studentStack.pop();

        Student.title();
        studentStack.display();
    }
}
