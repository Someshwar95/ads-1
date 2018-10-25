import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }
     *
     * @param      list  The list
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int taxinumber(final ArrayList<CubeSum> list,
                          final int n, final int m) {
        int i = 0, k = n;
        int res = 0;
        while (k > 0 && i < list.size() - m + 1) {
            ArrayList<CubeSum> sublist =
                new ArrayList<CubeSum>(list.subList(i, i + m));
            i++;
            HashSet<Integer> set = new HashSet<Integer>();
            for (CubeSum each : sublist) {
                set.add(each.getsum());
            }
            if (set.size() == 1) {
                res = sublist.get(0).getsum();
                k--;
            }
        }
        return res;
    }
    /**.
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        final int num = 525;
        Scanner sc = new Scanner(System.in);
        ArrayList<CubeSum> cubelist = new ArrayList<CubeSum>();
        MinHeap<CubeSum> pq = new MinHeap<CubeSum>();
        for (int i = 1; i <= num; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            cubelist.add(s);
            if (s.getj() < num) {
                pq.insert(new CubeSum(s.geti(), s.getj() + 1));
            }
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(taxinumber(cubelist, n, m));
    }
}
/**.
 * Class for CubeSum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**.
     * sum variable.
     */
    private final int sum;
    /**.
     * int i variable.
     */
    private  final int i;
    /**.
     * int j varibale.
     */
    private final int j;
    /**.
     * Constructs the object.
     *
     * @param      in     { field variable }
     * @param      ja    { field variable }
     */
    CubeSum(final int in, final int ja) {
        this.sum = in * in * in + ja * ja * ja;
        this.i = in;
        this.j = ja;
    }
    /**.
     * get i method.
     *
     * @return     { description_of_the_return_value }
     */
    int geti() {
        return this.i;
    }
    /**.
     * get j method.
     *
     * @return     { description_of_the_return_value }
     */
    int getj() {
        return this.j;
    }
    /**.
     * get sum method.
     *
     * @return     { description_of_the_return_value }
     */
    int getsum() {
        return this.sum;
    }
    /**.
     * @param      that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }

        return 0;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}