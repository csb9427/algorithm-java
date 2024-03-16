import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[D];
        sum[D - 1] = K;
        int A = 1;

        while (true) {
            sum[0] = A;
            for (int i = A; i < K; i++) {
                sum[1] = i;
                for (int j = 2; j < D - 1; j++) {
                    sum[j] = sum[j - 1] + sum[j - 2];
                }
                if (sum[D - 1] == sum[D - 2] + sum[D - 3]) {
                    System.out.println(sum[0]);
                    System.out.println(sum[1]);
                    return;
                }
            }
            A++;
        }
    }
}