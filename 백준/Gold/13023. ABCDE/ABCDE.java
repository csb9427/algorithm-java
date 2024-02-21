import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



/*
 * 첫째 줄에 사람의 수 N과 친구 관계의 수 M이 주어진다.
 * M개의 줄에는 정수 a와 b가 주어지고 서로 친구라는 뜻이다.
 * 
 * A는 B와 친구
 * B는 C와 친구
 * C는 D와 친구
 * D는 E와 친구
 * 
 * 가 존재하면 1을 출력하고 없다면 0을 출력해야한다.
 * 
 */

public class Main {

    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new List[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) adjList[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r, c;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            adjList[r].add(c);
            adjList[c].add(r);
        }
        
        for(int i=0; i<N; i++) {
        	dfs(i, 1);
        	if(answer==1) break;
        }
        
        System.out.println(answer);
    }

    static void dfs(int start, int count) {
    	
    	if(count==5) {
    		answer = 1;
    		return;
    	}
    	
        visited[start] = true;

        for(int to : adjList[start]) {
			if(visited[to]) continue;
			
			dfs(to, count+1);
		}
		visited[start] = false;
    }
}