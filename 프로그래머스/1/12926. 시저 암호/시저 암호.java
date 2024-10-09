class Solution {
    public String solution(String s, int n) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result[i] = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                result[i] = (char) ((c - 'A' + n) % 26 + 'A');
            } else {
                result[i] = c;
            }
        }

        return new String(result);
    }
}