import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long K = sc.nextLong();

        long[] A = new long[N];
        long[] B = new long[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextLong();
        }

        int i = 0;
        int j = M - 1;

        long bestDiff = Long.MAX_VALUE;
        int bestI = 1;
        int bestJ = 1;

        while (i < N && j >= 0) {
            long sum = A[i] + B[j];
            long diff = Math.abs(sum - K);

            if (diff < bestDiff) {
                bestDiff = diff;
                bestI = i + 1;
                bestJ = j + 1;
            }

            if (sum > K) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println(bestI + " " + bestJ);
    }
}
