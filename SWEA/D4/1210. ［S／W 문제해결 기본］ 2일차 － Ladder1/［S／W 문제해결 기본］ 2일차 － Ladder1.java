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
    static int[][] a = new int[100][100];
    static int p = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int o = 1; o <= 10; o++) {
            p = sc.nextInt();
            int b = 0;
            int c = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    a[i][j] = sc.nextInt();
                    if (a[i][j] == 2) {
                        b = i;
                        c = j;
                    }
                }
            }
            while (b > 0) {
                if (c - 1 >= 0 && a[b][c - 1] == 1) {
                    while (c - 1 >= 0 && a[b][c - 1] == 1) {
                        c = c - 1;
                    }
                } else if (c + 1 < 100 && a[b][c + 1] == 1) {
                    while (c + 1 < 100 && a[b][c + 1] == 1) {
                        c = c + 1;
                    }
                }
                b = b - 1;
            }

            System.out.println("#" + p + " " + c);
        }
    }
}