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
import java.io.FileInputStream;
/**
 * 
 * 민기는 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때
 * 좋아하는 햄버거를 먹으면서도 정해진 칼로리 이하의 조합 중에서 가장 선호하는 햄버거를 조합해주자.
 * 
 * 
 * 해결방법
 * 첫 번째로 테스트 케이스의 수를 입력받는다.
 * 두 번쨰로 재료 개수와 함께 정해진 칼로리를 입력받는다.
 * 이제 재료들을 입력받으면서 칼로리를 더하다가 제한 칼로리가 될 때 탈출한다.
 * 이 리스트를 모아서 가장 큰 선호도의 값이 나오면 종료한다.
 * 
 * 
 * 처음 입력을 N과 L로 입력받는다. 입력을 받아 내가 앞으로 입력받을 케이스의 개수
 * 칼로리의 한계치를 입력받는다.
 * 그 다음 맛의 만족도를 입력받는 배열을 만들고 재료를 사용할때마다 쓰이는 칼로리도 따로 입력받는다.
 * 최종값으로 쓸 변수를 선언한다.
 * 
 * 이후 재귀를 돌면서 하나하나 체크한다.
 * 재귀를 돌면서 만족도를 더하면서 진행, 하나는 칼로리를 더하면서 진행하도록 한다.
 * 제한 칼로리를 넘는 조합은 return하고 아닌경우에는 들어가 있는 값인 ans와 비교해서
 * 더 높은 만족도만을 남긴다.
 * 
 */


import java.util.Scanner;

public class Solution {
    static int N, L;
    static int[] score;
    static int[] cal;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 재료의 수
            L = sc.nextInt(); // 제한 칼로리
            score = new int[N];
            cal = new int[N];

            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            hamSum(0, 0, 0);

            System.out.println("#" + tc + " " + ans);
            ans = 0;
        }
    }

    private static void hamSum(int idx, int sumt, int sumc) {
        if (sumc > L)
            return;
        if (idx == N) {
            if (sumt > ans) {
                ans = sumt;
            }
            return;
        }

        hamSum(idx + 1, sumt + score[idx], sumc + cal[idx]);
        hamSum(idx + 1, sumt, sumc);
    }
}