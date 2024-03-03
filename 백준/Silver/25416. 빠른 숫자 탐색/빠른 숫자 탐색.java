import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0 ,0, -1, 1};

    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        int result = BFS(startR, startC);
        System.out.println(result);
    }

    public static int BFS(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentR = current[0];
            int currentC = current[1];
            int steps = current[2];

            // 목적지에 도착한 경우 최단 거리 반환
            if (board[currentR][currentC] == 1) {
                return steps;
            }

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int newR = currentR + dr[i];
                int newC = currentC + dc[i];

                // 이동한 지점이 유효하고 방문하지 않았으며, 갈 수 있는 지점일 경우
                if (isValid(newR, newC) && !visited[newR][newC] && board[newR][newC] != -1) {
                    queue.add(new int[]{newR, newC, steps + 1});
                    visited[newR][newC] = true;
                }
            }
        }
        // 목적지에 도착하지 못한 경우 -1 반환
        return -1;
    }

    // 주어진 좌표가 유효한 좌표인지 확인하는 메서드
    public static boolean isValid(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }
}