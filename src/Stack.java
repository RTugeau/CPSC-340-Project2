/**
 * Stack class that will be implemented by the AStack
 */
public interface Stack { // Stack class ADT
    /**
     * Reinitialize the stack.
     */
    public void clear();

    // Push "it" onto the top of the stack
    /**
     * Push "it" onto the top of the stack
     * @param it
     * @return
     */
    public boolean push(Object it);

    // Remove and return the element at the top of the stack
    /**
     * Remove and return the element at the top of the stack
     * @return
     */
    public Object pop();

    // Return a copy of the top element
    /**
     * Return a copy of the top element
     * @return
     */
    public Object topValue();

    // Return the number of elements in the stack
    /**
     * eturn the number of elements in the stack
     * @return
     */
    public int length();

    // Return true if the stack is empty
    /**
     * Return true if the stack is empty
     * @return
     */
    public boolean isEmpty();
}
