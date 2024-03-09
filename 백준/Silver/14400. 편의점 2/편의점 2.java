import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long answer = 0;
	static int[] x;
	static int[] y;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken());
		x = new int[N];
		y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x);
		Arrays.sort(y);

		int medianX = x[N / 2];
		int medianY = y[N / 2];

		for (int i = 0; i < N; i++) {
			answer += Math.abs(medianX - x[i]);
			answer += Math.abs(medianY - y[i]);
		}

		System.out.print(answer);
	}
}