package stack.array;


public class Test {
    public static void main(String[] args) {
        ArrayStack<String> stringStack = new ArrayStack<String>(String.class, 5);
        ArrayStack<Integer> integerStack = new ArrayStack<Integer>(Integer.class, 10);

        stringStack.push("Hello");
        stringStack.push("Duong");
        stringStack.push("Dinh");

        System.out.println(stringStack.peek());
//        stringStack.pop();
//        stringStack.pop();
//        stringStack.pop();

//        stringStack.display();

    }
}
