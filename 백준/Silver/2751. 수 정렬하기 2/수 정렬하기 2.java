import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
 * 첫 번째 줄에는 테스트 케이스가 주어진다.
 * 이를 입력받을 배열을 만들고 값을 넣은 후 정렬해준다.
 * Arrays.sort는 안된다...
 *  
 */
public class Main {
	
	static int N;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
	
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);

		for(Integer c : list) {
			sb.append(c).append("\n");
		}
		
		System.out.println(sb);
	}

}