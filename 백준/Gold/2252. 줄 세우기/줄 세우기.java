import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * N명의 학생들을 키 순서대로 줄을 세운다.
 * 두 학생의 키를 비교해보며 줄을 세운 결과를 출력한다. 답이 여러가지인 경우에는 아무거나 출력한다.
 * 아까 설명해주신 위상정렬 문제로 볼 수 있다.
 * 
 * 첫째 줄에는 N명의 학생 수가 주어지고 M의 키를 비교한 횟수가 주어진다.
 * 
 * 이거는 우선 q에 넣으면서 해당 체크
 * 
 */



public class Main {
	
	static int N, M;
    
	static int[] degrees;
	    
	static List<Integer>[] adjList;   
	
	static int answer = 0;
	
	static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degrees = new int[N+1];
        adjList = new List[N+1];
		
		for(int i=1; i<=N; i++) adjList[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            adjList[from].add(to);
            degrees[to]++;
		}
		
		BFS();
		System.out.println(sb);
		
    }
    private static void BFS() {
    	Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=1; i<=N; i++) {
            if(degrees[i]==0) q.offer(i);
        }
         
        while(!q.isEmpty()) {

            int from = q.poll();
            
            sb.append(from).append(' ');

            for(int to : adjList[from]) {
                if( --degrees[to]==0 ) q.offer(to);
            }
        }
    }
    
}