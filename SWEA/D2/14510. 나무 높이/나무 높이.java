import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int []tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(tree);
			int max = tree[N-1];
			
			int count = 1;
			for(int i=0; i<N-1; i++) {
				if(max == tree[i]) count++;
			}
			
			int []a = new int[N-count];
			
			for(int i=0; i<N-count; i++) {
				a[i] = max-tree[i];
			}
			int b = 0;
			int c = 0;
			// 2로 나눠서 2일짜리와 1일짜리로 구분 
			for(int i=0; i<N-count; i++) {
				b = b + a[i]/2;
				c = c + a[i]%2;
			}
			int answer = 0;
//			System.out.println(b + " " + c);
			// 2일짜리가 더 많은 경우 2일짜리를 1일 짜리로 쪼개서 사용
			if(b>c) {
				int d = (b-c)/3;
				b = b-d;
				c = c+d*2;
			}
			// 1일짜리가 더 많은 경우 
			// 1일 짜리들을 2일로 합치고 1일로 따로 처리
			// 
			else if(c>b) {
				
				//                c = c + c*2 -1;
				c = b + (c-b)*2-1;
			}
			
			answer = b + c;
			// 2가 남았을때 0 2 or 1 2 1 
			if(b>c) answer++;
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

}