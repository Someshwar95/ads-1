import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
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
        Scanner sc = new Scanner(System.in);
        int numOfvalues = sc.nextInt();
        MinPQ<Float> minpq = new MinPQ<Float>(numOfvalues);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(numOfvalues);
        double median = 0.0;
        while (sc.hasNext()) {
            for (int i = 0; i < numOfvalues; i++) {
                float value = sc.nextFloat();
                if (value > median) {
                    minpq.insert(value);
                } else {
                    maxpq.insert(value);
                }
                if (maxpq.size() - minpq.size() > 1) {
                    float value1 = maxpq.delMax();
                    minpq.insert(value1);
                } else if (minpq.size() - maxpq.size() > 1) {
                    float value1 = minpq.delMin();
                    maxpq.insert(value1);
                }
                if (maxpq.size() == minpq.size()) { median = (minpq.min() + maxpq.max()) / 2; }
                else if (maxpq.size() > minpq.size()) {
                    median = maxpq.max();
                }
                else {
                    median = minpq.min();
                }
                System.out.println(median);
            }
        }
    }
}

