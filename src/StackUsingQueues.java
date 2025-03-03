//import java.util.LinkedList;
//import java.util.Queue;
//
//class StackQueues {
//    private Queue<Integer> queue1;
//    private Queue<Integer> queue2;
//
//    public StackQueues() {
//        this.queue1 = new LinkedList<>();
//        this.queue2 = new LinkedList<>();
//    }
//
//    // Insert element data to the top of the stack.
//    public void push(int data) {
//        // Move all elements from queue1 to queue2
//        while (!queue1.isEmpty()) {
//            queue2.offer(queue1.poll());
//        }
//
//        // Enqueue the new element to queue1
//        queue1.offer(data);
//
//        // Move all elements back from queue2 to queue1
//        while (!queue2.isEmpty()) {
//            queue1.offer(queue2.poll());
//        }
//    }
//
//    // Remove and return the element from the top of the stack.
//    public int pop() {
//        if (isEmpty()) {
//            LOGGER.info("Stack is empty");
//            return -1; // You can choose a different way to handle this scenario
//        }
//        return queue1.poll();
//    }
//
//    // Return the element on the top of the stack.
//    public int top() {
//        if (isEmpty()) {
//            LOGGER.info("Stack is empty");
//            return -1; // You can choose a different way to handle this scenario
//        }
//        return queue1.peek();
//    }
//
//    // Check if the stack is empty.
//    public boolean isEmpty() {
//        return queue1.isEmpty();
//    }
//}
//
//public class StackUsingQueues {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorOperations.class);
//    public static void main(String[] args) {
//        StackQueues stack = new StackQueues();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//
//        LOGGER.info("Top element: " + stack.top()); // Output: 3
//        LOGGER.info("Is stack empty? " + stack.isEmpty()); // Output: false
//
//        LOGGER.info("Popped element: " + stack.pop()); // Output: 3
//
//        LOGGER.info("Top element after pop: " + stack.top()); // Output: 2
//        LOGGER.info("Is stack empty? " + stack.isEmpty()); // Output: false
//    }
//}
