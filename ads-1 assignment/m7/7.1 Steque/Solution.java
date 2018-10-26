import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        while (num1 >= 0) {
            Steque st = new Steque();
            while (scan.hasNextLine()) {
                String line =  scan.nextLine();
                String[] command = line.split(" ");
                switch (command[0]) {
                case "push":
                    st.push(command[1]);
                    System.out.println(st.print());
                    break;
                case "enqueue":
                    st.enqueue(command[1]);
                    System.out.println(st.print());
                    break;
                case "pop":
                    st.pop();
                    System.out.println(st.print());
                    break;
                default:
                    break;
                }
                if (line.equals("")) {
                    System.out.println();
                    break;
                }
            }
            num1--;
        }
    }
}