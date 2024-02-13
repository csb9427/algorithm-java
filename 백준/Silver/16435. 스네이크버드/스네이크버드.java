import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 스네이크버드 문제
 * 과일 하나를 먹을때마다 길이가 1씩 늘어나는 스네이크버드의 최종 길이를 구하면 되는 문제입니다.
 * 첫 번째 줄에는 과일의 개수와 초기 길이가 주어집니다.
 * 
 * 풀이 방법
 * 1. 과일의 크기를 정렬한다.
 * 2. 과일은 처음부터 먹으며 길이를 늘리며 비교한다. 과일을 못먹게 되거나 다 먹으면 종료하고 최종 길이를 출력한다.
 */


public class Main {
	
	static int [] farr;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	farr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		farr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(farr);
    	
    	for(int i=0; i<N; i++) {
    		if(farr[i]>L) break;
    		L++;
    	}
    	System.out.println(L);
    }
}