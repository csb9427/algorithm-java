class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = 0; // 약수의 개수를 저장할 변수
            
            // i의 약수 개수를 구하는 반복문
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            
            // 약수의 개수가 짝수인 경우 더하고, 홀수인 경우 뺍니다.
            if(count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}
