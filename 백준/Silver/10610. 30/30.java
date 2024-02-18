import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int arr[] = new int[N.length()];
		int count = 0;
		for(int i=0; i<N.length(); i++) {
			arr[i] = N.charAt(i) - '0';
			count += arr[i];
		}
		Arrays.sort(arr);
		if((count % 3 == 0) && (arr[0]==0)) {
			for(int i=N.length()-1; i>-1; i--) {
				System.out.print(arr[i]);
			}
		}
		else System.out.println(-1);
	}

}