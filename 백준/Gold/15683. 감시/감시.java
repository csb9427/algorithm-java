import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 감시
 * 사무실은 N*M 크기의 직사각형으로 나타낼 수 있다.
 * 사무실에는 K개의 CCTV가 설치되어 있다.
 * CCTV는 5가지 종류가 있다. 
 * 1번은 한쪽 방향만 감시 가능
 * 2번은 두 방향을 감시하지만 방향이 서로 반대방향이어야 한다
 * 3번은 직각 방향이어야 한다.
 * 4번은 세 방향
 * 5번은 네 방향을 감시할 수 있다.
 * 
 * 0은 빈칸 1~5는 cctv번호 6은 벽일때 감시할 수 있는 최대 범위를 잡고 사각지대의 최소 범위를 나타내라
 * 
 * 문제 해결 프로세스
 * 1. 우선 각 CCTV마다 경우의 수를 생각해 봤을 때 1은 4가지 경우 2는 2가지 경우 3은 4가지 경우
 * 1-1. 4는 4가지 경우 5는 1가지 경우이기 때문에 각 경우의 수에 맞춰 0의 숫자를 전부 바꾼다.
 * 
 * 마지막에 0개수 체크하기
 * 그냥 for문 개 돌리기로 가능할듯
 * 순열이겠다.
 * 
 * 
 */

public class Main {
	
	static int[][] dir1 = {{0}, {1}, {2}, {3}};
	static int[][] dir2 = {{0, 2}, {1, 3}};
	static int[][] dir3 = {{3, 0}, {0, 1}, {1, 2}, {2, 3}};
	static int[][] dir4 = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
	static int[] dir5 = {0, 1, 2, 3};
	
	static int[][] arr;
	static int N, M, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		ans = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[N][M];
		int total = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) {
					visit[i][j] = true;
					
					if(arr[i][j] != 6) {
						total++;
					}
				}
			}
		}
		
		findCctv(0, visit, total);
		
		System.out.println(ans);
		
	}
	
	private static void findCctv(int idx, boolean[][] visit, int remain) {
		
		if(remain==0) {
			ans = Math.min(ans, getBlind(visit));
			return;
		}
		
		for(int i=idx; i<N * M; i++) {
			int x = i/M;
			int y = i%M;
			
			int cctv = arr[x][y];
			
			if(cctv !=0 && cctv != 6) {
				if(cctv == 1) {
					for(int[] arr : dir1) {
						findCctv(i+1, search(x, y, arr, visit), remain-1);
					}
				}
				else if(cctv == 2) {
					for(int[] arr : dir2) {
						findCctv(i+1, search(x, y, arr, visit), remain-1);
					}
				}
				else if(cctv == 3) {
					for(int[] arr : dir3) {
						findCctv(i+1, search(x, y, arr, visit), remain-1);
					}
				}
				else if(cctv == 4) {
					for(int[] arr : dir4) {
						findCctv(i+1, search(x, y, arr, visit), remain-1);
					}
				}
				else if(cctv == 5) {
					findCctv(i+1, search(x, y, dir5, visit), remain-1);
				}
			}
		}
		
	}
	
	private static boolean[][] search(int x, int y, int[] dir, boolean[][] visit){
		boolean[][] copy = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = visit[i][j];
			}
		}
		
		for(int d : dir) {
			if(d==0) {
				for(int i=x; i>=0; i--) {
					if(arr[i][y] == 6) break;
					copy[i][y] = true;
				}
			}
			else if(d==1) {
				for(int i=y; i>=0; i--) {
					if(arr[x][i]==6) break;
					copy[x][i] = true;
				}
			}
			else if(d==2) {
				for(int i=x; i<N; i++) {
					if(arr[i][y]==6) break;
					copy[i][y] = true;
				}
			}
			else if(d==3) {
				for(int i=y; i<M; i++) {
					if(arr[x][i]==6) break;
					copy[x][i] = true;
				}
			}
			
		}
		return copy;
	}
	
	private static int getBlind(boolean[][] visit) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(!visit[i][j]) cnt++;
			}
		}
		return cnt;
	}

}