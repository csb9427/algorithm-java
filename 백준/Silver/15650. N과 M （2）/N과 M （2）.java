import java.util.Arrays;
import java.util.Scanner;

/*
 * 재귀함수로 풀어야 한다.
 * 자연수 N은 범위이고 M은 수열중에 몇개를 고를 지 정할 수 있다.
 * 고른 수열은 오름차순이어야 하며
 * 수열간의 중복이 없다.
 * 
 * 
 * 입력을 받는다.
 * 재귀함수로 넘긴다음 값의 개수가 다 골라졌으면 출력한다. 
 * 다만 값의 크기는 반드시 값보다 커야한다.
 */


public class Main {
	static int N;
	static int R;
	
	static int[] picked; // 뽑은 요소 정보
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		picked = new int[R];
		permu(0, 1);
	}
	/*
	 *  숫자 한 개를 뽑고 다음 자리의 숫자는 재귀함수 호출로 맡김
	 */
	private static void permu(int idx, int start) {
		
		if(idx==R) {
			for(int i=0; i<R; i++) {
				System.out.printf("%d ", picked[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			picked[idx] = i; // 요소 뽑음
			permu(idx+1, i+1); // 다음 요소 뽑기는 재귀에 맡긴다.
			
		}
	}

}