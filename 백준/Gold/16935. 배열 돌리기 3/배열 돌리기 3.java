import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 
 * 메모리: 34960	시간: 884
 * 
 * N*M인 배열이 있고 R번의 연산을 적용한다.
 * 연산의 종류는 총 6가지이다.
 * 
 * 1번 연산은 상하 반전시키는 연산이다.
 * 2번 연산은 배열을 좌우 반전시키는 연산이다.
 * 3번 연산은 오른쪽으로 90도 회전시키는 연산이다.
 * 4번 연산은 왼쪽으로 90도 회전시키는 연산이다.
 * 5번과 6번은 4등분을 한다음
 * 1->2->3->4->1 순서가 5번
 * 1->4->3->2->1 순서가 6번이다.
 * 
 */

import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int temp[][];
	static int arr2[][];
	static int N, M;
	static int V;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int R = Integer.parseInt(st.nextToken());
    	V = Math.max(N, M);
    	arr = new int[V][V];
    	temp = new int[V][V];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<R; i++) {
    		int A = Integer.parseInt(st.nextToken());
    		if(A==1) one();
    		else if(A==2) two();
    		else if(A==3) three();
    		else if(A==4) four();
    		else if(A==5) five();
    		else six();
    		copyTempToArr();
    	}
    	for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void one() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			temp[i][j] = arr[N-i-1][j];
    		}
    	}
    }
    private static void two() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			temp[i][j] = arr[i][M-j-1];
    		}
    	}
    }
    private static void three() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[j][N-i-1] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
    }

    private static void four() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                temp[M-j-1][i] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
    }
    
    private static void five() {
        // 1 -> 2
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j + (M / 2)] = arr[i][j];
            }
        }
        // 2 -> 3
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i + (N / 2)][j] = arr[i][j];
            }
        }
        // 3 -> 4
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i][j - (M / 2)] = arr[i][j];
            }
        }
        // 4 -> 1
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i - (N / 2)][j] = arr[i][j];
            }
        }
    }

    private static void six() {
        // 1 -> 4
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i + (N / 2)][j] = arr[i][j];
            }
        }
        // 4 -> 3
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j + (M / 2)] = arr[i][j];
            }
        }
        // 3 -> 2
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i - (N / 2)][j] = arr[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                temp[i][j - (M / 2)] = arr[i][j];
            }
        }
    }

    
    private static void copyTempToArr() {
        for (int i = 0; i < V; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, V);
        }
    }
   
}