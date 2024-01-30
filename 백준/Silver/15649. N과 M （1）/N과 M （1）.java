import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	
	static int[] picked; 
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		picked = new int[M];
		isSelected = new boolean[N+1];
		permu(0);
	}
	
	private static void permu(int idx) {
		if(idx==M) {
			for(int i=0; i<picked.length; i++) {
				System.out.print(picked[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			
			picked[idx] = i;
			isSelected[i]=true;
			permu(idx+1);
			isSelected[i]=false;
		}
	}

}