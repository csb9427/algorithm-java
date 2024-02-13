import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 판의 크기인 N이 들어오고 폐업시키지 않아야 하는 치킨집의 개수 M이 들어온다.
 * 즉 M개의 개수를 제외하고 가장 치킨 거리가 긴 순으로 폐업을 시켜야만 한다.
 * 
 * 각 치킨집 별로 집과의 거리를 구한다. 집과의 거리들이 가장 먼 치킨집을 M개의 수가 나올 때까지
 * 빼주면 된다.
 * 
 * 치킨 거리 계산 식은 집의 위치 가로와 세로와 치킨집의 위치 가로와 세로를 서로 빼주고 절댓값을 씌운 후 더해준다.
 * 즉 치킨 거리를 다 더한 후 해당 치킨집을 지우고 나면 된다.!
 * 
 * 집들의 위치를 저장할 때 애초에 i와 j로 계산해두고 치킨 집 하나당 비교하며 계산해 나간다.
 */


public class Main {
	static int [][] arr;
	static int [][] home;
	static int [][] chicken;
	static int [][] sum;
	static boolean[] selected;
	static int minChickenDistance = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int hNum = 0;
    	int cNum = 0;
    	arr = new int[N][N];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j]==1) hNum++;
    			else if(arr[i][j]==2) cNum++;
    		}
    	}
    	home = new int[hNum][2];
    	chicken = new int[cNum][2];
    	int num = 0;
    	int num2 = 0;
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(arr[i][j]==1) {
    				home[num][0] = i+1;
    				home[num][1] = j+1;
    				num++;
    			}
    			else if(arr[i][j]==2) {
    				chicken[num2][0] = i+1;
    				chicken[num2][1] = j+1;
    				num2++;
    			}
    		}
    	}
    	
    	sum = new int[hNum][cNum]; 
    	for(int i=0; i<hNum; i++) {
    		for(int j=0; j<cNum; j++) {
    			sum[i][j] = Math.abs(home[i][0]- chicken[j][0])+Math.abs(home[i][1] - chicken[j][1]);
    		}
    	}
    	
    	 selected = new boolean[cNum];
         selectChicken(0, cNum, M, 0);

         System.out.println(minChickenDistance);
    	
    }
    
    static void selectChicken(int index, int cNum, int M, int count) {
        if (count == M) {
            int minSum = calculateMinSum(sum, selected);
            minChickenDistance = Math.min(minChickenDistance, minSum);
            return;
        }
        if (index == cNum) return;

        selected[index] = true;
        selectChicken(index + 1, cNum, M, count + 1);

        selected[index] = false;
        selectChicken(index + 1, cNum, M, count);
    }
    
    static int calculateMinSum(int[][] sum, boolean[] selected) {
        int minSum = 0;
        for (int i = 0; i < home.length; i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < selected.length; j++) {
                if (selected[j]) {
                    minDist = Math.min(minDist, sum[i][j]);
                }
            }
            minSum += minDist;
        }
        return minSum;
    }
}