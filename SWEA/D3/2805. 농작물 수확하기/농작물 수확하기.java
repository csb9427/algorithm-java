/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int sum = 0;
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                String str = sc.next();
                for (int k = 0; k < str.length(); k++) {
                    arr[j][k] = str.charAt(k) - '0';
                }
            }

            for (int d = 0; d < N / 2; d++) {
                for (int e = N / 2 - d; e <= (N / 2 + d); e++) {
                    sum += arr[d][e];
                }
            }

            for (int d = N / 2; d >= 0; d--) {
                for (int e = N / 2 - d; e <= N / 2 + d; e++) {
                    sum += arr[N - d - 1][e];
                }
            }

            System.out.printf("#%d %d%n", i, sum);
        }
    }
}