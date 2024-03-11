import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] check = new boolean[42];
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, count=0;
        for(int i=0; i<10; i++) {
        	N = Integer.parseInt(br.readLine());
        	check[N%42] = true;
        }
        for(int i=0; i<42; i++) {
        	if(check[i] == true) count++; 
        }
        System.out.println(count);
    }
}