import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 스택을 통해 가능하다.
 * 확인하지 않아도 되는 공간의 기준은 첫 날이거나 다음 숫자가 현재의 숫자보다 큰 경우가 있을 수 있다.
 * 그렇기에 쓰지 않는 숫자는 pop을 하면서 진행하고 가장 큰 숫자가 있는 위치의 값을 넣거나 방금 전 숫자를 확인면서 진행한다.
 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i, top}); 
        }
    }
}