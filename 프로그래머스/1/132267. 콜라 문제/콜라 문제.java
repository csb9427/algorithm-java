class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int d = 0;
        int e = 0;
        
        while(n>=a){
            d = n/a * b;
            answer = answer + d;
            n = (n%a)+d;
        }
        
        return answer;
    }
}