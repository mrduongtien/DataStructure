package linked_list;

public interface DoublyLinkedList<T> extends Iterable<T> {
    // O(n)
    void clear();

    // constant
    int size();

    // constant
    boolean isEmpty();

    // O(1)
    void add(T element);

    // O(1)
    void addFirst(T element);

    // O(1)
    void addLast(T element);

    // O(1)
    T peekFirst();

    // O(1)
    T peekLast();

    // O(1)
    T removeFirst();

    // O(1)
    T removeLast();

    // O(n)
    T remove(Node<T> node);

    // O(n)
    boolean remove(Object object);

    // O(n)
    T removeAt(int index);

    // O(n)
    boolean constant(Object object);

    // O(n)
    int indexOf(Object object);

}