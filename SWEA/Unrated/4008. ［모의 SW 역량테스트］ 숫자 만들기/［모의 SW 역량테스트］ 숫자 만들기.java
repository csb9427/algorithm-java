import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 연산자 4개
 * 연산자 우선순위 없음
 * 
 */

public class Solution {
	
	static int N;
	static int []buho = new int[4];
	static int []numbers;
	
	static int max, min;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <=T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	numbers = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<4; i++) {
        		buho[i] = Integer.parseInt(st.nextToken());
        	}
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		numbers[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	max = -1111;
        	min = 100000000;
        	// answer함수에는 0과 numbers의 시작을 보낸다.
        	answer(0, numbers[0]);
        	
        	System.out.println("#"+test_case+" "+(max-min));
        	
        }
    }
    
    // 여기서 중복 순열을 돌아야 함
    private static void answer(int idx, int sum) {
    	if(idx == N-1) {
    		max = Math.max(max, sum);
    		min = Math.min(min, sum);
    		return;
    	}
    	
    	for(int i=0; i<4; i++) {
    		if(buho[i]==0) continue;
    		
    		buho[i]--;
    		
    		answer(idx + 1, result(sum, numbers[idx+1], i));
    		
    		buho[i]++;
    		
    	}
    	
    }
    private static int result(int x, int y, int i) {
    	if(i==0) return x + y;
    	else if(i==1) return x - y;
    	else if(i==2) return x * y;
    	else return x/y;
    }
   
}