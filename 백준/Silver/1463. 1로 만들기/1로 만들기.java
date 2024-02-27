import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 3으로 만드는 방법 
 * 1, 다른 1, 2로 1을 만드는 방법 2가지
 * 2로 만드는 방법 5가지
 * 3으로 만드는 방법 12가지
 * 4로 만드는 방법 25가지
 * 
 * 3으로 만드는 방법 파파파, 노노노, 파파노, 노노파, 빨파, 빨노, 파빨, 노빨, 파노파, 노파노, 노파파, 노노파
 */

public class Main {
	
	static int answer = 0;
	
	static int dp[] = new int[1000001];
	
	static int b = 1000;
	static int c = 1000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=N; i++) {
			int a = dp[i-1]+1;
			if(i%3==0) {
				b = dp[i/3]+1;
			}
			if(i%2==0) {
				c = dp[i/2]+1;
			}
			answer = Math.min(a, b);
			dp[i] = Math.min(answer, c);
			b = 1000;
			c = 1000;
		}
		
		System.out.println(dp[N]);
	}

}