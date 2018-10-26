import java.util.NoSuchElementException;
/**.
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BST<Key extends Comparable<Key>, Value> {
    /**.
     * { var_description }
     */
    private Node root;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private Key key;
        /**.
         * { var_description }
         */
        private Value val;
        /**.
         * { var_description }
         */
        private Node left, right;
        /**.
         * { var_description }
         */
        private int size;
        /**.
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      sz    The size
         */
        Node(final Key k, final Value v, final int sz) {
            this.key = k;
            this.val = v;
            this.size = sz;
        }
    }
    /**.
     * Constructs the object.
     */
    BST() {
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * { method of BST }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    /**.
     * { method of BST }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    private Value get(final Node x, final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }
    /**.
     * { method of BST }
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls put() with a null key");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    /**.
     * { function_description }
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val   = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**.
     * { method of BST }
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Symbol table underflow");
        }
        root = deleteMin(root);
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     *
     * @return     { respective return value }
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**.
     * { method of BST }
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Symbol table underflow");
        }
        root = deleteMax(root);
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     *
     * @return     { respective return value }
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**.
     * { method of BST }
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls delete() with a null key");
        }
        root = delete(root, key);
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    private Node delete(final Node x, final Key key) {
        Node temp = x;
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
            x.left  = delete(x.left,  key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left  == null) {
                return x.right;
            }
            Node t = x;
            temp = min(t.right);
            temp.right = deleteMin(t.right);
            temp.left = t.left;
        }
        temp.size = size(temp.left) + size(temp.right) + 1;
        return temp;
    }
    /**.
     * { method of BST }
     * @return     { respective return value }
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls min() with empty symbol table");
        }
        return min(root).key;
    }

    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     *
     * @return     { respective return value }
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**.
     * { method of BST }
     * @return     { respective return value }
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls max() with empty symbol table");
        }
        return max(root).key;
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     *
     * @return     { respective return value }
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**.
     * { method of BST }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to floor() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**.
     * { method of BST }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to ceiling() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls ceiling() with empty symbol table");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    private Node ceiling(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**.
     * { method of BST }
     * @param      k     { parameter_description }
     *
     * @return     { respective return value }
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { respective return value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if      (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else  {
            return x;
        }
    }
    /**.
     * { method of BST }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { respective return value }
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
    /**.
     * { method of BST }
     * @return     { respective return value }
     */
    public int size() {
        return size(root);
    }
    /**.
     * { method of BST }
     * @param      x     { parameter_description }
     *
     * @return     { respective return value }
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**.
     * { method of BST }
     * @param      key   The key
     *
     * @return     { respective return value }
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        return rank(key, root);
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int rank(final Key key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
}