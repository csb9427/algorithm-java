import java.util.*;
import java.io.*;

public class Main {
	
	static int[] num = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num[0] = 0;
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;

        for (int i = 4; i < 11; i++) {
            num[i] = num[i - 1] + num[i - 2] + num[i - 3];
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(num[a]);
        }
    }
}