import java.util.*;

class Solution {
    public int solution(int n) {
        if (n == 0) return 0; // n이 0인 경우 바로 0 반환
        
        int answer = 0;
        int m = (int)Math.sqrt(n);
        
        for(int i = 1; i <= m; i++){
            if(n % i == 0){
                answer += i; // i는 항상 약수이므로 더함
                if(i != n / i) {
                    answer += n / i; // i와 n/i가 다를 때만 n/i도 더함
                }
            }
        }
            
        return answer;
    }
}
