import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.InputMap;

/*
 * 첫째 줄에 몇 번의 게임을 진행하는 지 주어진다.
 * 둘째 줄에 종이컵의 수(3<=N<=200000)
 * 셋 째 줄부터 간식이 들어있는 종이컵의 수
 * 
 */


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, X, K;
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		boolean[] cup = new boolean[N+1];
		cup[X] = true;
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int A, B;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(cup[A]==true) {
				cup[B] = true;
				cup[A] = false;
			}
			else if(cup[B]==true) {
				cup[B] = false;
				cup[A] = true;
			}
		}
		for(int i=1; i<=N; i++) {
			if(cup[i]==true) System.out.print(i);
		}
	}

}