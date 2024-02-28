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
 */

public class Main {
	
	static int N, M;
	
	static boolean check[][];
	static boolean visit[];
	
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean [N+1][N+1];
		visit = new boolean [N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check[a][b] = true;
			check[b][a] = true;
		}
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				BFS(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int i=1; i<=N; i++) {
				if(!visit[i] && check[c][i]==true) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}

}