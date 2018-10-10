import java.util.Scanner;
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        switch (str) {
            case "String":
            while (n > 0) {
            String[] tokens = sc.nextLine().split(",");
            Priority<String> s = new Priority<String>(tokens);
            System.out.println(s.isMinHeap());
            n--;
                }
                break;
            case "Integer":
            while (n > 0) {
            String[] tokens = sc.nextLine().split(",");
            Integer[] integerTokens = new Integer[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                integerTokens[i] = Integer.parseInt(tokens[i]);
               }
            Priority<Integer> s = new Priority<Integer>(integerTokens);
            System.out.println(s.isMinHeap());
            n--;
                }
                break;
            case "Double":
            while (n > 0) {
            String[] tokens = sc.nextLine().split(",");
            Double[] idTokens = new Double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                idTokens[i] = Double.parseDouble(tokens[i]);
            }
            Priority<Double> s = new Priority<Double>(idTokens);
            System.out.println(s.isMinHeap());
            n--;
                }
        break;
        case "Float":
        while (n > 0) {
        String[] tokens = sc.nextLine().split(",");
        if (tokens[0].equals("")) {
            System.out.println("false");
            break;
        } else {
        Float[] floatTokens = new Float[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
                floatTokens[i] = Float.parseFloat(tokens[i]);
            }
        Priority<Float> s = new Priority<Float>(floatTokens);
        System.out.println(s.isMinHeap());
        n--;
            }
        }
        break;
        default:
        break;
    }

    }
}
/**           
 *
 * Class for priority.
 *
 * @param      <E>   { parameter_description }
 */
class Priority<E extends Comparable<E>> {
    /**
     * @param array array is stored in array.
     *
     **/
    private E[] array;
    /**
     * @param size size.
     **/
    private int size;
    Priority(final E[] arr) {
        this.array = arr;
    }
    public boolean isMinHeap() {
        for (int i = 1; i < array.length; i++) {
            if (2 * i < array.length && greater(2 * i, i)) {
                return false;
            }
            if ((2 * i) + 1 < array.length && greater(2 * i + 1, i)) {
                return false;
            }
        }
        return true;
    }
    public boolean greater(final int i, final int j) {
        return array[i].compareTo(array[j]) < 0;
    }
}