package linked_list;

public class Main {
    public static void main(String[] args) {
        DefaultDoublyLinkedList<String> doublyLinkedList = new DefaultDoublyLinkedList<String>();
        doublyLinkedList.add("Duong");
        doublyLinkedList.add("Tien");
        doublyLinkedList.addFirst("Mr");
        doublyLinkedList.addLast("Dev");

        System.out.println("List data: " + doublyLinkedList);

        System.out.println("Check constrant 'Duong': " + doublyLinkedList.constant("Duong"));

        System.out.println("Index of 'Tien': " + doublyLinkedList.indexOf("Tien"));

        System.out.println("Removed: " + doublyLinkedList.removeAt(2));

        System.out.println(doublyLinkedList);

        doublyLinkedList.clear();
        System.out.println("Clear: " + doublyLinkedList);

    }
}
