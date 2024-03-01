import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static int N, M;
	static int[][] DNA;
	static char[] answer;
	static int count = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        DNA = new int[N][M];
        answer = new char[M];
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	for(int j=0; j<M; j++) {
        		DNA[i][j] = s.charAt(j);
        	}
        }
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		if(DNA[j][i]==65) count1++;
        		else if(DNA[j][i]==67) count2++;
        		else if(DNA[j][i]==71) count3++;
        		else count4++;
        	}
        	if(count1>=count2 && count1>=count3 && count1>=count4) answer[i] = 'A';
        	else if(count2>count1 && count2>=count3 && count2>=count4) answer[i] = 'C';
        	else if(count3>count1 && count3>count2 && count3>=count4) answer[i] = 'G';
        	else if(count4>count1 && count4>count2 && count4>count3) answer[i] = 'T';
        	
        	count1 = 0;
            count2 = 0;
            count3 = 0;
            count4 = 0;
        }
        
        for(int i=0; i<M; i++) {
        	for(int j=0; j<N; j++) {
        		if(answer[i]!=DNA[j][i]) count++;
        	}
        }
        for(int i=0; i<M; i++) {
        	System.out.print(answer[i]);
        }
        System.out.println();
        System.out.println(count);
    }
  
    
}