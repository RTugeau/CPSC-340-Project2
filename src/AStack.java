/**
 * This class implements the Stack class to manipulate
 * the stack that you are wanting to build and adjust
 *
 * @version (10-17-2022)
 * @author Cole, Riley
 */
class AStack implements Stack {
    private Object[] stackArray;    // Array holding stack
    private static final int DEFAULT_SIZE = 10;
    private int maxSize;            // Maximum size of stack
    private int top;                // First free position at top

    /**
     * constructors to call
     * and initiate the variables
     * @param size
     *  return size
     */
    AStack(int size) {
        maxSize = size;
        top = 0;
        stackArray = new Object[size]; // Create stackArray
    }

    /**
     * constructor that makes the default size
     */
    AStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * this clears that stack and reinitializes it
     */
    public void clear() {
        top = 0;
    }    // Reinitialize stack

    // Push "it" onto stack
    /**
     * this will push the variable you want to the
     * top of the stack
     * @param it
     *  the object sent in
     * @return
     *  returns true if it can push
     */
    public boolean push(Object it) {
        if (top >= maxSize) {
            return false;
        }
        stackArray[top++] = it;
        return true;
    }

    // Remove and return top element
    /**
     * this will pop the object off the top of the stack
     * @return
     * returns the stack after the top is popped
     */
    public Object pop() {
        if (top == 0) {
            return null;
        }
        return stackArray[--top];
    }

    /**
     * returns the top value of the stack
     * @return
     *  sends back the top value
     */
    public Object topValue() {          // Return top element
        if (top == 0) {
            return null;
        }
        return stackArray[top - 1];
    }

    /**
     * gets the length of the stack
     * @return
     *  returns stack size
     */
    public int length() {
        return top;
    } // Return stack size

    /**
     * checks to see if the stack is empty
     * @return
     *  returns true if empty
     */
    public boolean isEmpty() {
        return top == 0;
    } // Check if the stack is empty
}
