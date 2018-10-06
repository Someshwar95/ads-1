import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**.
 * Class for reservation.
 */
class Reservation {
    /**.
     * { var_description }
     */
    private String studentName;
    /**.
     * { var_description }
     */
    private int dateofbirth;
    /**.
     * { var_description }
     */
    private int subject1marks;
    /**.
     * { var_description }
     */
    private int subject2marks;
    /**.
     * { var_description }
     */
    private int subject3marks;
    /**.
     * { var_description }
     */
    private int totalmarks;
    /**.
     * { var_description }
     */
    private String reservationCategory;
    /**.
     * Constructs the object.
     *
     * @param      name       The name
     * @param      dob        The dob
     * @param      sub1marks  The sub 1 marks
     * @param      sub2marks  The sub 2 marks
     * @param      sub3marks  The sub 3 marks
     * @param      totlmarks  The totlmarks
     * @param      category   The category
     */
    Reservation(final String name, final int dob, final int sub1marks, final int sub2marks,
        final int sub3marks, final int totlmarks, final String category) {
        studentName = name;
        dateofbirth = dob;
        subject1marks = sub1marks;
        subject2marks = sub2marks;
        subject3marks = sub3marks;
        totalmarks = totlmarks;
        reservationCategory = category;
    }
    /**.
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return studentName;
    }
    /**.
     * Gets the dateofbirth.
     *
     * @return     The dateofbirth.
     */
    public int getDateofbirth() {
        return dateofbirth;
    }
    /**.
     * Gets the subj 1 marks.
     *
     * @return     The subj 1 marks.
     */
    public int getSubj1marks() {
        return subject1marks;
    }
    /**.
     * Gets the subj 2 marks.
     *
     * @return     The subj 2 marks.
     */
    public int getSubj2marks() {
        return subject2marks;
    }
    /**.
     * Gets the subj 3 marks.
     *
     * @return     The subj 3 marks.
     */
    public int getSubj3marks() {
        return subject3marks;
    }
    /**.
     * Gets the ttlmarks.
     *
     * @return     The ttlmarks.
     */
    public int getTtlmarks() {
        return totalmarks;
    }
    /**.
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return reservationCategory;
    }
}
/**.
 * Class for merit.
 */
class Merit {
    /**.
     * { var_description }
     */
    private ArrayList<Reservation> list;
    /**.
     * Constructs the object.
     */
    Merit() {
        list = new ArrayList<Reservation>();
    }
    /**.
     * { function_description }
     *
     * @param      firstStudent   The first student
     * @param      secondStudent  The second student
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Reservation firstStudent, final Reservation secondStudent) {
        if (firstStudent.getTtlmarks() < secondStudent.getTtlmarks()) {
            return -1;
        } else if (firstStudent.getTtlmarks() > secondStudent.getTtlmarks()) {
            return 1;
        } else {
            if (firstStudent.getSubj1marks() < secondStudent.getSubj1marks()) {
                return -1;
            } else if (firstStudent.getSubj1marks() > secondStudent.getSubj1marks()) {
                return 1;
            } else {
                if (firstStudent.getSubj2marks() < secondStudent.getSubj2marks()) {
                    return -1;
                } else if (firstStudent.getSubj2marks() > secondStudent.getSubj2marks()) {
                    return 1;
                } else {
                    if (firstStudent.getSubj3marks() < secondStudent.getSubj3marks()) {
                        return -1;
                    } else if (firstStudent.getSubj3marks() > secondStudent.getSubj3marks()) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    /**.
     * Adds to.
     *
     * @param      obj   The object
     */
    public void addTo(Reservation obj) {
        list.add(obj);
    }
    /**.
     * { function_description }
     */
    public void sorting() {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            max = i;
            for (int j = i + 1; j < list.size(); j++) {
                flag = compareTo(list.get(max), list.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list, i, max);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String print() {
        String str = "";
        for (int i = 0; i < list.size() - 1; i++) {
            str += list.get(i).getName() + ",";
        }
        str += list.get(list.size() - 1).getName();
        return str;
    }
}
/**.
 * { item_description }
 */
final class Solution {
    public static void main(String[] args) {
        Reservation obj;
        //final int six = 6;
        Merit object = new Merit();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            obj = new Reservation(tokens[0],
                           Integer.parseInt(tokens[1]),
                           Integer.parseInt(tokens[2]),
                           Integer.parseInt(tokens[3]),
                           Integer.parseInt(tokens[4]),
                           Integer.parseInt(tokens[5]),
                           (tokens[6]));
            object.addTo(obj);
        }
        object.sorting();
        System.out.println(object.print());
    }
}