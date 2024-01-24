class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0; i<myString.length(); i++){
            if(myString.charAt(i)>94)
            {
                answer+= (char)(myString.charAt(i)-32);
            }
            else{
                answer+= (char)(myString.charAt(i));
            }
        }
        return answer;
    }
}