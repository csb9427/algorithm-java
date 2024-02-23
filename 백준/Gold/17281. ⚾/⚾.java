import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



/*
 * 야구
 * 9명으로 이루어진 두 팀과 수비를 번갈아 하는 게임이다.
 * 총 N이닝 동안 게임을 진행한다 3아웃이 발생하면 공격과 수비를 서로 바꾼다.
 * 9번 타자까지 다 공을 쳤는데 3아웃이 안나왔으면 다시 1번 타자부터 타석에 선다.
 * 타순은 이닝이 변경되어도 유지된다. 마지막 타자가 3아웃이 되었다면 그 다음 타자 번호부터 타석에 선다.
 * 
 * 공격팀의 선수가 1루 2루 3루 거쳐서 홈에 도착하면 1점
 * 머무를 수도 있다.
 * 
 * 안타: 타자와 모든 주자가 한 루씩 진루한다.
 * 2루타: 타자와 모든 주자가 두 루씩 진루한다.
 * 3루타: 타자와 모든 주자가 세 루씩 진루한다.
 * 홈런: 타자와 모든 주자가 홈까지 진루한다.
 * 아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
 * 
 * 가장 많은 득점을 하는 타순을 찾고 그 때의 득점을 구한다.
 * 
 * [문제 해결 프로세스]
 * 1. 가장 먼저 N입력받기
 * 2. 순열로 모든 경우의 수를 만든다
 * 	=> 이 때 중요한 점은 1번타자를 4번째 순서에 고정해둔다.
 * 3. 10명의 배치가 완료되면 game으로 이동하고 진행한다.
 * 
 * 
 * 
 */

public class Main {
	static int N;
	static int [][]bollBoy;
	
	static int[] picked = new int[10];
	static boolean[] isSelected = new boolean[10];
	
	static int maxScore;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        bollBoy = new int[N+1][10];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=9; j++) {
        		bollBoy[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        picked[4] = 1;
        permu(1);
        
        System.out.println(maxScore);
    }
    private static void permu(int idx) {
		if(idx==10) {
			game();
			return;
		}
		
		for(int i=2; i<=9; i++) {
			if(isSelected[i]) continue;
			
			picked[idx] = i;
			isSelected[i]=true;
			permu(idx==3? idx+2: idx+1);
			isSelected[i]=false;
		}
	}
    private static void game() {
        int score = 0;
        int inning = 1;
        int battingNum = 1;
        int outCnt = 0;
        boolean[] isBase = new boolean[4];
        while(inning<=N) {
            int playerNum = picked[battingNum];
            int result = bollBoy[inning][playerNum];
            if(result==0) {
                if(++outCnt == 3) {
                    inning++;
                    outCnt=0;
                    for(int i=1; i<=3; i++) isBase[i] = false;
                }
            }
            
            else if(result==1) {
                if(isBase[3]) score++;
                isBase[3] = isBase[2];
                isBase[2] = isBase[1];
                isBase[1] = true;
            }
            
            else if(result==2) {
                if(isBase[3]) score++;
                if(isBase[2]) score++;
                isBase[3] = isBase[1];
                isBase[1] = false;
                isBase[2] = true;
            }
            
            else if(result==3) {
                if(isBase[3]) score++;
                if(isBase[2]) score++;
                if(isBase[1]) score++;
                isBase[2] = false;
                isBase[1] = false;
                isBase[3] = true;
            }
            
            else {
                if(isBase[3]) score++;
                if(isBase[2]) score++;
                if(isBase[1]) score++;
                score++;
                for(int i=1; i<=3; i++) isBase[i] = false;
            }
            
            battingNum = battingNum%9 + 1;
        }
        
        maxScore = Math.max(maxScore, score);
    }

}