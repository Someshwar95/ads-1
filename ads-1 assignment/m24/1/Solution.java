/**.
 * Class for student data.
 */
class StudentData {
    /**.
     * { var_description }
     */
    private int n;
    /**.
     * { var_description }
     */
    private int roll_number;
    /**.
     * { var_description }
     */
    private String student_name;
    /**.
     * { var_description }
     */
    private double total_marks;
    /**.
     * Constructs the object.
     *
     * @param      rollnumber   The rollnumber
     * @param      studentname  The studentname
     * @param      totalmarks   The totalmarks
     */
    StudentData(int rollnumber, String studentname, double totalmarks) {
        roll_number = rollnumber;
        student_name = studentname;
        total_marks = totalmarks;
    }
    /**.
     * Gets the rollnumber.
     *
     * @return     The rollnumber.
     */
    public int getRollnumber() {
        return roll_number;
    }
    /**.
     * Gets the studentname.
     *
     * @return     The studentname.
     */
    public String getStudentname() {
        return student_name;
    }
    /**.
     * Gets the totalmarks.
     *
     * @return     The totalmarks.
     */
    public double getTotalmarks() {
        return total_marks;
    }
}
/**.
 * Class for solution.
 */
class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        
    }
}