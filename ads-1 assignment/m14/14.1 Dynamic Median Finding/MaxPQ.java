import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**.
 * Class for maximum pq.
 *
 * @param      <Key>  The key
 */
public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;        
    private int n;             
    private Comparator<Key> comparator;
    /**.
     * Constructs the object.
     *
     * @param      inItCapacity  In iterator capacity
     */
    public MaxPQ(int inItCapacity) {
        pq = (Key[]) new Object[inItCapacity + 1];
        n = 0;
    }
    /**.
     * Constructs the object.
     */
    public MaxPQ() {
        this(1);
    }
    /**.
     * Constructs the object.
     *
     * @param      inItCapacity  In iterator capacity
     * @param      comparator    The comparator
     */
    public MaxPQ(int inItCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[inItCapacity + 1];
        n = 0;
    }
    /**.
     * Constructs the object.
     *
     * @param      comparator  The comparator
     */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**.
     * Constructs the object.
     *
     * @param      keys  The keys
     */
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    /**.
     * { function_description }
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**.
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    /**.
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**.
     * Determines if maximum heap.
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }
    /**.
     * Determines if maximum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    /**.
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Key>(size());
            else                    copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty(); 
        }
        /**.
         * { function_description }
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**.
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}