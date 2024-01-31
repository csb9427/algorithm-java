import java.util.Scanner;

// 수 N개가 주어졌을 때 i부터 j까지의 수 합을 구하는 문제이다.
// 수의 개수N개와 합을 구해야 하는 횟수가 주어진다.
// 수는 1000보다 작다.

// 가장 먼저 첫 번째 숫자 만큼 배열을 생성한다.
// 두 번째 숫자를 통해 for문의 횟수를 결정하고 작성한다.
// 배열에 값을 입력받고 난 후 i부터 j까지의 범위를 더해주는 코드를 작성한다.
// 함정 이것도 1부터구만 진짜 화난다.

public class Main {

	static int a;
	static int b;
	static int [] arr;
	static int [] sumAll;
	static int [] answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		arr = new int[a];
		sumAll = new int[a];
		answer = new int[b];
		for(int i=0; i<a; i++) {
			arr[i] = sc.nextInt();
		}
		sumAll[0] = arr[0];
		for(int i=1; i<a; i++) {
			sumAll[i] = arr[i]+sumAll[i-1];
		}
		int sum = 0;
		for(int i=0; i<b; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sum = sumAll[y-1];
			if(x == 1) {
				sum = sum - 0;
			}
			else {
				sum = sum - sumAll[x-2];
			}
			answer[i] = sum;
		}
		for(int i=0; i<b; i++) {
			System.out.println(answer[i]);
		}
	}

}