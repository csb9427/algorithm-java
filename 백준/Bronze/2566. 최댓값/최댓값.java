import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int answer = 0;
	static int a; 
	static int b = 1, c = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9; j++) {
				a = Integer.parseInt(st.nextToken());
				if(a>answer) {
					answer = a;
					b = i;
					c = j;
				}
			}
		}
		System.out.println(answer);
		System.out.print(b +" "+c);
	}
}