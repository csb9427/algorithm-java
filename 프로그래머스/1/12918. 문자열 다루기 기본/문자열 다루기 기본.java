import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char c[] = s.toCharArray();
        for(int i=0; i<c.length; i++){
            int a = c[i]-'0';
            if(a>=10){
                answer = false;
                break;
            }
        }
        if(c.length!=4 && c.length!=6){
            answer = false;
        }
        
        return answer;
    }
}