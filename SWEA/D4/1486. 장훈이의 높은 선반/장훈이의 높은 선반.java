import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 1486 장훈이의 높은 선반
 * 
 * 장훈이는 서점을 운영하고 있다.
 * 서점에는 높이가 B인 선반이 하나 있다.
 * N명의 점원들의 키가 주어지고 이들을 조합해서 최대한 차이가 적은 탑의 높이를 만들어 내야한다.
 * 
 * 그냥 for문으로 정렬한다음에 쭉 나열하고 하나씩 더해가면서 기준을 넘는 지 확인한다음
 * 아니지 맨뒤에서부터 더하는 게 낫나
 * 
 * 필요한 값이 있는데 처음부터 더해 쭉 더해 
 * 그 다음 값이 나와
 * 넘었다? 그러면 이제 다시 맨 아래를 빼 맨 아래를 빼는 데 수가 맞아?
 * 
 * 아니면 걍 부분 조합이네 아 잠만 그러면 터진다.
 * 
 * 1 1 1 1 1 1 1 1000 10 1 1 1 1 1 1 1 1 1
 * 
 * 부분집합
 * 
 * 
 */

public class Solution {
	
	static int N, B;
	static int[] H;
	static int min;
	static boolean []check;
	
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <=T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());

        	min = Integer.MAX_VALUE;
        	
        	H = new int[N];
        	check = new boolean[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		H[i] = Integer.parseInt(st.nextToken());
        	}
        	Arrays.sort(H);
        	for(int i=1; i<=N; i++) {
        		answer(0, i);
        	}
        	System.out.println("#"+test_case+" "+min);
        }
        
    }
    private static void answer(int count, int cnt) {
    	if(count==cnt) {
    		int sum = 0;
    		for(int i=0; i<N; i++) {
    			if(check[i]) sum +=H[i];
    		}
    		if(sum >= B) {
        		min = Math.min(min, sum-B);
        	}
    		return;
    	}
    	
    	check[count] = true;
    	answer(count+1, cnt);
    	check[count] = false;
    	answer(count+1, cnt);
    }
    
   
}
