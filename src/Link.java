/**
 * Link Class which is used for singly linked list nodes
 */
public class Link {
    /**
     * value for the node and point
     * to the next node in list
     */
    private Object e;
    private Link n;    // Point to next node in list

    /**
     * constructor that takes in the
     * object and linl
     * @param it
     *  object
     * @param inn
     *  link
     */
    Link(Object it, Link inn) {
        e = it;
        n = inn;
    }

    /**
     * constructor that just takes in the link
     * @param inn
     *  link
     */
    Link(Link inn) {
        e = null;
        n = inn;
    }

    /**
     * this gets the objects element and returns it
     * @return
     *  return value
     */
    Object element() {
        return e;
    }

    /**
     * this sets the element object
     * @param it
     *  object taken in
     * @return
     *  returns the set element value
     */
    Object setElement(Object it) {
        return e = it;
    }

    /**
     * returns the next link
     * @return
     *  link
     */
    Link next() {
        return n;
    }

    /**
     * sets the next link
     * @param inn
     *  link
     * @return
     *  returns set next link
     */
    Link setNext(Link inn) {
        return n = inn;
    }
}
