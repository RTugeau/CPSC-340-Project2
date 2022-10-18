import java.util.NoSuchElementException;

/**
 * List class ADT
 * @version (10-17-2022)
 * @author Cole, Riley
 */
public interface List {
    /**
     * Remove all contents from the list, so it is once again empty
     */
    public void clear();


    /**
     * Insert "it" at the current location
     * The client must ensure that the list's capacity is not exceeded
     * @param it
     * @return
     */
    public boolean insert(Object it);

    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    /**
     *
     * @param it
     * @return
     */
    public boolean append(Object it);

    // Remove and return the current element
    /**
     * remove and return the current element
     * @return
     * @throws NoSuchElementException
     */
    public Object remove() throws NoSuchElementException;

    // Set the current position to the start of the list
    /**
     * set the current position to the start of the list
     */
    public void moveToStart();

    // Set the current position to the end of the list
    /**
     * set the current position to the end
     */
    public void moveToEnd();

    // Move the current position one step left, no change if already at beginning
    /**
     * move the current position one step right
     */
    public void prev();

    // Move the current position one step right, no change if already at end
    /**
     * move the current position one step right
     */
    public void next();

    // Return the number of elements in the list
    /**
     * return the number of elements in the list
     * @return
     */
    public int length();

    // Return the position of the current element
    /**
     * return the psotion of the current element
     * @return
     */
    public int currPos();

    // Set the current position to "pos"
    /**
     * set the current position
     * @param pos
     * @return
     */
    public boolean moveToPos(int pos);

    // Return true if current position is at end of the list
    /**
     * return true if current position is at end of the list
     * @return
     */
    public boolean isAtEnd();

    // Return the current element
    /**
     * return the current element
     * @return
     * @throws NoSuchElementException
     */
    public Object getValue() throws NoSuchElementException;

    /**
     * check to see if empty
     * @return
     */
    public boolean isEmpty();
}
