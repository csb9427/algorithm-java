/*
 * 수빈이는 동생과 숨바꼭질을 한다.
 * 이때 수빈이는 현재 점 0<=N<=100000에 있고 동생은 점 0<=K<=100000에 있다.
 * 수빈이는 X-1, 이거나 X+1이거나 2*X로 이동한다.
 * 
 * 가장 빠른 시간을 구하시오.
 * 
 * [문제 해결 프로세스]
 * 1. BFS탐색을 할 것이다.
 * 2. 0아래로 내려가도 탈출
 * 3. N이 100000이 넘어서도 탈출
 * 3-1 여기서 최적화가 들어간다면 아마 N이 K의 두 배 이상 차이나도 종료해도 괜찮을듯싶다.
 * 4. N==K가 동일하면 그때 종료 레벨별 BFS문제인 거 같다.
 * 
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	
	static boolean[] check = new boolean[100001];
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        
        BFS(N);
    }
    
    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        check[start] = true;

        int count = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int subin = q.poll();
                
                if (subin == K) {
                    System.out.println(count);
                    return;
                }
                
                if (subin + 1 <= 100000 && !check[subin + 1]) {
                    q.offer(subin + 1);
                    check[subin + 1] = true;
                }
                if (subin - 1 >= 0 && !check[subin - 1]) {
                    q.offer(subin - 1);
                    check[subin - 1] = true;
                }
                if (subin * 2 <= 100000 && !check[subin * 2]) {
                    q.offer(subin * 2);
                    check[subin * 2] = true;
                }
            }
        }
    }
    
    
}