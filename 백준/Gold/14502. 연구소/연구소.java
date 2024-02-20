import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 
 * 벽은 3개를 세울 수 있다.
 * 지도의 세로 크기 N과 가로 크기 M이 주어진다. 
 * 둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스이다. 2의 개수는 2<=10의 개수가 있다.
 * 안전 영역의 최대 크기를 출력한다.
 * 
 * [해결 프로세스]
 * 1. 배열은 벽을 세우기 전 배열과 벽을 세훈 후의 배열을 선언한다.
 * 2. 벽은 3개를 무조건 세워야 하므로 벽을 선택하는 배열을 하나 선언한다.
 * 3. 상, 하, 좌, 우를 구성하는 배열을 만들고 Node를 만들어 위치 좌표를 저장할 수 있도록 한다.
 * 4. 입력을 받고 난 후 먼저 벽을 3개 세우는 코드를 구성한다. 여기서는 중요한 것은 3개가 다 0이어야 세울 수 있기에 분리한다.
 * 5. 이후 벽을 세우고 난 후 BFS를 돌리며 세이프 존의 개수를 확인한다.
 * 6. 마지막으로 세이프 존의 개수를 비교하여 가장 큰 수를 출력하도록 한다.
 * 
 */

public class Main {
    static int[][] board;
    static int[][] checkBoard;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Node> virusInfo = new ArrayList<>();

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        checkBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virusInfo.add(new Node(i, j));
                }
            }
        }

        BFS(0, 0);
        System.out.println(answer);
    }

    private static void arrayCopy() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, checkBoard[i], 0, M);
        }
    }

    private static void BFS(int cnt, int start) {
        if (cnt == 3) {
            virus();

            int safeArea = getZeroCheck();
            answer = Math.max(answer, safeArea);

            return;
        }
        for (int i = start; i < N * M; i++) {

            int n = i / M;
            int m = i % M;

            if (board[n][m] != 0) continue;

            board[n][m] = 1;
            BFS(cnt + 1, i + 1);
            board[n][m] = 0;
        }
    }

    private static void virus() {
        arrayCopy();

        Queue<Node> q = new ArrayDeque<>(virusInfo);

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = n.r + dx[d];
                int nc = n.c + dy[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (checkBoard[nr][nc] != 0) continue;

                checkBoard[nr][nc] = 2;
                q.offer(new Node(nr, nc));
            }
        }
    }

    private static int getZeroCheck() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (checkBoard[i][j] == 0) count++;
            }
        }
        return Math.max(count, answer);
    }
}