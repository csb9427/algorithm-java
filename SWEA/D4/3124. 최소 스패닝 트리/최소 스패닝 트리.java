import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * 첫 번째 줄에는 전체 test case 수 T(1<=T<=10)이 주어진다.
 * 정점의 개수 V(1~100000), 간선의 개수E(1~200000)이 주어짐
 * 
 * 다음 E개의 줄에는 각 간선의 정보를 나타내는 정수 A, B, C가 주어진다.
 * A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다.
 * 
 * C가 음수일 수도 있으며 절대값이 1000000을 넘지는 않는다.
 * 
 * 아까 사용한 크루스칼 알고리즘을 사용하면 된다.
 */


public class Solution {
	
	
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            edges = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edges);

            make(V);

            long weightSum = 0;
            int cnt = 0;
            for (Edge edge : edges) {
                if (!union(edge.from, edge.to)) continue;
                weightSum += edge.weight;
                if (++cnt == V - 1) break;
            }
            System.out.println("#" + t + " " + weightSum);
        }
    }

    private static void make(int V) {
        parents = new int[V+1]; // 자신의 부모나 루트를 저장(경로 압축으로 인해)
        for (int i = 0; i < V; i++) parents[i] = i; // 모든 정점을 자신을 대표자로 만들기
    }

    private static int find(int a) { // a가 속한 트리의 루트 찾기
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]); //Path compression(경로 압축)
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false; // a, b가 같은 트리에 속해있다. ==> union 불필요
        parents[rootB] = rootA;
        return true;
    }
}