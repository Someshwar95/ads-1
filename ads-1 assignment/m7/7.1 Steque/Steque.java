/**.
 * Class for steque.
 */
class Steque {
    private Node first, last;
    private int size;
    /**.
     * Class for node.
     */
    private class Node {
        private String item;
        private Node next;
    }
    /**.
     * Constructs the object.
     */
    Steque() {
        first = null;
        last = null;
        size = 0;
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() { //complexity is of 1 as it will run only for 1 time.
        return (size == 0);
    }
    /**.
     * Makes an empty.
     */
    public void makeEmpty() {
        first.next = null;;
        last.next = null;
    }
    /**.
     * Gets the size.
     * @return     The size.
     */
    public int getSize() { //complexity is of 1 as it will run only for 1 time.
        return size;
    }
    /**.
     * pushing at the front.
     * @param      int1  The int 1
     */
    public void push(final String int1) {
        Node oldfirst = first;
        first = new Node();
        first.item = int1;
        first.next = oldfirst;
        if (first.next == null) {
            last = first;
        }
        size++;
    }
    /**.
     * pushing at last by enqueue method.
     * @param      item1  The item 1
     */
    public void enqueue(final String item1) {
        if (last == null || first == null) {
            push(item1);
        } else {
            Node temp = new Node();
            temp.item = item1;
            temp.next = null;
            last.next = temp;
            last = temp;
            size++;
        }
    }
    /**.
     * popping elements from the end.
     */
    public void pop() {
        if (first != null) {
            first = first.next;
            size--;
        }
    }
    /**.
     * printing elements of Stqueue.
     * @return     { String form of Stqueue }.
     * 
     */
    public String print() {
        if (size == 0) {

            return "Steque is empty.";
        }
        Node temp = first;
        String str = "";
        while (temp.next != null) {
            str += temp.item + ", ";
            temp = temp.next;
        }
        str += temp.item;
        return str;
    }
}