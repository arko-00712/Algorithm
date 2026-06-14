import java.util.Scanner;

public class Solution5modified {

    static long mod;

    // Function to compute the sum of a^0 + a^1 + a^2 + ... + a^n % mod
    static long solve(long a, long n) {
        long sum = 1;  // Start with a^0 = 1
        long p = 1;    // Start with the first power, a^0 = 1
        
        for (long i = 1; i <= n; i++) {
            p = (p * a) % mod;  // Update p to a^i
            sum = (sum + p) % mod;  // Add a^i to the sum
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int T = sc.nextInt();

        // Process each test case
        while (T-- > 0) {
            // Read the base (a), exponent (n), and modulus (mod)
            long a = sc.nextLong();
            long n = sc.nextLong();
            mod = sc.nextLong();

            // Calculate the result (sum of a^0 + a^1 + ... + a^n % mod)
            long ans = solve(a, n);

            // Print the result for the current test case
            System.out.println(ans);
        }
    }
}