import java.util.Scanner;
/**.
 * List of linkeds.
 */
class LinkedList {
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private char value;
        /**.
         * { var_description }
         */
        private Node nextaddr;
    }
    /**.
     * { var_description }
     */
    private Node first = null;
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    public void push(final char item) {
        Node temp = new Node();
        temp.value = item;
        temp.nextaddr = first;
        first = temp;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public char pop() {
        char value = first.value;
        first = first.nextaddr;
        return  value;
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return  first == null;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public char top() {
        return first.value;
    }
}
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String str = scan.next();
            if (paranthesis(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    /**.
     * { function_description }
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static boolean paranthesis(final String str) {
        LinkedList lst = new LinkedList();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                lst.push(ch);
            } else {
                if (lst.isEmpty()) {
                    return false;
                }
                if (ch == '}' && lst.top() == '{') {
                    lst.pop();
                } else if (ch == ']' && lst.top() == '[') {
                    lst.pop();
                } else if (ch == ')' && lst.top() == '(') {
                    lst.pop();
                } else {
                    return false;
                }

            }
        }
        return lst.isEmpty();
    }
}



