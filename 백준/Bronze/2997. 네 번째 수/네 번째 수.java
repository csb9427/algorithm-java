import java.util.*;
import java.io.*;

public class Main {
	
	static int[] N = new int[3];
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
        	N[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(N);
        int a = N[1] - N[0];
        int b = N[2] - N[1];
        if(a==b) System.out.println(N[2]+b);
        if(a>b) System.out.println(N[0]+b);
        else if(a<b) System.out.println(N[1]+a);
    }
}