/*
 * 젤리는 점프하는 것을 좋아한다.
 * 1. 범위 밖으로 가면 바로 떨어지고 게임 끝임
 * 2. 젤리의 시작은 0,0에서 시작함
 * 3. 이동하는 칸수는 밝고 있는 칸의 숫자만큼 이동이 가능함
 * 4. 도달은 N-1, N-1에 도착해야만 한다.
 * 
 * [문제 해결 프로세스]
 * 1. BFS로 풀것이고 탈출 조건은 밟고 있는 칸이 -1일때 탈출
 * 2. 범위를 벗어나거나 밟았던 위치로 돌아가면 안되니까 boolean배열도 사용
 * 3. 이동은 무조건 오른쪽이나 아래로만 이동한다. 크기도 작아서 사실 걍 풀어도 될 거 같지만
 * 4. 연습삼아 BFS로 풀겠
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int[][] map;
	
	static boolean[][] check;
	
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        check = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        BFS(0, 0);
    }
    
    private static void BFS(int r, int c) {
    	Queue<int[]> q = new LinkedList<int[]>();
    	check[r][c] = true;
    	q.offer(new int[] {r, c});
    	
    	while(!q.isEmpty()) {
    		int[] current = q.poll();
    		int x = current[0];
    		int y = current[1];
    		
    		int a = map[x][y];
    		
    		if(map[x][y] == -1) {
    			System.out.println("HaruHaru");
    			return;
    		}
    		
    		for(int i=0; i<2; i++) {
    			int nx = x+dx[i] * a;
    			int ny = y+dy[i] * a;
    			
    			if(nx>=N || ny>=N) continue;
    			if(check[nx][ny]) continue;
    			check[nx][ny] = true;
    			q.offer(new int[] {nx, ny});
    		}
    	}
    	System.out.println("Hing");
    	
    }
    
    
    
}