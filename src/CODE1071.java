// 백준 1071번 문제 (소트 아직 못품)
import java.util.*;
import java.io.*;
public class CODE1071 {
    static int N;
    static int[] arr;
    static List<Integer> list;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] acc = new int[1001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            acc[k]++;
            if (acc[k] == 1) list.add(k);
        }
        Collections.sort(list);
        // pointer가 가르치는 수를 삽입
        // 이전 값이 1차이가 나면 ++
        // 이전값이 1차이가 나지 않으면
        // start pointer를 정해야함.
        int start = 0;
        int pointer = 1;
        LinkedList<Integer> q = new LinkedList<>();
        int[] acc2 = new int[1001];
        while (q.size() != N) {
            if (q.size() == 0) {
                q.addLast(list.get(start));
                acc2[list.get(start)]++;
            } else {
                int before = q.getLast();
                if (pointer >= list.size()) {
                    q.clear();
                    start++;
                    pointer = 0;
                    acc2 = new int[1001];
                    continue;
                }
                if (acc2[list.get(pointer)] == acc[list.get(pointer)]) {
                    pointer++;
                    continue;
                }
                if (before + 1 == list.get(pointer)) {
                    pointer++;
                    continue;
                }
                q.addLast(list.get(pointer));
                acc2[list.get(pointer)]++;
                pointer = 0;
            }
        }
        q.forEach((v) -> sb.append(v + " "));
        System.out.println(sb.toString());
    }
}
