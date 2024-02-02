import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/**
 * 
 * 
 * 8개의 숫자를 입력받는다.
 * 첫 번쨰 숫자를 1감소한 뒤, 맨 뒤로 보내고 다음 첫번째의 수는 2감소 3감소, 4,감소하며 사이클을 돈다.
 * 그렇게 넘기다 첫 번째 숫자가 0이거나 0보다 작아지면 뒤로 보내며 탈출한다.
 * 
 * while문을 통해 숫자를 1씩 늘려가며 계속해서 리스트에서 숫자를 뺀다. 
 * 이후 0보다 작은 수가 나오면 바로 탈출하고 해당 큐를 출력한다.
 * 
 */

public class Solution {
   
    static int T;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        for(int j=0; j<10; j++) {
        	T = sc.nextInt();
        	int a = 1;
        	int b = 0;
        	Queue<Integer> queue = new ArrayDeque<>();
        	for(int i=1; i<=8; i++) {
        		b = sc.nextInt();
            	queue.offer(b);
            }
            while(queue.peek()>0) {
            	if(queue.peek()- a <=0) break;
            	queue.offer(queue.poll()-a);
            	if(a==5) a = 0;
            	a++;
            }
            
            queue.poll();
            queue.offer(0);
            System.out.printf("#");
        	System.out.printf("%d ", T);
            while (!queue.isEmpty()) {
                System.out.printf("%d ", queue.poll());
            }
            System.out.println();
        }
        
    }
}