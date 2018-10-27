import java.util.Scanner;
class StudentData {
	private int roll_number;
	private String student_name;
	private double total_marks;
	StudentData(int rollnumber, String studentname, double totalmarks) {
		roll_number = rollnumber;
		student_name = studentname;
		total_marks = totalmarks;
	}
	public int getRollnumber() {
		return roll_number;
	}
	public String getStudentname() {
		return student_name;
	}
	public double getTotalmarks() {
		return total_marks;
	}
}
class Solution {
	public static void main(String[] args) {
		
	}
}