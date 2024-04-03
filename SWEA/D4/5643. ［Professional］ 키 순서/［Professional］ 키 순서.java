import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 테스트케이스 개수
 * 4번과 다른 정점의 차이점
 * 
 * 
 */

public class Solution {
    
	static int N, M, answer;
	static boolean[] visited;
	static int[] totalCnt;
	static List<Integer>[] students;
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <=T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	M = Integer.parseInt(br.readLine());
        	
        	students = new ArrayList[N + 1];
        	totalCnt = new int[N + 1];
        	
        	for(int i=1; i<=N; i++) {
        		students[i] = new ArrayList<Integer>();
        	}
        	
        	for(int i=1; i<=M; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		students[a].add(b);
        	}
        	
        	Queue<Integer> q = new LinkedList<Integer>();
        	for(int i=1; i<=N; i++) {
        		visited = new boolean[N+1];
        		
        		q.offer(i);
        		visited[i] = true;
        		
        		while (!q.isEmpty()) {
        			int x = q.poll();
        			
        			totalCnt[i]++;
        			
        			for(int j = 0; j<students[x].size(); j++) {
        				int y = students[x].get(j);
        				
        				if(visited[y]) continue;
        				
        				visited[y] = true;
        				totalCnt[y]++;
        				q.offer(y);
        			}
        		}
        		
        	}
        	answer = 0;
        	for(int i=1; i<=N; i++) {
        		if(totalCnt[i] == N) answer++;
        	}
        	System.out.println("#"+test_case+" "+answer);
        }
        
    }

    
}