import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * 둘째 줄에는 중앙값을 출력한다.
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * 넷째 줄에는 범위를 출력한다.
 * 조건을 잘 파악하고 구현하면 된다.
 */

public class Main {
	
	static int [] arr;
	static int N;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(one());
        System.out.println(two());
        System.out.println(three());
        System.out.println(four());
        
    }
    
    private static long one() {
    	double sum = 0;
    	for(int i=0; i<N; i++) {
    		sum = sum + (long)arr[i];
    	}
    	return Math.round((double) sum / N);
    }
    
    private static int two() {
    	return arr[N/2];
    }
    
    private static int three() {
        int[] count = new int[8001];
        int maxCount = 0;
        int mode = 0;

        for (int a : arr) {
            count[a + 4000]++;
            maxCount = Math.max(maxCount, count[a + 4000]);
        }

        boolean found = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                if (found) {
                    mode = i - 4000;
                    break;
                }
                found = true;
                mode = i - 4000;
            }
        }

        return mode;
    }
    
    private static int four() {
    	return arr[N-1]-arr[0];
    }

}