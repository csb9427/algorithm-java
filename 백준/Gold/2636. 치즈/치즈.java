import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 사각형 모양의 판이 주어지는데 세로와 가로의 길이가 양의 정수로 주어진다.
 * 각 길이의 최대는 100이다.
 * 
 * 치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지면 각 숫자사이에는 빈칸이 있다.
 * 
 * 
 * 일단 BFS로 탐색하면서 계속해서 업데이트를 한다. for문 사용
 * 이때 for문을 돌면서 BFS에서의 출력값이 0이 된다면 그 전 출력값을 출력하면서 for문을 돈 횟수를 같이 출력한다.
 * 
 * 
 * 문제 해결 프로세스
 * 1. 가장 먼저 0, 0에서 출력하여 테두리를 확인하도록 한다.
 * 2. 테두리 위치를 boolean 배열에 넣어 치즈가 생기지 않는다는 것을 확인한다.
 * 3. 다음으로 1의 위치를 0값으로 바꾸기
 * 
 */

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int time = 0;
    static int countCheese;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) countCheese++;
            }
        }

        int cheeseLeft = 0;
        while (countCheese > 0) {
            time++;
            cheeseLeft = countCheese;
            bfs();
            meltCheese();
        }

        System.out.println(time);
        System.out.println(cheeseLeft);

    }

    private static void bfs() {
        visited = new boolean[N][M];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int r = current.r;
            int c = current.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    queue.offer(new Node(nr, nc));
                } else if (map[nr][nc] == 1) {
                    map[nr][nc] = 2; // 치즈 녹이기
                    countCheese--;
                }

                visited[nr][nc] = true;
            }
        }
    }

    private static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0; // 치즈 녹이기
                }
            }
        }
    }
}