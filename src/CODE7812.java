// 백준 7812번 문제 (중앙 트리)
import java.util.*;
import java.io.*;
public class CODE7812 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Node> list[];
    static long[] cnt;
    static long[] accCost;
    static long[] outCost;
    public static void main(String[] args) throws IOException{
        while(true) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) break;
            cnt = new long[N];
            accCost = new long[N];
            outCost = new long[N];
            list = new List[N];
            // init
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            // assign
            for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(bf.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[node1].add(new Node(node2, cost));
                list[node2].add(new Node(node1, cost));
            }
            dfs(0,-1);
            dfs2(0,-1);

            long ret = Long.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                long allCost = accCost[i] + outCost[i];
                ret = Math.min(ret, allCost);
            }
            System.out.println(ret);
        }
    }
    static void dfs(int start, int parent) {
        for (Node node : list[start]) {
           if (node.next != parent) {
               dfs(node.next, start);
               cnt[start] += cnt[node.next];
               accCost[start] += accCost[node.next] + cnt[node.next] * node.cost;
           }
        }
        cnt[start]++;
    }
    static void dfs2(int start, int parent) {
        for (Node node : list[start]) {
            if (node.next != parent) {
                outCost[node.next] += outCost[start] + (cnt[0] - cnt[node.next]) * node.cost + accCost[start]
                        - (accCost[node.next] + cnt[node.next] * node.cost);
                dfs2(node.next, start);
            }
        }
    }
} class Node {
    int next;
    int cost;
    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}
