// 백준 1135 뉴스 전하기
import java.util.*;
import java.io.*;
public class CODE1135 {
    static List<Integer> tree[];
    static int[] dp = new int[51];
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        tree = new List[N];
        for(int i = 0; i < N; i++) tree[i] = new ArrayList<>();
        st.nextToken();
        for (int i = 1; i < N; i++) {
            // i번 사원의 상사의 번호.
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }
        System.out.println(dfs(0));
    }
    static int dfs(int node) {
        // if (tree[node].size() == 0) return;
        List<Integer> minList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int child : tree[node]) minList.add(dfs(child));
        if(tree[node].size() == 0) return 0;
        Collections.sort(minList);
        int ret = minList.get(minList.size()-1) + 1;
        for(int i = minList.size() - 2, cnt = 1; i >= 0; i--,cnt++) {
            if(minList.get(i) + 1 > ret - cnt) {
                ret += (minList.get(i) + 1 - ret + cnt);
            }
        }
        return ret;
    }
}
