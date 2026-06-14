import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int i = 0, j = 0;

        // Merge both arrays
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                System.out.print(A[i] + " ");
                i++;
            } else {
                System.out.print(B[j] + " ");
                j++;
            }
        }

        // Print remaining elements
        while (i < N) {
            System.out.print(A[i] + " ");
            i++;
        }

        while (j < M) {
            System.out.print(B[j] + " ");
            j++;
        }

        sc.close();
    }
}
