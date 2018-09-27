import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for solution.
 */
public class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int arrsize = scan.nextInt();
        int[] arr = new int[arrsize];
        int count = 0;
        for (int i = 0; i < arrsize; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int a = 0;
        int b = 0;
        for (int i = 0; i < arrsize; i++) {
            a = i + 1;
            b = arrsize - 1;
            while (a < b) {
                if (arr[i] + arr[a] + arr[b] < 0) {
                    a += 1;
                } else if (arr[i] + arr[a] + arr[b] > 0) {
                    b -= 1;
                } else {
                    a += 1;
                    b -= 1;
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}