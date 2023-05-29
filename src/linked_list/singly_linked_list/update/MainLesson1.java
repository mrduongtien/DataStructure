package linked_list.singly_linked_list.update;

public class MainLesson1 {
    public static void main(String[] args) {
        Lesson1<Integer> numbers = new Lesson1<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);

        System.out.print("Number list: ");
        numbers.displayList();
        var isNumberUpdated = numbers.updateHeadNode(0);
        if (isNumberUpdated){
            System.out.print("Success: ");
            numbers.displayList();
        } else {
            System.out.println("Fail");
        }

        Lesson1<String> strings = new Lesson1<>();
        strings.addLast("Duong");
        strings.addLast("Dinh");
        strings.addLast("Duong");
        strings.addLast("Tien");
        strings.addLast("Duong");
        strings.addLast("Dev");

        System.out.print("String list: ");
        strings.displayList();
        var isStringUpdated = strings.updateNode(new Lesson1.Node("Duong"), "Ong");
        int count = isStringUpdated;
        if (count >= 1){
            System.out.println("Updated: " + count);
            strings.displayList();
        } else {
            System.out.println("Fail");
        }

    }
}
