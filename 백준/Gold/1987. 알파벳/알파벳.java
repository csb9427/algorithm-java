import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다.
 * 각 칸에는 대문자 알파벳이 하나씩 있고, 좌측 상단 1, 1에는 말이 있다.
 * 
 * 최대 몇 칸 이동이 가능한지 확인하시오.
 * 
 * [문제 해결 프로세스]
 * DFS를 사용해 풀 수 있다.
 * 처음에 그냥 알파벳으로 저장하지 말고 숫자로 저장한 다음 알파벳이 26개니까 해당 숫자가 나오면 그떄 boolean을 true로 바꿔주기
 * 
 * 
 * 만약 방문한 알파벳이라면 똑같은 알파벳일 경우 상하 좌우를 탐색하며 이동한다.
 * 끝까지 다다르거나 더 이상 이동이 불가능하다면 다시 전의 위치로 이동하며 재 탐색을 실행한다.
 * 
 */

public class Main {
    
	static char[][] board;
	
	static int R;
	static int C;
	
	static int []dx = {-1, 1, 0, 0};
	static int []dy = {0, 0, -1, 1};
	
	static boolean[] checked = new boolean[26];
	
	static int answer = 0;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		board = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        
        checked[board[0][0] - 'A'] = true;
		
		DFS(0, 0, 1);
		System.out.println(answer);
    }
    
    private static void DFS(int r, int c, int count) {
    	
    	answer = Math.max(answer, count);
		
    	for(int i=0; i<4; i++){
    		int nr = r + dx[i];
    		int nc = c + dy[i];
    		
    		if(nr<0 || nr==R || nc<0 || nc==C) continue;
    		if(checked[board[nr][nc] - 'A']) continue;
    		
    		checked[board[nr][nc] - 'A'] = true;
			DFS(nr, nc, count+1);
			checked[board[nr][nc] - 'A'] = false;
    	}
    	
    	
    }
    
    
}