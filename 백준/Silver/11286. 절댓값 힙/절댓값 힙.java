import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 
 * 메모리: 11584	시간: 80
 * 
 * 배열에 정수를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거 한다.
 * 절대값이 가장 작은 값이 여러개면 그 값을 다 제거한다?
 * 
 * 풀이방법
 * 첫째 줄에 연산의 개수가 주어짐 100000개 다음 줄에는 연산에 대한 정보
 * x가 숫자라면 넣고 0이라면 배열에서 절댓값이 작은 값을 출력하고 제거해라.
 * 만약 배열이 비어있는데 출력하라고 한다면 0을 출력한다.
 * 
 * queue값을 수정한다.
 * 
 */

import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a) == Math.abs(b)) {
                        return a > b ? 1 : -1;
                    } else {
                        return Math.abs(a) - Math.abs(b);
                    }
                }
        );

    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		if(x==0) {
    			if(pq.isEmpty()) System.out.println(0);
    			else System.out.println(pq.poll());
    		}
    		else pq.add(x);
    		
    	}
    }
   
}