import java.util.Arrays;
import java.util.Scanner;


/*
 * 
 *  재료는 N개가 있다.
 *  각 재료에는 신맛S와 쓴맛 B를 알고 있고 신맛은 서로 곱하고 쓴맛은 서로 합친다.
 *  재료를 적어도 하나 이상은 사용해 차이가 가장 작은 요리를 만든다.
 *  
 *  우선 입력을 받고 난 다음 첫 번째 숫자는 곱하고 두 번째로 온 숫자는 지속적으로 더한다.
 *  어차피 2개이기 때문에 저는 for문을 돌도록 하겠습니다.
 *  for문을 돌면서 신맛을 모든 경우의 신맛과 쓴맛을 다 저장하고 값을 절대값에 씌운다음 크기를 비교한다.
 *  
 * 	가장 먼저 for문으로 재료의 개수 입력받기
 * 	이후 for문을 통해 1번째 숫자만 담는 배열 하나
 * 	2번째 숫자만 담는 배열 하나를 만든다.
 * 	부분집합을 중복없는 배열로 만든다음 그 수에 해당되는 숫자들을 꺼내고 비교한다.
 * 	첫 번째는 꺼낼 때 계속 곱하고 두 번째는 꺼낼 때 이미 있는 수에 더한다.
 * 
 */
public class Main {
	
	static int sin[];
	static int shit[];
	static boolean visited[];
	static int a = Integer.MAX_VALUE;
    static int N, cnt=1;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       N = sc.nextInt();

       sin = new int[N];
       shit = new int[N];
       visited = new boolean[N];
       for(int i=0; i<N; i++) {
    	   sin[i] = sc.nextInt();
    	   shit[i] = sc.nextInt();
       }
       
       combi(0, 1, 0);
       System.out.println(a);
       
    }
    
    private static void combi(int idx, int si, int sh) {
    	
    	if(idx != 0) {
    		a = Math.min(a, Math.abs(sh-si));
    	}
    	if(idx==N) {
    		return;
    	}
    	
    	for(int i=idx; i<N; i++) {
    		if(visited[i]==true) continue;
    		visited[i] = true;
    		
    		combi(idx+1, si * sin[i], sh+shit[i]);
    		visited[i] = false;
    	}
    }
    
}