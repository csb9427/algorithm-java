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
 *
 */


public class Main {
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	Stack<Integer> s = new Stack<>();
    	int sum = 0;
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		int a = Integer.parseInt(br.readLine());
    		if(a>0) s.add(a);
    		else s.pop();
    	}
    	for(int i=0; i<s.size(); i++) {
    		sum += s.get(i);
    	}
    	System.out.println(sum);
    }
    
}