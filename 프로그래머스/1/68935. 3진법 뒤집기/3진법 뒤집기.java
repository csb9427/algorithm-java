class Solution {
    public int solution(int n) {
        String a = Integer.toString(n,3);
        String s = "";
        
        for(int i=a.length()-1; i>=0; i--){
            s = s + a.charAt(i);
        }
        int answer = Integer.parseInt(s,3);
        
        return answer;
    }
}