import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * N번 집이 순서대로 있다. 처음을 1로 잡고 계속 낮은 것만 찾아서 더하기 순서가 꼬이
 */

public class Main {
	
	static int N, answer;
	
	static int sum[][];
	
	static int a[];
	static int b[];
	static int c[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a = new int[N+1];
		b = new int[N+1];
		c = new int[N+1];
		
		sum = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				sum[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=N; i++) {
			a[i] = Math.min(c[i-1], b[i-1]) + sum[i][0];
			b[i] = Math.min(a[i-1], c[i-1]) + sum[i][1];
			c[i] = Math.min(a[i-1], b[i-1]) + sum[i][2];
		}
		answer = Math.min(Math.min(a[N], c[N]), b[N]);
		
		System.out.println(answer);
		
	}
	
}