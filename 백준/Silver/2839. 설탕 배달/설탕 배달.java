import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 정확하게 N킬로그램을 배달해야 하며
 * 5킬로그램 봉지와 3킬로그램 봉지가 있다. 최대한 적은 봉지로 가져가려면 어떻게 해야하는가?
 * 흐음 만약 5로 나눴을 때 남는 나머지가 1이라면 하나 더하고 3두개로 해결이 가능하다. 즉 나눈 몫에서 더하기 1
 * 남는 나머지가 2라면 2개를 추가하고 3킬로 그램 4개를 추가하면 된다. 나눈 몫에서 더하기 2
 * 남는 나머지가 3이라면 그냥 3킬로그램을 추가하면 된다. 나눈 몫에서 더하기 1
 * 남는 나머지가 4라면 2개를 더해준다. 나눈 몫에서 더하기 2
 */


public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int answer = N/5;
    	int a = N%5;
    	if(N==1 || N==2 || N==4 || N==7) {
    		a=0;
    		answer = -1;
    	}
    	if(a==1) answer++;
    	else if(a==2) answer=answer+2;
    	else if(a==3) answer++;
    	else if(a==4) answer=answer+2;
    	System.out.println(answer);
    }
}