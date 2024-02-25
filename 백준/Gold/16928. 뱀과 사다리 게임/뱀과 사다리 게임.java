import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int[] board = new int[101];
    static int[] check = new int[101];
    static int N, M;
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= 100; i++) {
            board[i] = i;
        }
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            board[x] = y;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            board[x] = y;
        }
        
        System.out.println(BFS(1));
    }
    
    private static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = 0;

        while (!q.isEmpty()) {
            int s = q.poll();
            
            for (int i = 1; i <= 6; i++) {
                int newChoice = s + i;
                if (newChoice > 100) {
                    continue;
                }
                
                if (check[board[newChoice]] == 0) {
                    q.offer(board[newChoice]);
                    check[board[newChoice]] = check[s] + 1;
                }
                if (board[newChoice] == 100) {
                    return check[100];
                }
            }
        }
        return check[100];
    }
}