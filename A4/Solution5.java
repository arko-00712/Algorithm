import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] u = new int[M];
        int[] diff = new int[N + 1];

        // read starting nodes
        for (int i = 0; i < M; i++) {
            u[i] = sc.nextInt();
        }

        // read ending nodes and update degrees
        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();

            diff[u[i]]--;  // outdegree
            diff[v]++;     // indegree
        }

        // print result
        for (int i = 1; i <= N; i++) {
            System.out.print(diff[i]);
            if (i < N) System.out.print(" ");
        }

        sc.close();
    }
}