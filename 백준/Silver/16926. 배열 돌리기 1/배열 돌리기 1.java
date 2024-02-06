import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * 처음에 배열의 크기 N과 M이 주어진다. 이후 회전의 수 R이 주어진다.
 * 크기가 N*M인 배열이 있을 때 반시계 방향으로 돌아야한다.
 * 즉 [1][1]에 있는 원소의 위치는 [2][1]로 가는 회전의 문제이다.
 * 
 * 풀이방법
 * 입력을 받은 배열을 입력받는다. 
 * 그 다음 상 하 좌 우에 해당하는 배열을 만든다.
 * 이 배열의 값을 위치에 더하며 변경해 나간다.
 * 
 */

import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int [][]arr;
    static int N, M, R;
    
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        for(int i=0; i<R; i++) {
        	rotate();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=M; j++) {
        		sb.append(arr[i][j]).append(' ');
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
    private static void rotate() {
    	int cnt = Math.min(N, M)/2;
    	for(int s = 1; s<=cnt; s++) {
    		int r = s;
    		int c = s;
    		int dir = 0;
    		
    		int temp = arr[r][c];
    		int temp2 = 0;
    		
    		while(dir<4) {
    			int nr = r + dr[dir];
    			int nc = c + dc[dir]; 

    			if(nr >= s && nr <= N-s+1 && nc >= s && nc <= M-s+1) {
    				r+=dr[dir];
    				c+=dc[dir];
    				temp2 = arr[r][c];
    				arr[r][c] = temp;
    				temp = temp2;
    			}
    			else dir++;
    		}
    	}
    }

}