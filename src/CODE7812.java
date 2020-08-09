// 백준 7812번 문제 (중앙 트리)
import java.util.*;
import java.io.*;
public class CODE7812 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp = new int[101][101];
    static int[][] graph = new int[101][101];
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException{
        // dp[i][j] = i에서 j까지 가는데 걸리는 가중치의 합.
        while(true) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) break;
            // init
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    graph[i][j] = 0;
                    dp[i][j] = 0;
                }
            }
            // assign
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[node1][node2] = weight;
                graph[node2][node1] = weight;
                dp[node1][node2] = weight;
                dp[node2][node1] = weight;
            }
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.min(max, dfs(i,-1));
            }
        }
    }
    static int dfs(int start, int parent) {
        int cnt = 0;
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (graph[start][i] == 0 || i == parent) continue;
            cnt++;
            if (dp[start][i] != 0) {
                ret += dp[start][i];
            } else if(dp[i][start] != 0) {
                ret += dp[i][start];
            } else {

                aaj
                int value = dfs(i, start);
                ret += value;
                dp[start][i] = value;
                dp[i][start] = value;
            }
        }
        return ret;
    }
}
