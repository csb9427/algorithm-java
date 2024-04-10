import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 치킨 배달
 * 크기가 N * N인 도시가 있다.
 * 각 칸은 빈 칸, 치킨집, 집 중 하나이다.
 * 도시의 칸은 (r,c)고 1부터 시작한다.
 * 치킨 거리는 가장 가까운 치킨집과의 거리이다.
 * 
 * 도시의 치킨 거리는 집의 r값과 치킨집의 r값을 뺴고 계산하는 것이다.
 * 
 * 치킨집의 개수를 최대 M개를 유지하면서 동시에 일부 치킨집을 폐업 시킨다.
 * 
 * 도시의 치킨 거리가 가장 적게 될 치킨 거리를 구하시오
 * 
 * 도시의 정보는 0은 빈칸 1은 집 2는 치킨집을 의미한다.
 * 
 * 이 문제는 가장 먼저 조합이다. 조합으로 각 치킨집이 될 조합을 구하고
 * 치킨 거리를 구하도록 한다.
 * 
 * 1의 위치를 기억해야 한다.
 *
 * 
 */

public class Main {
	
	static int N, M, hSize=0, cSize = 0;
	static int [][]map;
	static boolean [][]home;
	static boolean [][]chicken;
	static boolean [] check;
	static int ans = Integer.MAX_VALUE;
	static int[][] choiceChicken;
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        home = new boolean[N+1][N+1];
        chicken = new boolean[N+1][N+1];
        
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j]==1) {
        			home[i][j] = true;
        			hSize++;
        		}
        		else if(map[i][j] == 2) {
        			chicken[i][j] = true;
        			cSize++;
        		}
        	}
        }
        choiceChicken = new int[cSize + 1][2];
        int idx = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (chicken[i][j]) {
                	choiceChicken[idx][0] = i;
                	choiceChicken[idx][1] = j;
                    idx++;
                }
            }
        }
        
        check = new boolean[cSize+1];
        
        answer(1, 0);
        
        System.out.println(ans);
    }
    
    
    private static void answer(int x, int count) {
        if(count == M) {
            int t = 0;
            
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(home[i][j]) {
                        int min = Integer.MAX_VALUE;
                        for (int k = 1; k <= cSize; k++) {
                            if (check[k]) {
                                int l = choiceChicken[k][0];
                                int m = choiceChicken[k][1];
                                int d = Math.abs(i - l) + Math.abs(j - m);
                                min = Math.min(min, d);
                            }
                        }
                        t += min;
                    }
                }
            }
            ans = Math.min(ans, t);
        }
        
        for (int i = x; i <= cSize; i++) {
            check[i] = true;
            answer(i + 1, count + 1);
            check[i] = false;
        }
    }

}