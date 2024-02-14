import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * N * N 크기의 체스판의 N개의 퀸의 있다. 퀸은 상 하 좌 우 대각선 전부 이동이 가능하다.
 * 퀸끼리 절대 만나지 않는 경우의 수를 출력하는 문제이다.
 * 
 * 풀이과정
 * 처음 선언을 할 때 arr를 1차원 배열로 선언한다. 어차피 같은 줄에 있는 경우엔 무조건 만나게 되므로
 * 1차원으로 선언한 후 대각선을 체크해준다.
 * 처음 크기를 0으로 잡고 확인해주면서 계속 체크헀을 때 depth가 N과 같아졌다면 퀸이 제대로 설치가 된 것이므로 count를 더한다.
 */

public class Solution {
	static int arr[];
	static int N;
	static int count = 0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for(int test_case = 1; test_case <= T; test_case++)
		{
    		N = Integer.parseInt(br.readLine());
        	arr = new int[N];
        	
        	dfs(0);
        	System.out.println("#"+test_case+" "+count);
        	count = 0;
		}
    	
    }
    private static void dfs(int depth) {
    	if(depth == N) {
    		count++;
    		return;
    	}
    	for(int i=0; i<N; i++) {
    		arr[depth] = i;
    		if(visited(depth)) {
    			dfs(depth+1);
    		}
    	}
    }
    
    private static boolean visited(int num) {
    	for(int i=0; i<num; i++) {
    		if(arr[i]==arr[num]) return false;
    		else if(Math.abs(num-i) == Math.abs(arr[num]-arr[i])) return false;
    	}
    	return true;
    }
    
    
}