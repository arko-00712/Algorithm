import java.io.*;
import java.util.*;

public class Solution4B {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int u = Integer.parseInt(st.nextToken());
            degree[u]++;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            degree[v]++;
        }

        int odd = 0;

        for (int i = 1; i <= N; i++) {
            if (degree[i] % 2 == 1) {
                odd++;
            }
        }

        if (odd == 0 || odd == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}