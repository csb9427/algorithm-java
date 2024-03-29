import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException   {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(br.readLine());
            if (a>0) {
                pq.add(a);
            } 
            else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}