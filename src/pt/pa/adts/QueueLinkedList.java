package pt.pa.adts;

/**
 * Implementation of a queue using linked list
 * @param <T> element in linked queue
 */
public class QueueLinkedList<T> implements Queue<T> {

    private final Node header;
    private final Node trailer;

    /**
     * Initializes sentinels of queue
     * O(1)
     */
    public QueueLinkedList() {
        this.header = new Node(null, null);
        this.trailer = new Node(null, null);
    }

    /**
     * Inserts element at the end of the queue.
     * trailer.next represents last element of queue.
     * O(1)
     * @param element
     * @throws FullQueueException if queue is full
     */
    @Override
    public void enqueue(T element) throws FullQueueException {
        try {
            Node oldLast = trailer.next;
            trailer.next = new Node(element, null);

            if(isEmpty()){
                header.next = trailer.next;
            }
            else{
                oldLast.next=trailer.next;
            }

        } catch(OutOfMemoryError e) {
            throw new FullQueueException("No memory for more elements.");
        }
    }

    /**
     * Removes element at the start of the queue and returns it
     * O(1)
     * @return element removed
     * @throws EmptyQueueException if queue is empty
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();

        T element = header.next.element;

        header.next = header.next.next;

        return element;
    }

    /**
     * Returns element at the start of the queue
     * O(1)
     * @return element at the start of queue
     * @throws EmptyQueueException if queue is empty
     */
    @Override
    public T front() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();

        return header.next.element;
    }

    /**
     * Returns number of elements in queue
     * O(n)
     * @return number of elements in queue
     */
    @Override
    public int size() {
        int counter = 0;
        Node current = header.next;
        while(current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    /**
     * Returns true if queue has no elements
     * O(1)
     * @return true if queue has no elements
     */
    @Override
    public boolean isEmpty() {
        return this.header.next == null;
    }

    /**
     * Discards all elements in the queue
     * O(1)
     */
    @Override
    public void clear() {
        this.header.next = this.trailer.next = null;
    }

    /**
     * Inner class representing a linked list node.
     * Only recognized in the context of this class (private).
     */
    private class Node {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}