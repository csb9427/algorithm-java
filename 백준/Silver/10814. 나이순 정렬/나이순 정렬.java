import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 이 문제는 입력을 받고 N을 기준으로 값을 오름차순으로 내보낸다. 
 * 만약 나이가 같다면 먼저 들어온 값을 우선한다.
 * 
 * 풀이방법
 * 우선순위큐를 사용해 페어의 형태로 받고 Comparator 값을 조정하도록 한다.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Person> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            pq.offer(new Person(age, name, i));
        }
        
        while (!pq.isEmpty()) {
            Person person = pq.poll();
            System.out.println(person.age+" "+person.name);
        }
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;
    int order;

    public Person(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    @Override
    public int compareTo(Person other) {
    	if(this.age == other.age) {
    		return Integer.compare(this.order, other.order);
    	}
		return Integer.compare(this.age, other.age);
    }
}