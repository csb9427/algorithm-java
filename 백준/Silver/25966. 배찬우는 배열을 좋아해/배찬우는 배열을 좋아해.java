import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] answer;
	static int n, m, q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		answer = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				answer[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int c = 0; c < q; c++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (first == 0) {
				int k = Integer.parseInt(st.nextToken());
				answer[i][j] = k;
			} else {
				int[] tmp = answer[i];
				answer[i] = answer[j];
				answer[j] = tmp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}