package QuestionOne;

/**
 * @author Dev
 * @param <E>
 */
public class Queue<E extends Comparable> {

    //private method storing queue elements
    private LinkedList<E> queue;

    //Initializing object queue calling linked list
    public Queue() {
        queue = new LinkedList<>();
    }

    //Returns link list object that stores queue elements
    public LinkedList<E> getQueue() {
        return queue;
    }

    //sets link list object which stores queue elements
    public void setQueue(LinkedList<E> queue) {
        this.queue = queue;
    }

    //adds an element at the end of the queue
    public void enqueue(E data) {
        queue.add(data);
    }

    //removes head element front of the queue
    public E dequeue() {
        return (E) queue.removeFromHead();
    }

    //prints the element of queue within an order and calls the printlinklist method
    public void printQueue() {
        queue.printLinkedList();
    }

    //returns the numbers of the elements in the queue
    public int getSize() {
        return queue.size;
    }

    //supposed to check if queue is empty and print a error 
    public boolean isEmpty() {
        return (queue.size == 0);
    }
}
