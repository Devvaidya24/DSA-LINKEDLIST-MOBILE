package QuestionOne;

/**
 * @author Dev
 * @param <E>
 */
//public generic class node where E is a generic type which extends to comparable
public class Node<E extends Comparable> {

    //instance variables for data and for the new node
    public E data;
    public Node<E> next;

    //default constructor which initializes data and next nodes as null
    public Node() {
        this.data = null;
        this.next = null;
    }
    
    //get method to return data
    public E getData() {
        return data;
    }

    //set method for data
    public void setData(E data) {
        this.data = data;
    }

    //get method for the next node that returns next
    public Node<E> getNext() {
        return next;
    }

    //set method for next node element
    public void setNext(Node<E> next) {
        this.next = next;
    }

    //public constructor with parameters for data and reference to the new node
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    //equals method to compare data of the two nodes if equal
    public boolean equals(Node node) {
        if (node == null) {
            return false;
        } else {
            return this.data.equals(node.data);
        }
    }

    //compare method to compare data of the two nodes
    public int compareTo(Node node) {
        String x, y;
        
        x = this.data.toString();
        y = node.data.toString();
        
        return x.compareTo(y);
    }
}
