import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[9];
		int sum = 0;
		int c=0, d = 0;
		for(int i=0; i<9; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		Arrays.sort(a);
		sum -=100;
		for(int i=0; i<9; i++) {
			for(int j=1; j<9; j++) {
				if(a[i]+a[j]==sum && i != j) {
					c = a[i];
					d = a[j];
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(a[i]!=c && a[i]!=d) {
				System.out.println(a[i]);
			}
		}
	}
}