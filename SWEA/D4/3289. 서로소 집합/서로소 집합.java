import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int N; // 1부터 N까지 정점
    static int M; // 합집합 정보 개수
    
    static int[] parents; // 서로소 집합 정보
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int d = 1; d <= T; d++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            makeSet();
            System.out.print("#" + d + " ");
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int ch = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    if (find(a) == find(b))
                        System.out.print(1);
                    else
                        System.out.print(0);
                } else {
                    union(a, b);
                }
            }
            System.out.println(); // 각 테스트 케이스 종료 후 개행
        }
        
    }
    
    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parents[i] = i;
    }
    
    /**
     * a원소가 속한 집합의 대표원소 반환
     */
    private static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]); // Path compression
    }
    
    // a, b 원소가 속한 집합을 합집합
    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return false;
        parents[rootA] = rootB;
        return true;
    }
}