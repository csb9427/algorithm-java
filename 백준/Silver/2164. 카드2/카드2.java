import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/**
 * N장의 카드가 주어지고 카드의 번호는 1부터 N까지의 숫자이다.
 * 카드의 순서대로 남아있고 제일 위에 있는 카드는 버린다.
 * 이후 위에 있는 카드를 아래에 넘기고 마지막에 남는 카드의 숫자가 몇인지를 맞추면 된다.
 * 
 * 짝수면 처음부터 끝까지 홀수에 있는 숫자는 전부 지운다. 
 * 홀수면 처음부터 끝까지 홀수에 있는 숫자를 전부 지우고 다음은 짝수를 다 지우고 다음은 홀수로 다 지운다.
 *        4  6 2         8 
 * 1이면 1 2이면 2, 3이면 2, 4이면 4, 5면 4, 6이면 4, 7이면  6 8이면    8       4  6 8 4
 * 
 * Queue를 사용해서 앞에는 삭제하고 동시에 2번째 숫자는 뒤로 보낸다 그렇게 계산하다가 1장만 남으면 그 카드 출력
 */

public class Main {
   
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        N = sc.nextInt();
        for(int i=1; i<=N; i++) {
        	queue.offer(i);
        }
        while(queue.size()!=1) {
        	queue.poll();
        	queue.offer(queue.poll());
        	
        }
        System.out.println(queue.peek());
    }
}