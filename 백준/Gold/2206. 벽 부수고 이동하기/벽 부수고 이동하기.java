import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * N * M의 행렬로 표현되는 맵이 있다.
 * 0은 이동할 수 있는 곳이고 1은 이동할 수 없는 벽이다.
 * 1,1 부터 N,M의 위치까지 이동할 때 최단 경로로 이동한다. 만약 벽을 부수고 이동하는 경우에 더 짧아지면 구하면 된다.
 * 
 * 출력
 * 어차피 벽을 부수고 이동해서 최단 경로랑 부수지 않고 최단 경로의 수랑 같아도 출력은 같기 때문에 무조건 벽을 하나 부수고 BFS를 돌린다.
 * 
 * 시간 복잡도
 * 1000000
 * 
 * [문제 해결 프로세스]
 * 1. 
 */

public class Main {

    static int N, M;
    static char[][] map;
    static int [][][]visited;
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	for(int j=0; j<M; j++) {
        		map[i][j] = s.charAt(j);
        	}
        }
        
        System.out.println(BFS());
   
    }
    static int BFS() {
    	visited = new int[N][M][2];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {0, 0, 0});
    	visited[0][0][0] = 1;
    	
    	while(!q.isEmpty()) {
    		int[] current = q.poll();
    		int x = current[0];
    		int y = current[1];
    		int checkWall = current[2];
    		
    		if(x == N-1 && y == M-1) {
    			return visited[x][y][checkWall];
    		}
    		
    		for(int i=0; i<4; i++) {
    			int rx = x + dx[i];
    			int ry = y + dy[i];
    			
    			
    			if(rx<0 || rx>=N || ry<0 || ry>=M) continue;
    			
    			if(map[rx][ry]=='0' && visited[rx][ry][checkWall] == 0) {
    				visited[rx][ry][checkWall] = visited[x][y][checkWall] + 1;
    				q.offer(new int[] {rx, ry, checkWall});
    			}
    			
    			if(map[rx][ry] == '1' && checkWall == 0 && visited[rx][ry][1]==0) {
    				visited[rx][ry][1] = visited[x][y][checkWall] + 1;
    				q.offer(new int[] {rx, ry, 1});
    			}
    				
    		}
    	}
    	return -1;
    }

    	
}