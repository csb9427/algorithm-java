import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * 
 * 모든 여행지를 가야하고 위치가 0이 아닌 경우에 숫자가 전부 달라야 하므로 조합으로 한다.
 * 입력을 받을 때 ij에 있는 위치가 0인경우 로 한다.
 * 최소 비용일 경우에 탈출한다.
 * 
 * 
 */

public class Main {
	
	static int N, a;
	static long answer=Integer.MAX_VALUE;
	
	static int[][] city;
	
	static boolean[] check;
	
	static int picked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		city = new int[N][N];
		check = new boolean[N];
		picked = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 0 && i != j) {
                    city[i][j] = Integer.MAX_VALUE;
                }
			}
		}
		permu(0);
		System.out.println(answer);
	}
	
	private static void permu(int start) {
		if(start == N) {
			long cost = 0;
	        for (int i = 0; i < N; i++) {
	        	cost += city[picked[i]][picked[(i + 1) % N]];
	        }
            answer = Math.min(answer, cost);
            return;
        }
		
		for(int i=0; i<N; i++) {
			if(check[i]) continue;
			picked[start] = i;
			check[i] = true;
			permu(start+1);
			check[i] = false;
				
		}
	}
}