import java.util.*;

public class Solution5 {

    static long mod;

    static long[] solve(long a, long n) {
        if (n == 0) return new long[]{1, 0};

        long[] half = solve(a, n / 2);

        long p = half[0];
        long s = half[1];

        long p2 = (p * p) % mod;
        long s2 = (s + (p * s) % mod) % mod;

        if (n % 2 == 0) {
            return new long[]{p2, s2};
        } else {
            long p3 = (p2 * a) % mod;
            long s3 = (s2 + p3) % mod;
            return new long[]{p3, s3};
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long a = sc.nextLong();
            long n = sc.nextLong();
            mod = sc.nextLong();

            long ans = solve(a, n)[1];

            System.out.println(ans);
        }
    }
}