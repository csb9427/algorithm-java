import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0 ,0, -1, 1};

    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int r, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        int count = BFS(startR, startC);
        System.out.println(count);
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

            if (currentR == r && currentC == c) {
                return steps;
            }

            for (int i = 0; i < 4; i++) {
                int newR = currentR + dr[i];
                int newC = currentC + dc[i];

                
                if (newR >= 0 && newR < 5 && newC >= 0 && newC < 5 && !visited[newR][newC] && map[newR][newC] != -1) {
                    queue.add(new int[]{newR, newC, steps + 1});
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
}