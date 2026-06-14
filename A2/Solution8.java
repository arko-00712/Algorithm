import java.util.*;

public class Solution8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long k = sc.nextLong();
            long x = sc.nextLong();
            long result = k + (k - 1) / (x - 1);
            System.out.println(result);
        }
    }
}