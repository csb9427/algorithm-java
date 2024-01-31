/*
 * N * N개의 수가 표에 채워져 있음
 * (x, y) + (x-1, y)+ (x, y-1) - (x-1, y-1)
 * i번째부터 j번째 까지의 합
 * arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1]
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a;
    static int b;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[a + 1][a + 1];

        // 배열 입력
        for (int i = 1; i <= a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= a; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        // 질문에 대한 답 출력
        for (int i = 1; i <= b; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1]);
        }

        br.close();
    }
}