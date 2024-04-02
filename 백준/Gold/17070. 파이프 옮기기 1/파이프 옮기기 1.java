import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 
 * 17070 파이프 옮기기 1
 * 
 * 파이프는 2개의 연속된 칸을 차지한다. 파이프를 밀 수 있는 방향은 세 가지이다.
 * 파이프는 무조건 (r, c)와 (r, c+1) 두 칸을 차지하는 상태이며, 90도 이상을 한 번에 꺾지는 못한다.
 * 또한 직선이 아닌 45도가 꺾여 있는 경우, 주변 블록도 파이프가 연결된 것으로 간주된다.
 * 좌표 (r-1, c), (r, c-1)도 함께 visited를 true로 변경해준다.
 * 
 * 이동 가능한 방향:
 * - 가로: {0, 1}
 * - 대각선: {0, 1, 2}
 * - 세로: {1, 2}
 * 
 * 대각선일 때, 그 visited를 true로 하는 게 아니라 진행 방향이 1일 때 못가는데
 * 대각선의 경우에는 그 구변 좌표값까지 함께 확인하여 있을 경우에만 이동이 가능하다.
 * 
 */

public class Main {
    static int N;
    static int[][] house;
    static int count;

    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        house = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;

        dfs(0, 1, 0);

        System.out.println(count);
    }

    private static void dfs(int r, int c, int dir) {
        if (r == N - 1 && c == N - 1) {
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= N || nc >= N || house[nr][nc] == 1) continue;  
            if (i == 1 && (house[r][nc] == 1 || house[nr][c] == 1)) continue;
            if (dir == 0 && i == 2) continue;
            if (dir == 2 && i == 0) continue;
            if (i == 1 && (house[r][nc] == 1 || house[nr][c] == 1)) continue;

            dfs(nr, nc, i);
        }
    }
}