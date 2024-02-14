import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
 *
 */


public class Main {
	
	static int []a;
	static int []b;
	static int []answer;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	int count=1;
    	int N = Integer.parseInt(br.readLine());
    	a = new int[N];
    	b = new int[N];
    	answer = new int[N];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		a[i] = Integer.parseInt(st.nextToken());
    		b[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(i!=j) {
    				if(a[i]<a[j] && b[i]<b[j]) count++;
    			}
    		}
    		answer[i] = count;
    		count=1;
    	}
    	for(int i=0; i<N; i++) {
    		System.out.print(answer[i]+" ");
    	}
    }
    
}