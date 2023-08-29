package QuestionOne;

/**
 * @author Dev
 * @param <E>
 */
public class LinkedList<E extends Comparable> {

    //initializing variable size and head as the first node private
    public int size;
    private Node<E> head; //including with element

    //default constructor to initialize head as null and size as zero
    public LinkedList() {
        head = null;
        size = 0;
    }

    //constructor for linked list class that will take the size and head as the arguements
    public LinkedList(int size, Node<E> head) {
        this.size = size;
        this.head = head;
    }

    //add head method where new node is added with the given data at the very beginning of the list
    public void addHead(E data) {
        Node newNode = new Node();

        newNode.setNext(head);

        head = newNode;
        size++;
    }

    //get head method which returns the head of node
    public Node getHead() {
        return head;
    }

    //add method where adds new node with every given data at end of list
    public void add(E data) {

        Node<E> newNode = new Node();
        newNode.setData(data);

        //if method list is empty then make the new node as the head node
        if (size == 0) {
            head = newNode;
        } else { //otherwise
            //traverse the list to find the last node in the list
            Node<E> currentNode = head;
            for (int i = 1; i < size; i++) {
                currentNode = currentNode.getNext();
            }
            //this method will link the new node to the last node
            currentNode.setNext(newNode);
        }
        //incrementing size
        size++;
    }

    //this method prints the elements of the link list
    public void printLinkedList() {
        printLinkedList(head); //prints the element of head node
    }

    //this is the recursive method that prints the elements of the link list from given node
    private void printLinkedList(Node node) {
        if (node == null) { //if node is null
            System.out.println(); //then print
        } else { //otherwise
            System.out.println(node.getData()); //print node and get the data
            printLinkedList(node.getNext()); //calls printlinklist method to the node which gets the next
        }
    }

    //contains method which calls the private method made below and returns true if the given node is present in linked list
    public boolean contains(Node node) {
        return contains(head, node);
    }

    //private contains method that searches for the given node starting at the given head node
    private boolean contains(Node head, Node node) {
        if (head == null) { //if head is null
            return false; //returns false
        } else if (head.equals(node)) { //otherwise if the head node is equal to the searched node then,,,
            return true; //return true
        } else { //or else 
            return contains(head.getNext(), node); //returns and searches next node and returns that
        }
    }

    //remove method containing node which removes a certain method from the linked list
    public void remove(Node node) {

        Node<E> currentNode = head;
        Node<E> prevNode = currentNode;

        //traverse the linked list till it reaches the very end
        while (currentNode.getNext() != null) {
            if (currentNode.equals(node)) { //if the current node matches then it can be removed if needed to
                prevNode.next = currentNode.next;
                size--; //decrements size
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    //remove method a node at a specific positition within the linked list
    public void remove(int position) { 
        Node<E> currentNode = head;

        for (int i = 0; currentNode.next != null && 1 < position; i++) { //traversing the linked list until the part is reached
            currentNode = currentNode.next;

            //if the part has been reached then remove the node
            if (i == position) {
                currentNode.next = currentNode.next.next;
            }
        }
        size--; //decrements size
    }

    //remove the head method for removing first node if needed
    public E removeFromHead() {

        //if the link list is empty then return null
        if (head == null) {
            return null;
        }

        //
        Node<E> removeNode = head;
        //setting the head to the next node 
        head = head.getNext();
        size--;
        
        //returns removed node
        return removeNode.getData();
    }

    //remove tail method that removes the last node if needed
    public Node removeFromTail() {
        
        //if the head node is null then return null
        if (head == null) {
            return null;
        }

        Node<E> currentNode = head;
        Node<E> removeNode = currentNode;

        //if there is one node in the link list then remove the node
        if (currentNode.getNext() == null) {
            removeNode = head;
            head = null;
            size--; //decrements the size
            return removeNode;
        }

        //while loop for traversing link list until the seconed to last node has been reached
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        
        //remove the last node
        removeNode = currentNode.getNext();
        currentNode.setNext(null);
        size--; //decrements the dsize
        return removeNode;
    }

    //add in order method to add node to the link list in order
    public void addInOrder(E data) {
        Node<E> newNode = new Node();
        newNode.setData(data);

        //if head node is empty then set head to the new node
        if (head == null) {
            head = newNode;
            size++;
        } else if (newNode.compareTo(head) > 0) { // otherwise if the new node is smaller than head then addit to the beginnning of the list
            newNode.setNext(head);
            head = newNode;
            size++; //increments size
        }

        Node currentNode = head;

        //iterating though the list to find the correct position of the new node in the list
        while (currentNode.getNext() != null && newNode.compareTo(currentNode.getNext()) >= 0) {
            currentNode = currentNode.getNext();
        }
        
        //insert new node into the correct order of the list
        newNode.setNext((Node<E>) currentNode.getNext());
        currentNode.setNext(newNode);
        size++; //increments size
    }

    //get node method 
    public Node getNode(int index) {

        //creates a new node to represent the current node starts the head of the list
        Node currentNode = new Node();
        currentNode = head;
        int i = 0;

        //iterates through the list until the indexed is reached till the end
        while (i < index && currentNode != null) {
            currentNode = currentNode.getNext();
            i++; //increment i
        }

        //if index is less than 0 then return null
        if (index < 0) {
            return null;
        } else { //otherwise return the current node
            return currentNode;
        }
    }

    //get data method including index integer
    public E getData(int index) {

        //new node to represent the current node
        Node<E> currentNode = head;

        //for loop to iterate through the list until index reached the end
        for (int i = 0; i < index && currentNode != null; i++) {
            currentNode = currentNode.getNext();
        }

        //if the current node is equel to null then
        if (currentNode == null) {
            return null; //return null
        }
        return currentNode.getData(); //returns the node first gets data then returns
    }

}
