import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
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
class Merit {
	private ArrayList<Reservation> list;
	Merit() {
		list = new ArrayList<Reservation>();
	}
	public int compareTo(Reservation firstStudent, Reservation secondStudent) {
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
	public void addTo(Reservation obj) {
		list.add(obj);
	}
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