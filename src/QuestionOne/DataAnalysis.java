package QuestionOne;

/**
 * @author Dev
 * @param <E>
 */
public class DataAnalysis<E extends Comparable> {

    //initializing private final queue to store data
    private final Queue<E> queue = new Queue();
    //initializing private final stack to store data
    private final Stack<E> stack = new Stack();
    //array of the data 
    private final E[] data;

    //data anaylsis object with data variable and int i
    public DataAnalysis(E[] data) {
        this.data = data;
        int i = 0;

        //while loop which enqueues every element of data array to the queue and pushes to stack
        while (i < data.length) {
            queue.enqueue(data[i]);
            stack.push(data[i]);
            i++; //increamenting i
        }
    }

    // bracket evaluater if the data array has symmetrical brackets using the queue and stack methid
    public boolean bracketEvaluator() {
        return queue.dequeue() == stack.pop();
    }

    //issymmetrical method that checks if the data array is symmetrical using stack and queue
    public boolean isSymmetrical() {
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.dequeue().compareTo(stack.pop()) < 0) {
                return false;
            }
        }
        return true; //otherwise return true
    }
}
