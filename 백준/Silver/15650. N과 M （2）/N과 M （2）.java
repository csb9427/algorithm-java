import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



/*
 * 
 */

public class Main {

    static int N, M;
    static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        picked = new int[M];
        answer(0, 1);
   
    }

    static void answer(int start, int end) {
    	
    	if(start==M) {
    		for(int i=0; i<M; i++) System.out.printf("%d ", picked[i]);
    		System.out.println();
    		return;
    	}
    	
        for(int i=end; i<=N; i++) {
        	picked[start] = i;
        	answer(start+1, i+1);
        }
    }
}