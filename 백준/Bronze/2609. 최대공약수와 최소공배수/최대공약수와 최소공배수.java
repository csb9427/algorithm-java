import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int A;
	static int B;

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        int a = A;
        int b = B;
        
        while(A % B != 0) {
        	int temp = A % B;
        	A = B;
        	B = temp;
        }
        System.out.println(B);
        
        a = a/B;
        b = b/B;
        
        System.out.println(a*b*B);
    }

}