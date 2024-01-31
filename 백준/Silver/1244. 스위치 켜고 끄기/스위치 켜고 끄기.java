import java.util.Scanner;

// 스위치 켜고 끄기
// 1은 스위치가 켜진 상태, 0은 스위치가 꺼진 상태
// 남학생은 스위치 번호가 받은 수의 배수이면 스위치 상태를 바꾼다.
// 여학생은 받은 수의 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을
// 찾아서 그 구간에 속한 스위치의 상태를 모두 바꾼다


// 스위치의 개수는 100이하 첫 줄에 주어짐
// 1, 0 스위치의 상태를 준다.
// 학생 수 입력
// 남학생은 1 여학생은 2로 성별과 함께 스위치 숫자를 준다.
// 마지막 출력에서 20단위로 끊어서 출력한다.

// 주의해야 할 점: 스위치는 1부터 시작함
// 그리고 20번 이후의 스위치는 줄바꿈을 해야함



public class Main {

	static int s, a, man, manInput;
	static int [] sa;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		sa = new int[s+1];
		sa[0] = 1000;
		for(int i=1; i<=s; i++) {
			sa[i] = sc.nextInt();
		}
		a = sc.nextInt();
		for(int i=0; i<a; i++) {
			man = sc.nextInt();
			manInput = sc.nextInt();
			if(man==1) {
				for(int j=manInput; j<sa.length; j = j+manInput) {
					if(sa[j]==0) sa[j]=1;
					else if(sa[j]==1) sa[j]=0;
				}
			}
			else if(man==2) {
				int e = 0, r = 0;
				int w = 0;
				for(int j=manInput; j<1000; j++) {
					if(manInput-w==0 || manInput+w>s) break;
					if(sa[manInput-w] != sa[manInput+w]) break;
					e = manInput - w;
					r = manInput + w;
					w++;
					
				}
				
				for(int k=e; k<=r; k++) {
					if(sa[k]==0) sa[k]=1;
					else if(sa[k]==1) sa[k]=0;
				}
			}
		}
		int a=0;
		for(int i=1; i<sa.length; i++) {
			System.out.printf("%d ", sa[i]);
			a++;
			if(a%20==0) {
				System.out.println("");
			}
		}

	}

}