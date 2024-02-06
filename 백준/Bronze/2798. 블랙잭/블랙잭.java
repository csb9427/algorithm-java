/* 
 * N장의 카드가 있고 여기서 3장을 골라야 한다. 고른 카드의 합은 M을 넘지 않으며
 * 가장 가깝게 만들어야한다.
 * 
 * 카드 수 N 합의 크기 M
 * 3장을 뽑아 조합
 * 
 * 카드의 개수가 100이기 떄문에 최대 백만의 조합이 생긴다. 
 * 결국 완전 탐색으로 해도 된다.
 * 첫 번째 카드를 뽑고 두 번째 카드를 뽑고 세 번쨰 카드를 
 * 서로 다른 걸 뽑으면서 M과 비교후 가장 적합한 수를 만든다.
 */


import java.util.Scanner;

public class Main {
   
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N, M;
        int sum = 0;
        int min=10000000;
        int card[];
        N = sc.nextInt();
        M = sc.nextInt();
        card = new int[N];
        
        for(int i=0; i<N; i++) {
        	card[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		for(int k=0; k<N; k++) {
        			if(i!=j && j!=k && i!=k) {
        				sum = card[i]+card[j]+card[k];
        				if(min>=Math.abs(M-sum) && sum<=M) {
        					min = Math.abs(M-sum);
        				}
        			}
        		}
        	}
        }
        System.out.println(M-min);
        
    }

}