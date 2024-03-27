import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 스도쿠 문제
 * 
 * 다 안채워진 스도쿠가 주어지고 이 스도쿠가 다 돌아가는지 확인한다
 * 한 줄에 1, 2, 3, 4, 5, 6, 7, 8, 9
 * 
 * 먼저 해야 할 것은 입력을 받는 보드칸을 하나 만든다.
 * board의 크기는 int[9][9]로 만들게 된다.
 * 그 다음 배열 2차원배열 하나를 더 선언해준다음
 * 
 */

public class Main {
	
	static int [][]board;
	static boolean[][] checked;
	
	static ArrayList<int[]> zeroList = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				board[i][j] = s.charAt(j) - '0';
				if(board[i][j]==0) {
					zeroList.add(new int[] {i, j});
				}
			}
		}
		fill(0);
	}
	
	private static void fill(int idx) {
		if (idx == zeroList.size()) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int[] blank = zeroList.get(idx);
		int r = blank[0];
		int c = blank[1];
		
		for (int num=1; num<=9; num++) {
			if(!isValid(r, c, num)) continue;
			board[r][c] = num;
			fill(idx+1);
			board[r][c] = 0;
		}		
	}
	private static boolean isValid(int r, int c, int num) {
		for(int i=0; i<9; i++) {
			if(board[r][i] == num) return false;
		}
		for(int i=0; i<9; i++) {
			if(board[i][c] == num) return false;
		}
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for (int i=sr; i<sr+3; i++) {
			for (int j=sc; j<sc+3; j++) {
				if (board[i][j] == num) return false;
			}
		}
		return true;
	}
}