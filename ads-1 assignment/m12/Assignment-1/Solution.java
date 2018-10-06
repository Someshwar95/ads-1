import java.util.Scanner;
import java.util.ArrayList;
class Reservation {
	private String studentName;
	private int dateofbirth;
	private int subject1marks;
	private int subject2marks;
	private int subject3marks;
	private int totalmarks;
	private String reservationCategory;
	Reservation(String name, int dob, int sub1marks, int sub2marks, int sub3marks, int totlmarks, String category) {
		studentName = name;
		dateofbirth = dob;
		subject1marks = sub1marks;
		subject2marks = sub2marks;
		subject3marks = sub3marks;
		totalmarks = totlmarks;
		reservationCategory = category;
	}
	public String getName() {
		return studentName;
	}
	public int getDateofbirth() {
		return dateofbirth;
	}
	public int getSubj1marks() {
		return subject1marks;
	}
	public int getSubj2marks() {
		return subject2marks;
	}
	public int getSubj3marks() {
		return subject3marks;
	}
	public int getTtlmarks() {
		return totalmarks;
	}
	public String getCategory() {
		return reservationCategory;
	}
}
class Display {
	private ArrayList<Reservation> list;
	Display() {
		list = new ArrayList<Reservation>();
	}
	//public int compareTo(Reservation )
}
