import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
 *  
 */
public class Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] check = new boolean[10001];
		
        for(int i=1; i<10001; i++) {
        	int n = selfNum(i);
        	
        	if(n < 10001){
				check[n] = true;
			}
        	
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<10001; i++) {
        	if(!check[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
	private static int selfNum(int N) {
		int sum = N;
		
		while(N != 0) {
			sum = sum + (N%10);
			N = N/10;
		}
		return sum;
	}
	
}