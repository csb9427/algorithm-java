import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * 	1번부터 N번까지 N명의 사람이 원을 이루면서 있다. 
 * 순서대로 K번째 사람을 제거하고 남는 사람이 없을때까지 진행한다.
 * 
 * 리스트를 만든다.
 * 리스트에 값을 넣고 하나씩 빼주며 출력한다.
 *  
 */
public class Main {

	static int N;
	static int K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new ArrayDeque<Integer>();

		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while (!queue.isEmpty()) {
			if(N==1) {
				System.out.println("<1>");
				break;
			}
			for (int i = 0; i < K; i++) {
				if(i!=K-1) {
					queue.offer(queue.peek());
					queue.poll();
				}
				else {
					if(queue.size()==1) {
						System.out.printf("%d>", queue.poll());
					}
					else if(queue.size()==N) {
						System.out.printf("<%d, ", queue.poll());
					}
					else {
						System.out.printf("%d, ", queue.poll());
					}
					
				}
				
			}
		}

	}

}