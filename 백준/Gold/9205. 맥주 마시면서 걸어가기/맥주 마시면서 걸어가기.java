import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 편의점에 들리는 좌표를 저장함
 * 
 * node로 arrayList로 만든다.
 * node의 값 내부에서 거리값을 반환하는 코드와 행복하게 갈 수 있는 방법을 찾아야 한다.
 * 좌표값을 저장한 다음 좌표를 이동하면서 각 좌표들로 이동이 가능한지 체크한다.
 * 플로이드 와샬을 사용해 모든 경유지를 고려한 행복하게 이동이 가능한지 체크한다.
 * 
 * 1. 좌표의 정보를 저장한다.
 * 2. 좌표 정보를 사용해 다음 좌표로 이동이 가능한지 체크한다.
 * 3. i부터 j까지 행복하게 갈 수 있는지 여부
 * 4. 플로이드 와샬 사용해 모든 경유지를 고려한 행복하게 이동이 가능한지 여부를 갱신한다.
 * 5. 경유지 -> 출발지 -> 도착지
 * 
 */

public class Main {
    static List<int[]> list = new ArrayList<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            list.clear();
            int n = Integer.parseInt(br.readLine()); 

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new int[]{r, c});
            }

            boolean[][] d = new boolean[n + 2][n + 2]; 
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    d[i][j] = isPossible(list.get(i), list.get(j));
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = i; j < n + 2; j++) {
                        if (d[i][k] && d[k][j]) {
                            d[i][j] = true;
                            d[j][i] = true;
                        }
                    }
                }
            }

            System.out.println(d[0][n + 1] ? "happy" : "sad");
        }
    }

    private static boolean isPossible(int[] a, int[] b) {
        return (Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1])) <= 1000;
    }
}