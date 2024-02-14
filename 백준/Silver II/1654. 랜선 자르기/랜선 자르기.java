import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * K개의 랜선을 가지고 있다. 이 랜선의 길이는 제 각각이라 N개의 같은 길이의 랜선으로 만들고 싶어한다.
 * 항상 N개를 만들수 있다.
 * 랜선의 길이는 2의31승-1까지 가능하다.
 * K는 1이상 10000이하의 정수이고 N은 1이상 1000000이하의 정수이다.
 * 
 * 이분탐색으로 항상 10000부터 시작해서 나누기를 하면서 푸는 문제인 것 같다.
 * 그렇게 개수가 맞는지를 체크하고 맞게 된다면 그때 길이를 출력한다.
 * 개수가 적다면 길이를 줄이고 개수가 많다면 길이를 늘린다.
 * 
 * 된다고 해서 무조건 출력이 아닌 숫자를 1씩 올려가며 최소의 길이를 체크해야한다.
 */

public class Main {
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long answer = binarySearch(1, arr[K - 1], N);
        System.out.println(answer);
    }

    private static long binarySearch(long start, long end, long N) {
        long result = 0;
        while (start <= end) {
        	long mid = (start + end) / 2;
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (count >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}