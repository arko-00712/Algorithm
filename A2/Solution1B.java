import java.io.*;
import java.util.*;

public class Solution1B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (sum == S) {
                out.println((left + 1) + " " + (right + 1));
                out.flush();
                return;
            } else if (sum < S) {
                left++;
            } else {
                right--;
            }
        }

        out.println(-1);
        out.flush();
    }
}
