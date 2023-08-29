package QuestionOne;

/**
 * @author Dev Vaidya
 * @StudentID 19087471
 * @param <E>
 */
public class Stack<E extends Comparable> {

    //linked list is to store the stack elements
    private LinkedList<E> stack;

    //Initializing object stack calling linked list
    public Stack() {
        stack = new LinkedList<>();
    }

    //returns link list object which stores stack elements
    public LinkedList<E> getStack() {
        return stack;
    }

    //setting link list object that stores the stack elements
    public void setStack(LinkedList<E> stack) {
        this.stack = stack;
    }

    //push method adds element to the top of the stack
    public void push(E data) {
//        stack.add(data);
    }

    //pop method removes removes tail of the stack and replaces it on top
    public E pop() {
        return (E) stack.removeFromTail();
    }

    //print method to print elements of the stack in the order they are stored
    public void printStack() {
        stack.printLinkedList();
    }

    //get size metho to return the size of the stack element in the stack
    public int getSize() {
        return stack.size;
    }

    //supposed to check if the stack is empty
    public boolean isEmpty() {
        return (stack.size == 0);
    }

}
