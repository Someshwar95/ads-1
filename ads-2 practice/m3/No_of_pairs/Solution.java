import java.util.*;
public class Solution {
	public static void main(String[] args) {
		int check=1,count=0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0;i < n; i++ ) {
			a[i] =  sc.nextInt();
			
		}
		Arrays.sort(a);
		for (int i = 0;i < a.length-1;i++) {
			if (a[i] == a[i+1]) {
				check += 1;
			} else {
				count += (check*(check-1))/2;
				check = 1;
			}
		}
		count += (check*(check-1))/2;
		System.out.println("count:"+count);
	}
}