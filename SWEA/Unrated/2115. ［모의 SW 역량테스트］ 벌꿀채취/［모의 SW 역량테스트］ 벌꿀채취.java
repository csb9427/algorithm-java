/*
 * 2115 swea 벌꿀채취
 * 
 * N * N 개의 맵
 * 벌통에는 꿀이 양이 다 다르다.
 * 
 * 두 명의 일꾼이 있고 꿀을 채취할 수 있는 벌통의 수 M이 주어진다.
 * 
 * 
 * 처음부터 M의 크기만큼 벌꿀 채집 가능 범위를 설정한다.
 * 이후 벌꿀을 채쥐하면서 진행하고 값을 두 개 저장한다.
 * 그다음 값이 크다면 업데이트를 진행한다. 이렇게 해도 될 거 같긴한데..
 * 
 * 문제 풀이 시
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
	static int N, M, C;
	static int [][]honey;
	
	static int maxSum;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	honey = new int[N][N];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			honey[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	maxSum = 0;
        	
        	for(int i=0; i<N*N; i++) {
        		int firstR = i/N;
        		int firstC = i%N;
        		if(firstC > N-M) continue;
        		
        		int firstSum = getMaxSum(firstR, firstC, 0, 0, 0);
        		
        		for(int j=i+M; j<N*N; j++) {
        			int secondR = j/N;
        			int secondC = j%N;
        			if(secondC > N-M) continue;
        			
        			int secondSum = getMaxSum(secondR, secondC, 0, 0, 0);
        			
        			maxSum = Math.max(maxSum, firstSum+secondSum);
        		}
        	}
        	System.out.print("#"+test_case+" "+maxSum);
        	System.out.println();
        }       
    }
    private static int getMaxSum(int sr, int sc, int idx, int sum, int revenue) {
		if(sum > C) return 0;
		if(idx==M) return revenue;

		int curHoney = honey[sr][sc+idx];
		int A = getMaxSum(sr, sc, idx+1, sum+curHoney, revenue+curHoney*curHoney);
		int B = getMaxSum(sr, sc, idx+1, sum, revenue);	

		//두 경우의 이익 중 큰 값을 반환
		return Math.max(A, B);
	}
    
    
    
}