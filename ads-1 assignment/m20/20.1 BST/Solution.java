import java.util.Scanner;
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
        BST<String, Integer> st = new
        BST<String, Integer>();
        while (scan.hasNextLine()) {
            String l = scan.nextLine();
            if (l.length() == 0) {
                break;
            }
            String[] str = l.split(",");
            String sub = "";
            switch (str[0]) {
            case "put":
                sub = str[1] + ", " + str[2] + ", "
                      + Double.parseDouble(str[2 + 1]);
                st.put(sub, Integer.parseInt(str[2 + 2]));
                break;
            case "get":
                sub = str[1] + ", " + str[2] + ", "  + str[2 + 1];
                System.out.println(st.get(sub));
                break;
            case "min":
                System.out.println(st.min());
                break;
            case "max":
                System.out.println(st.max());
                break;
            case "floor":
                sub = str[1] + ", " + str[2] + ", "
                      + Double.parseDouble(str[2 + 1]);
                System.out.println(st.floor(sub));
                break;
            case "ceiling":
                sub = str[1] + ", " + str[2] + ", "
                      + Double.parseDouble(str[2 + 1]);
                System.out.println(st.ceiling(sub));
                break;
            case "deleteMin":
                st.deleteMin();
                break;
            case "deleteMax":
                st.deleteMax();
                break;
            case "delete":
                sub = str[1] + ", " + str[2] + ", "
                      + Double.parseDouble(str[2 + 1]);
                st.delete(sub);
                break;
            case "select":
                System.out.println(st.select(Integer.parseInt(str[1])));
                break;
            default:
                break;
            }
        }
    }
}