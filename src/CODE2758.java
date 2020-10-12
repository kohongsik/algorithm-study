// 백준 2758번 광고
import java.util.*;
import java.io.*;
public class CODE2758 {
    static int T; // # of test_case
    static int N; // max 10
    static int M; // max 2000
    static long[][] dp; // i부터 시작해서 j 길이 만큼의 숫자열을 만드는 경우의 수
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(bf.readLine());
        dp = new long[2001][11];
        for(int i = 0; i < 2001; i++) {
            for(int j = 0; j < 11; j++) dp[i][j] = -1;
        }
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); // 1 ~ 10
            M = Integer.parseInt(st.nextToken()); // 1 ~ 2000
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    dp[j][i] = -1;
                }
            }
            int startNum = 1;
            long ret = 0;
            while(startNum * (1<<(N-1)) <= M) {
                ret += dfs(startNum, N);
                startNum++;
            }
            System.out.println(ret);
        }
    }
    public static long dfs(int start, int len) {
        if (len == 1) {
            return dp[start][len] = 1;
        }
        if (dp[start][len] != -1) {
            return dp[start][len];
        }
        if (start * (1<<(len-1)) > M) return dp[start][len] = 0;
        long ret = 0;
        int next = start * 2;
        while(next * (1<<(len - 2)) <= M) {
            ret += dfs(next, len - 1);
            next++;
        }
        dp[start][len] = ret;
        return ret;
    }
}
