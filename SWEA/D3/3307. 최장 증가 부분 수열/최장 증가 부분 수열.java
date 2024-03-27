import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 풀이
 * 주어
 */

public class Solution {
	static int N;
	static int []A;
	static int []list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = new int[N];
			list = new int[N];
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int j = 0;
			list[0] = A[0];
			int i=1;
			
			while(i<N) {
				if(list[j] < A[i]) {
					list[j+1] = A[i];
					j+=1;
				}
				else {
					int idx = binarysearch(0, j, A[i]);
					list[idx] = A[i];
				}
				i+=1;
			}
			System.out.print("#"+test_case+" "+(j+1));
			System.out.println();
		}
		
	}
	
	public static int binarysearch(int left, int right, int target) {
		int mid;
		
		while(left<right) {
			mid = (left+right) / 2;
			
			if(list[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return right;
	}

}