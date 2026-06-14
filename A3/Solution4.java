import java.util.*;

public class Solution4 {

    static final long MOD = 1000000007;

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];

        C[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0]) % MOD;
        C[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1]) % MOD;
        C[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0]) % MOD;
        C[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1]) % MOD;

        return C;
    }

    static long[][] power(long[][] A, long x) {

        long[][] result = {{1,0},{0,1}}; // identity matrix

        while (x > 0) {

            if (x % 2 == 1)
                result = multiply(result, A);

            A = multiply(A, A);

            x = x / 2;   // divide exponent by 2
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long[][] A = new long[2][2];

            A[0][0] = sc.nextLong();
            A[0][1] = sc.nextLong();
            A[1][0] = sc.nextLong();
            A[1][1] = sc.nextLong();

            long X = sc.nextLong();

            long[][] ans = power(A, X);

            System.out.println(ans[0][0] + " " + ans[0][1]);
            System.out.println(ans[1][0] + " " + ans[1][1]);
        }
    }
}