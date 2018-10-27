import java.util.*;
class StudentData {
	private int n;
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
		Scanner sc = new Scanner(System.in);
		int roll_number = sc.nextInt();
		String student_name = sc.nextLine();
		double total_marks = sc.nextDouble();
		if (total_marks >= 70.32 || total_marks <= 60.0) {
			System.out.println(student_name);
			
		}

	}
}