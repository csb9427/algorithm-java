import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 캐슬 디펜스
 * N*M
 * D: 공격 거리 제한
 * 0: 빈 칸
 * 1: 적
 * 
 * N+1행에 궁수 3명 배치
 * 
 * 궁수의 공격
 * 1) 매 턴 궁수는 적 한 명 공Main3.java격
 * 2) 모든 궁수는 동시에 공격
 * 3) 거리가 D이하인 적 중 가장 가까운 적
 * 	=> 가장 가까운 적이 여러명인 경우 가장 왼쪽에 있는 적
 * 	=> 궁수는 적 하나를 동시에 공격하게 될 수가 있다.
 * 4) 공격받은 적은 사라짐
 * 
 * 적 이동
 * - 궁수의 공격이 끝나면 한 칸씩 아래로 이동
 * 	=> N행을 벗어나면 게임에서 제외 된다.
 * 
 * 게임 종료
 * - 모든 적이 사라지는 경우
 * 
 * 목표
 * => 궁수를 배치하고 게임을 진행했을 때 최대로 적을 제거하는 숫자 구하기
 * 
 * 출력
 * 죽일 수 있는 적의 최대 수
 * 
 * [문제 해결 프로세스]
 * 1. 궁수 배치
 * 	=> 조합 MC3
 * 	=> 궁수 세 명을 배치할 좌표 구하기
 * 
 * 2. 궁수 공격
 * 	a. 세 명의 궁수가 죽일 적 탐색
 * 		=> 가중치가 없는 그래프에서 최단거리 구하기
 * 			-레벨별 BFS탐색
 * 				=> 방향 좌, 상, 우로 설정해서 적을 찾자마자 해당 적을 죽일적으로 판단.
 * 		=> 탐색을 이어가는 조건
 * 			a) 경계 벗어 X
 * 			b) 방문 X
 * 			c) 거리가 D초과 X
 * 			
 * 	b. 찾은 적을 한꺼번에 죽임
 * 		- kill수 cnt
 * 			=> 이미 좌표가 0인 경우 kill cnt X
 * 		- 적 위치를 0처리
 * 
 * 3. 적 이동
 * 	=> 각 1차원 배열의 참조만 변경
 * 	
 * 
 * 4. 2~3번 N번 반복(N번 동안 반복, 적 이동이 N번되면 적이동이 남아있지 않기 때문)
 * 
 * 5. 이 떄, 죽인 적의 수가 최대라면 갱신
 * 
 * 시간복잡도
 * 1. 궁수 배치: 15C3
 * 2. 각 궁수마다 BFS: 3*N*M
 * 3. 적 이동: N
 * 2~3을 N번 반복
 * 총 경우의 수 15C3 * N(3*N*M + N)
 * 
 */

public class Main {
	
	static int N, M, D;
	
	static int[] dr = {0, -1, 0}; //좌, 상, 우
	static int[] dc = {-1, 0, 1};

	static int[][] origin;
	static int[][] map;
	static int[] hunters = new int[3];

	static int kill;
	static int answer = 0;

	static class Node{
		int r, c;
		int dis;
		public Node(int r, int c, int dis){
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        origin  = new int[N][M];
		map = new int[N][M];
		hunters = new int[3];

        
        for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        BFS(0, 0);

		System.out.println(answer);

    }
    
    private static void BFS(int count, int start) {
    	
    	if(count==3) {
    		kill = 0;
    		
    		for(int i=0; i<N; i++) {
				System.arraycopy(origin[i], 0, map[i], 0, M);
			}
    		for(int i=0; i<N; i++) {
    			game();
    			move();
    		}
    		
    		answer = Math.max(answer, kill);
			return;
    		
    	}
    	
    	for(int i=start; i<M; i++) {
			hunters[count] = i;
			BFS(count+1, i+1);
		}
    }

    private static void game() {
    	List<Node> enemies = new ArrayList<>(); //죽일 적 좌표 정보 담기

		//궁수 세 명 bfs탐색
		A: for(int hunterC : hunters) {

			boolean[][] visited = new boolean[N][M];
			Queue<Node> q = new ArrayDeque<>();

			//시작 정보 큐에 넣기
			q.offer(new Node(N-1, hunterC, 1));
			visited[N-1][hunterC] = true;

			while(!q.isEmpty()) {
				//좌표 정보 뽑아오기
				Node n = q.poll();
				int r = n.r;
				int c = n.c;
				int dis = n.dis;	//궁수로부터 현재좌표까지의 거리

				//적정보를 뽑아 왔다면?
				if(map[r][c] == 1) {
					//적 좌표정보 추가 후 다음 궁수 bfs 탐색으로
					enemies.add(n);
					continue A;
				}
				//좌 => 상=> 우 탐색
				for(int d=0; d<3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;	//경계 벗어나는 경우
					if(visited[nr][nc]) continue;	//이미 방문한 경우
					if(dis+1 >D) continue;		//궁수로부터의 거리(dis+1)가 D를 초과

					q.offer(new Node(nr,nc, dis+1));
					visited[nr][nc] = true;
				}
			}
		}
		// 2) 적 죽이기
		for(Node n : enemies) {
			if(map[n.r][n.c]!=1) continue;	//이미 죽인 적
			
			map[n.r][n.c] = 0;	// 죽이기
			kill++;				//죽인 수 카운트
		}
    }
    
    private static void move() {
    	for(int i=N-2; i>=0; i--) {
			map[i+1] = map[i];
		}
		map[0] = new int[M];
    }
    	
}