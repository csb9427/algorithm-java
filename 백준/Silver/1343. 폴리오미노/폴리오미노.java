/*
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String answer = "";
        String A = "AAAA", B = "BB";

        s = s.replaceAll("XXXX", A);
        answer = s.replaceAll("XX", B);

        if (answer.contains("X")) {
        	answer = "-1";
        }

        System.out.println(answer);
    }
}