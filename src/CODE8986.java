// 백준 8986번 문제 (전봇대)
import java.util.*;
import java.io.*;
public class CODE8986 {
    static int N;
    static int[] arr;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException{
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long lo = 0;
        long hi = arr[N-1];
        while(hi - lo >= 3) {
            long p = ((lo*2) + hi)/3;
            long q = (lo + (hi*2))/ 3;
            long leftCost = moveCost(p);
            long rightCost = moveCost(q);
            if (leftCost > rightCost) lo = p;
            else hi = q;
        }
        long min = Long.MAX_VALUE;
        for(int i = (int)lo; i <= hi; i++) {
            min = Math.min(min, moveCost(i));
        }
        System.out.println(min);
    }
    public static long moveCost (long n) {
        long ret = 0l;
        for(int i = 1; i < arr.length; i++) {
            ret += (long)Math.abs((n*i) - arr[i]);
        }
        return ret;
    }
}
