import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
	
	static int N;
	
	static int answer[];
	static int answer2[];
	
	static int sum = 0;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N+1];
		answer2 = new int[N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==0) {
				answer[i] = -1;
				answer2[i] = -1;
				for(int j=i-1; j>=1; j--) {
					if(answer2[j]>0) {
						answer2[j] -= 1;
						break;
					}
				}
			}
			else {
				answer[i] = Integer.parseInt(st.nextToken());
				answer2[i] = Integer.parseInt(st.nextToken());
				answer2[i] -= 1;
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(answer2[i]==0) {
				sum+=answer[i];
			}
		}
		
		System.out.println(sum);
		
	}

}