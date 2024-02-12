import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 마지막에는 1로 들어와야 하기때문에 중간부터는 값이 감소해야만 한다.
 * 규칙을 찾아보면 1, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 과 같은 규칙성을 가지고 있기 때문에 충분히 찾을 수 있다.
 * 제곱을 기준으로 한다는 규칙성을 검색을 통해 알았다 ㅋㅋ 흐음 원래 생각한 답안은 반복되는 시점이 1/1/2/2/3/3/4/4
 * 와 같이 늘어나는 것을 기준으로 잡았는데 아마 그렇게 해도 가능했겠지만 조금 더 효율적으로 구성하고자 제곱일 때
 * 를 기준으로 바뀐다는 규칙성을 활용해 코드를 짜
 */

public class Main {
	
	static int [] arr;
	static int N;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int a = y-x;
        	int sa = (int)Math.sqrt(a);
            
            if(a == sa * sa){
                sb.append(2*sa - 1).append("\n");
            } 
            
            else if (a <= sa*sa + sa ){
                sb.append(2*sa).append("\n");
            }
            
            else {
                sb.append(2*sa + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}