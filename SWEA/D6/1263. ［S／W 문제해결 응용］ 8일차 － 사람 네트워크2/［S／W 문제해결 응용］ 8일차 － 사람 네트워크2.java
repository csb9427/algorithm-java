import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int[][] graph;
    static int a = 100000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 0 && i != j) graph[i][j] = a;
                    else graph[i][j] = val;
                }
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (graph[i][k] + graph[k][j] < graph[i][j]) {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
            int minCC = Integer.MAX_VALUE;
            for (int from = 1; from <= N; from++) {
                int curCC = 0;
                for (int to = 1; to <= N; to++) {
                    curCC += graph[from][to];
                }
                minCC = Math.min(minCC, curCC);
            }
            System.out.println("#"+test_case+" "+minCC);
        }
    }
}