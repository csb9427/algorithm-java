import java.util.Arrays;
import java.util.Scanner;


/*
 * 	메모리: 13232	시간: 120
 * 
 *  A C G T로 이루어진 문자열을 DNA문자열이라고 한다.
 *  각 문자열마다 조건이 주어지고 문자열이 주어졌을 때 이안에서 몇가지의 경우의 수가 나오는
 *  지 말해야 하는 문제이다.
 *  
 *  처음에 문자열의 길이 S와 비밀번호로 사용할 문자열의 길이 P가 주어진다.
 *  순서대로 몇 개 이상이 포함되어야 하는 지 뜨게 된다.
 *  
 *  풀이
 *  처음에 문자열 1부터 P까지 이동시킨다. 이후 문자열을 한칸씩 이동하면서 조건에 해당하는 지 체크한다
 *  그다음 출력한다.
 *  
 */
public class Main {
	
	static String st;
	static int S;
	static int P;
	static int A;
	static int C;
	static int G;
	static int T;
	static int a = 0;
	static int c = 0;
	static int g = 0;
	static int t = 0;
	static int count = 0;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       S = sc.nextInt();
       P = sc.nextInt();
       st = sc.next();
       A = sc.nextInt();
       C = sc.nextInt();
       G = sc.nextInt();
       T = sc.nextInt();
       
       for(int j=0; j<P; j++) {
		   if(st.charAt(j)=='A') a++;
    	   if(st.charAt(j)=='C') c++;
    	   if(st.charAt(j)=='G') g++;
    	   if(st.charAt(j)=='T') t++;
    	   if(A<=a && C<=c && G<=g && T<=t && j==P-1) {
    		   count++;
    	   }
	   }

       for(int i=1; i<st.length()-P+1; i++) {
    	   if(st.charAt(i-1)=='A') a--;
    	   if(st.charAt(i-1)=='C') c--;
    	   if(st.charAt(i-1)=='G') g--;
    	   if(st.charAt(i-1)=='T') t--;
    	   if(st.charAt(P+i-1)=='A') a++;
    	   if(st.charAt(P+i-1)=='C') c++;
    	   if(st.charAt(P+i-1)=='G') g++;
    	   if(st.charAt(P+i-1)=='T') t++;
    	   if(A<=a && C<=c && G<=g && T<=t) {
    		   count++;
    	   }
       }
       
       System.out.println(count);
    }
    
    
    
}