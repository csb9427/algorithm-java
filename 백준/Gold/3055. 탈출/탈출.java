import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
 * 탈출
 * 
 * map은 R행과 C열로 이루어져 있다. 비어있는 곳은 . 물이 차있는 지역은 * 돌은 X로 표시되어 있다.
 * 비버의 굴은 D로 S에 있는 고슴도치가 가야하는 곳이다.
 * 물은 매 분마다 상 하 좌 우가 차게 된다.
 * 
 * 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구해라
 * 
 * 1. 물이 차 있는 곳은 상 하 좌 우 로 확대한다.
 * 2. 고슴도치는 물이 차 있지 않은 곳으로 이동한다.
 * 3. 고슴도치가 S의 위치에서 D로 가는 가장 빠른 시간 출력하기
 * 
 * 
 */

public class Main {
	
	static int R, C;
	
	static char[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	static Queue<int[]> waterQ = new ArrayDeque<>();	//물 퍼뜨리기 bfs를 위한 큐
	static Queue<int[]> hedgehogQ = new ArrayDeque<>();	//고슴도치 이동 bfs를 위한 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '*') waterQ.offer(new int[] {i,j});
				else if(map[i][j] == 'S') hedgehogQ.offer(new int[] {i,j});
			}
		}
		visited = new boolean[R][C];
		
		int count = 0;
		while(true) {
			int size = waterQ.size();
			for(int i=0; i<size; i++) {
				int [] water = waterQ.poll();
				int r = water[0];
				int c = water[1];
				
				for(int dir = 0; dir<4; dir++) {
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
					if(map[nr][nc]=='X') continue;
					if(map[nr][nc]=='D') continue;
					if(visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					waterQ.offer(new int[] {nr,nc});
					map[nr][nc] = '*';
					
				}
			}
			
			size = hedgehogQ.size();
			if(size==0) break;
			for(int i=0; i<size; i++) {
				int [] jun = hedgehogQ.poll();
				int r = jun[0];
				int c = jun[1];
				
				if(map[r][c] == 'D') {
					System.out.println(count);
					System.exit(0);
				}
				
				for(int dir = 0; dir<4; dir++) {
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
					if(map[nr][nc]=='X') continue;
					if(map[nr][nc]=='*') continue;
					if(visited[nr][nc]) continue;
					
					hedgehogQ.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
			count++;
		}
		System.out.println("KAKTUS");
	}

	
}