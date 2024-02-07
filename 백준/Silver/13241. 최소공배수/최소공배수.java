import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * 유클리드 호제법을 사용한다. 이를 통해 
 * 최대 공약수를 구하는 공식인 큰수에서 작은 수 나누기 작은수와 나머지 나누기
 * 반복해서 0이 나오면 그때 작은수가 곧 최대 공약수가 된다.
 * 이를 A*B/최대 공약수를 하면 최소공배수가 나온다.
 * 
 */

import java.util.StringTokenizer;

public class Main {
	
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		swap(A, B);
		System.out.println((A*B)/gcd(A, B));
    	
    }
    private static void swap(long A, long B) {
		if(A>B) {
			long temp;
			temp = A;
			A = B;
			B = temp;
		}
	}
	private static long gcd(long A, long B) {
		long R;
    	while(B!=0) {
    		R = A%B;
    		A = B;
    		B = R;
    	}
    	return A;
    }


}