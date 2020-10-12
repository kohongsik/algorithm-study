// 백준 1305번 광고
import java.util.*;
import java.io.*;
public class CODE1305 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine());
        String S = bf.readLine();
        int[] pi = makeTable(S, L);
        System.out.println(L - pi[L - 1]);
    }
    public static int[] makeTable (String s, int L) {
        // int len = s.length();
        int[] ret = new int[L];
        int j = 0;
        // char[] chs = s.toCharArray();
        for(int i = 1; i < L; i++) {
            while(j > 0 && s.charAt(j) != s.charAt(i)) {
                j = ret[j-1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                ret[i] = ++j;
            }
        }
        return ret;
    }
}
