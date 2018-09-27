import java.util.Scanner;
class Arraymerge {
    /**.
     * Constructs the object.
     */
    Arraymerge() {
    }
    /**.
     * { function_description }
     *
     * @param      c     { parameter_description }
     * @param      d     { parameter_description }
     */
    public void merge(final int[] c, final int[] d) {
    int i = 0,
     j = 0,
     k = 0;
    int p;
    int[] e = new int[c.length + d.length];
    while (i < c.length && j < d.length) {
        if (c[i] < d[j]) {
            e[k++] = c[i++];
        } else {
            e[k++] = d[j++];
        }
    }
    while (i < c.length) {
        e[k++] = c[i++];
    }
    while (j < d.length) {
        e[k++] = d[j++];
    }
    while (c.length == 0) {
        for (p = 0; p < c.length; p++) {
        System.out.print(c[p] + ",");
    }
    System.out.print(c[p]);

    }
    for (p = 0; p < k - 1; p++) {
        System.out.print(e[p] + ",");
    }
    System.out.print(e[p]);
    }
}
/**.
 * { item_description }
 */
final class Solution {
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
        Arraymerge two = new Arraymerge();
        Scanner s = new Scanner(System.in);
        int size1 = s.nextInt();
        int size2 = s.nextInt();
        int[] intarray1 = new int[size1];
        int[] intarray2 = new int[size2];
        int i = 0;
        int j = 0;
        s.nextLine();
        String[] firstarr = s.nextLine().split(",");
        String[] secondarr = s.nextLine().split(",");
        if (intarray1.length == 0) {
            for (String str2 : secondarr) {
                intarray2[j++] = Integer.parseInt(str2);
            }
            int h;
            for (h = 0; h < size2 - 1; h++) {
                System.out.print(intarray2[h] + ",");
            }
            System.out.print(intarray2[h]);
        } else {
            for (String str1 : firstarr) {
                intarray1[i++] = Integer.parseInt(str1);
        }
            for (String str2 : secondarr) {
                intarray2[j++] = Integer.parseInt(str2);
        }
            two.merge(intarray1, intarray2);
        }
}
}