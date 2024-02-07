import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 
 * 2563 색종이
 * 가로 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
 * 이 도화지 위에 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행해야 한다.
 * 
 * 풀이방법
 * 크기는 어차피 10이니까 색종이가 포함된 곳을 전부 1로 바꾼다음 마지막에 개수를 세면 될 것같다.
 */

import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	arr = new int[100][100];
    	int sum = 0;
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		for(int j=x; j<x+10; j++) {
    			for(int k=y; k<y+10; k++) {
    				arr[j][k] = 1;
    			}
    		}
    	}
    	for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(arr[i][j]==1) sum++;
			}
		}
    	System.out.println(sum);
    }
   
}