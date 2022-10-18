import java.util.NoSuchElementException;

// Linked list implementation
/**
 * Linked list implementation of the list class
 */
public class LList implements List {
    private Link head;         // Pointer to list header
    private Link tail;         // Pointer to last element
    private Link curr;         // Access to current element
    private int listSize;      // Size of list

    // Constructors
    /**
     * Constructors
     * @param size
     */
    LList(int size) { this(); }     // Constructor -- Ignore size
    /**
     * constructor ignores the size
     */
    LList() { clear(); }

    // Remove all elements
    /**
     * remove all elements in list
     */
    public void clear() {
        curr = tail = new Link(null); // Create trailer
        head = new Link(tail);        // Create header
        listSize = 0;
    }

    // Insert "it" at current position
    /**
     * insert the object at a certain position
     * @param it
     * @return
     */
    public boolean insert(Object it) {
        curr.setNext(new Link(curr.element(), curr.next()));
        curr.setElement(it);
        if (tail == curr) {
            tail = curr.next();  // New tail
        }
        listSize++;
        return true;
    }

    // Append "it" to list
    /**
     * appends the object to the list
     * @param it
     * @return
     */
    public boolean append(Object it) {
        tail.setNext(new Link(null));
        tail.setElement(it);
        tail = tail.next();
        listSize++;
        return true;
    }

    // Remove and return current element
    /**
     * remove and return current element
     * @return
     * @throws NoSuchElementException
     */
    public Object remove () throws NoSuchElementException {
        if (curr == tail) {// Nothing to remove
            throw new NoSuchElementException("remove() in LList has current of " + curr + " and size of "
                    + listSize + " that is not a a valid element");
        }
        Object it = curr.element();             // Remember value
        curr.setElement(curr.next().element()); // Pull forward the next element
        if (curr.next() == tail) {
            tail = curr;   // Removed last, move tail
        }
        curr.setNext(curr.next().next());       // Point around unneeded link
        listSize--;                             // Decrement element count
        return it;                              // Return value
    }


    /**
     * set curr at list start
     */
    public void moveToStart() { curr = head.next(); } // Set curr at list start

    /**
     * set curr at list end
     */
    public void moveToEnd() { curr = tail; }          // Set curr at list end

    // Move curr one step left; no change if now at front
    /**
     * move curr one step to the left and no change
     * if at front
     */
    public void prev() {
        if (head.next() == curr) {
            return; // No previous element
        }
        Link temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    // Move curr one step right; no change if now at end
    /**
     * move curr one step right and no change if now at end
     */
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }

    /**
     * return the list length
     * @return
     */
    public int length() { return listSize; } // Return list length


    // Return the position of the current element
    /**
     * return the position of the current element
     * @return
     */
    public int currPos() {
        Link temp = head.next();
        int i;
        for (i=0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    // Move down list to "pos" position
    /**
     * Move down list to position
     * @param pos
     * @return
     */
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) {
            return false;
        }
        curr = head.next();
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        return true;
    }

    // Return true if current position is at end of the list
    /**
     * Return true if current position is at end of the list
     * @return
     */
    public boolean isAtEnd() { return curr == tail; }

    // Return current element value.
    /**
     * return current element value
     * @return
     * @throws NoSuchElementException
     */
    public Object getValue() throws NoSuchElementException {
        if (curr == tail) {// No current element
            throw new NoSuchElementException("getvalue() in LList has current of " + curr
                    + " and size of " + listSize + " that is not a a valid element");
        }
        return curr.element();
    }

    // Check if the list is empty
    /**
     * check if the list is empty
     * @return
     */
    public boolean isEmpty() { return listSize == 0; }
}
