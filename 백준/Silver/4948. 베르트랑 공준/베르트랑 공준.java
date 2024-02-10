import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 에라토스테네스의 채를 사용해 판별하는 문제이다.
 * 값을 받는 것이 아닌 애초에 boolean을 통해 소수의 위치를 체크해둔다음 for문을 통해
 * 정해진 범위안에 false의 개수를 세서 출력한다.
 */

public class Main {
	
	static int count = 0;
	public static boolean[] check = new boolean[300000];
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 1;
        check[0] = check[1] = true;
        answer();
        
        while(true) {
        	N = Integer.parseInt(br.readLine());
        	if(N==0) break;
        	for(int i=N+1; i<=N*2; i++) {
        		if(!check[i]) count++;
        	}
        	System.out.println(count);
        	count=0;
        }
        
    }
    public static void answer() {
		for(int i = 2; i <= Math.sqrt(check.length); i++) {
			if(check[i]) continue;
			for(int j = i * i; j < check.length; j += i) {
				check[j] = true;
			}
		}
	}

}