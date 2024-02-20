/*
 * 적록색약
 * 
 * 크기가 N*N인 그리드의 각 칸에 R, G, B 중 하나가 들어가 있다. 같은 색상이 상하좌우로 이어져있으면
 * 한 구역이라고 볼 수 있다.
 * 
 * [해결 프로세스]
 * BFS의 경우는 처음 0,0을 기준으로 넓혀나간다. 만약 처음 저장해둔 색깔이 boolean으로 체크하며 간다.
 * DFS의 경우에는 상 하 좌우로 나아가다가 만약 만나게 된다면 패쓰한다.
 * 
 * 또한 적록색약인 사람도 범위를 구해야 하기 때문에 초록색을 입력받더라도 빨간색으로 입력받는 배열을 같이 만든다음
 * 하나의 BFS로 돌리는 것도 좋을 거 같다.
 * 
 * 
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    
    static int N;
    static char[][] human;
    static char[][] rgHuman;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        human = new char[N][N];
        rgHuman = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                human[i][j] = row.charAt(j);
                rgHuman[i][j] = row.charAt(j);
                if(rgHuman[i][j] == 'G') rgHuman[i][j] = 'R';
            }
        }
        
        int normalCount = BFS(human);
        visited = new boolean[N][N];
        int rgCount = BFS(rgHuman);
        
        System.out.println(normalCount + " " + rgCount);
    }
    
    private static int BFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int cx = current[0];
                        int cy = current[1];
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && grid[nx][ny] == grid[cx][cy]) {
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}