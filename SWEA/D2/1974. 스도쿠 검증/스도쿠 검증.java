import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
 * 9*9 배열을 입력받는다.
 * 이 배열을 각 배열에서 겹치는 숫자가 없으면 성공이다. 또한 3*3에서도 겹치는 숫자는 있으면 안된다.
 * 
 * 결국 그 범위가 더했을 때 45라는 숫자가 나오지 않는다면 0을 출력하면 된다.
 * 
 */

import java.util.StringTokenizer;

public class Solution {
	
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int answer = 1;
    	int sum = 1;
    	int check[];
    	int T = Integer.parseInt(br.readLine());
    	for(int t=0; t<T; t++) {
    	int arr[][] = new int[9][9];
    		for(int i=0; i<9; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<9; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		check = new int[9];
    		for(int i=0; i<9; i++) {
    			for(int j=0; j<9; j++) {
    				check[j] = arr[i][j];
    			}
    			Arrays.sort(check);
    			sum = 1;
    			for(int k=0; k<9; k++) {
    				sum *=check[k];
    			}
    			for(int k=0; k<9; k++) {
    				if(check[k]!=k+1 || sum!=362880) {
    					answer = 0;
    					sum = 1;
    					break;
    				}
    			}
    		}
    		check = new int[9];
    		for(int i=0; i<9; i++) {
    			for(int j=0; j<9; j++) {
    				check[j] = arr[j][i];
    			}
    			Arrays.sort(check);
    			sum = 1;
    			for(int k=0; k<9; k++) {
    				sum *=check[k];
    			}
    			for(int k=0; k<9; k++) {
    				if(check[k]!=k+1 || sum!=362880) {
    					answer = 0;
    					sum = 1;
    					break;
    				}
    			}
    		}
            boolean valid = true;
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    boolean[] present = new boolean[10];
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            if (present[arr[x][y]]) {
                                valid = false;
                                break;
                            }
                            present[arr[x][y]] = true;
                        }
                    }
                    if (!valid)
                        break;
                }
                if (!valid)
                    break;
            }
            if (!valid)
                answer = 0;
    		

    		
    		System.out.printf("#%d %d \n", t+1, answer);
    		answer = 1;
    	}
    	
    }


}