import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


/*
 * 4485 녹색 옷 입은 애가 젤다지?
 * 
 * N * N 크기의 동굴에서 0, 0의 위치에 링크는 있다.
 * 여기서 [N-1][N-1]까지 이동할 때 최소 비용으로 도착하게 해라
 * 
 * 문제 풀이
 * BFS탐색을 통해 비용을 계산하며 내려간다. 
 * 만약 계산한 값의 크기와 기존의 값을 비교했을 때 더 적은 비용을 선택하고 저장한다.
 * 4방 탐색을 통해 방문을 진행한다.
 * 이때 node 클래스를 만들어 우선순위큐에 넣는다.
 * node는 x,y,size로 구성되어 있으며 size가 작은 순서로 값이 들어간다.
 * count 값을 같이 넘겨서 size배열에 저장하며 진행하고 마지막에 size[N-1][N-1]
 * 을 진행하여 값을 출력하면 최소 비용으로 도착할 수 있다.
 * 
 */

public class Main {

    static int N;
    static int[][]map;
    static int[][]size;
    static boolean [][]check;
    // 상 하 좌 우
    static int []dr = {-1, 1, 0, 0};
    static int []dc = {0, 0, -1, 1};
    
    static int X, Y;
    
    static class Node implements Comparable<Node>{
    	int x;
    	int y;
    	int size;
    	
    	public Node(int x, int y, int size) {
    		this.x = x;
    		this.y = y;
    		this.size = size;
    	}
    	
    	@Override
    	public int compareTo(Node o) {
    		return size - o.size;
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            map = new int[N][N];
            check = new boolean[N][N];
            size = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS(0, 0, map[0][0]);
            System.out.println("Problem " + cnt + ": " + size[N-1][N-1]);
            cnt++;
        }
    }
    
    private static void BFS(int x, int y, int count) {
        Queue<Node> pq = new PriorityQueue<>();
        check[x][y] = true;
        size[x][y] = count;
        pq.offer(new Node(x, y, count));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < 4; i++) {
                X = node.x + dr[i];
                Y = node.y + dc[i];

                if (range_check() && !check[X][Y] && (size[X][Y] == 0 || size[X][Y] > map[X][Y] + node.size)) {
                    size[X][Y] = map[X][Y] + node.size;
                    check[X][Y] = true;
                    pq.offer(new Node(X, Y, size[X][Y]));
                }
            }
        }
    }
    private static boolean range_check() {
		return (X >= 0 && Y >= 0 && X < N && Y < N);
	} 
}