// 백준 1422번 문제 (숫자의 신 아직 못품)
import java.io.*;
import java.util.*;
public class CODE1422 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long max = 0l;
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> {
            int ret = compare(b,a);
            if (ret != 0) {
                return ret;
            }
            int lenA = length(a);
            int lenB = length(b);
            if(lenA == lenB) {
                return Long.compare(b,a);
            } else if (lenA > lenB) {
                long underA = cuttingUnder(lenA - lenB, a);
                long cuttingB = cutting(lenB - (lenA - lenB), b);
                return ret;
            } else {
                // 0일때는 나머지와 비교..
                long underB = cuttingUnder(lenB - lenA, b);
                long cuttingA = cutting(lenA - (lenB - lenA), a);
                return ret;
            }
        });
        for(int i = 0; i < K; i++) {
            long val = Long.parseLong(bf.readLine());
            if (val > max) max = val;
            pq.add(val);
        }
        StringBuilder sb = new StringBuilder();
        // pq에 있는 값 넣기
        while(!pq.isEmpty()) {
            long val = pq.poll();
            if (val == max) {
                for(int i = 0; i < N - K; i++) {
                    sb.append(max);
                }
            }
            sb.append(val);
        }
        System.out.println(sb.toString());

    }
    public static int length(long l) {
        int cnt = 0;
        while(l != 0) {
            l /= 10;
            cnt++;
        }
        return cnt;
    }
    public static long cutting(int n, long l) {
        for(int i = 0; i < n; i++) {
            l /= 10;
        }
        return l;
    }
    public static long cuttingUnder(int n, long l) {
        long cnt = 1;
        long ret = 0;
        for(int i = 0; i < n; i++){
            long mod = l % 10;
            ret += (mod * cnt);
            l /= 10;
            cnt *= 10;
        }
        return ret;
    }
    public static int compare(long a, long b) {
        int lenA = length(a);
        int lenB = length(b);
        if(lenA == lenB) {
            return Long.compare(b,a);
        } else if (lenA > lenB) {
            int ret = Long.compare(b,cutting(lenA - lenB, a));
//            if (ret != 0) return ret;
//            long underA = cuttingUnder(lenA - lenB, a);
//            long cuttingB = cutting(lenB - (lenA - lenB), b);
            return ret;
        } else {
            int ret = Long.compare(cutting(lenB - lenA, b), a);
//            if (ret != 0) return ret;
//            // 0일때는 나머지와 비교..
//            long underB = cuttingUnder(lenB - lenA, b);
//            long cuttingA = cutting(lenA - (lenB - lenA), a);
            return ret;
        }
    }
}
