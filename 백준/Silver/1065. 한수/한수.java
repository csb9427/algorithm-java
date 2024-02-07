import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * 1부터 99까지는 받은 N의 개수가 곧 한수의 개수이다.
 * 연속된 두개의 차이가 일정한 등차수열을 구해야 한다.
 * 
 * 풀이과정
 * 값을 입력받고 두 자리까지는 그냥 N의 개수를 출력하게 한다.
 * 세 자리부터는 하나의 숫자들로 구분하고 첫 번쨰 수와 두 번째 수의 차이를 저장
 * 이후 두 번째 수와 세 번째 수의 차이가 같은지를 확인한다.
 * 
 */

import java.util.StringTokenizer;

public class Main {
	
	static int count = 99;
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if(N>=100) hansu(N);
		else count = N;
    	System.out.println(count);
    }
    
    private static void hansu(int N) {
    	for(int i=100; i<=N; i++) {
    		int A = i/100; // 첫번째 자리 숫자
        	int B = i/10%10; // 두번째 자리 숫자
        	int C = i%10; // 세번째 자리 숫자
        	int m = A-B;
        	if(m == B-C) count++;
    	}	
    }

}