import java.io.*;
import java.util.*;

public class Solution4B {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        if (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                sb.append(A[i++]).append(" ");
            } else {
                sb.append(B[j++]).append(" ");
            }
        }

        while (i < N) {
            sb.append(A[i++]).append(" ");
        }

        while (j < M) {
            sb.append(B[j++]).append(" ");
        }

        System.out.println(sb);
    }
}
