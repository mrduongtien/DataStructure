package linked_list.singly_linked_list.update;

public class UpdateNodeData {
    public static void main(String[] args) {
        SinglyLinkedList<String> names = new SinglyLinkedList<String>();
        names.insertTail("Duong");
        names.insertTail("Dinh");
        names.insertTail("Tien");

        SinglyLinkedList.Node request = new SinglyLinkedList.Node<>("Tien");
        var check = names.updateNodeData(request, "Dev");
        names.showList();

        SinglyLinkedList<Student> students = new SinglyLinkedList<Student>();
        Student s1 = new Student("ID1", "Duong", "duong@gmail.com", 22, 3.5);
        Student s2 = new Student("ID2", "Dinh", "dinh@gmail.com", 23, 4.0);
        Student s3 = new Student("ID3", "Tien", "tien@gmail.com", 32, 2.5);
        Student s4 = new Student("ID4", "Dev", "dev@gmail.com", 20, 4.0);
        students.insertTail(s1);
        students.insertTail(s2);
        students.insertTail(s3);
        students.insertTail(s4);
        students.showList();

        s1.setFullName("Truong");
        s1.setEmail("truong@gmail.com");
        SinglyLinkedList.Node target = new SinglyLinkedList.Node(s4);
        var result = students.updateNodeData(target, s1);
        if (result) {
            System.out.println("Updated");
            students.showList();
        } else {
            System.out.println("Not found");
        }

    }
}
