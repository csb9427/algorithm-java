import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
 * 
 * 음식은 두 종류 A와 B에 대한 조합이 존재한다.
 * 두 음식을 만들때는 정확히 절반을 나눠서 재료를 사용해야 한다.
 * 이 두 음식의 시너지 차이가 가장 적어야 한다.
 * 
 * 풀이방법
 * 무조건 조합이고 N/2의 값만큼을 뽑아내서 조합을 만들고 계속해서 비교한다.
 * 즉 입력받은 N의 개수에서 N/2개씩 뽑아내서 더해준 다음 뽑지 않은 N/2개끼리 더한다음 서로 빼준다.
 * 이때 비교문을 사용해서 차이가 가장 작은 겂을 출력하면 된다.
 * 
 * 각 음식별 시너지가 다르기 때문에 이 값을 써야한다.
 * 조합안에 조합이 들어가는 느낌이다. 가장 먼저 N/2씩 뽑는 것도 조합이고 그 안에서 시너지가 있기 때문에
 * 예를 들어 첫 번째 음식과 두 번째 음식의 시너지도 합치고 두 번째 첫 번째 음식과 세 번째 음식 두 번째와 세 번째 음식의 시너지를 합치게 된다.
 * 
 * 
 */


public class Solution {
	
	static int N, minScore = Integer.MAX_VALUE;
	static int [][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int q = 1; q<=T; q++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			answer(0, 0);
			System.out.println("#"+q+" "+minScore);
			minScore = Integer.MAX_VALUE;
		}
		
    }
	private static void answer(int start, int end) {
		if(start == N/2) {
			int A = 0;
			int B = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i] && visited[j]) A += arr[i][j];
					else if(!visited[i] && !visited[j]) B+= arr[i][j];
				}
			}
			
			minScore = Math.min(Math.abs(A-B), minScore);
			
			return;
		}
		
		for(int i=end; i<N; i++) {
			visited[i] = true;
			answer(start+1, i+1);
			visited[i] = false;
		}
	}
	
	
}