import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        int left = 0;
        long sum = 0;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            while (sum > K && left <= i) {
                sum -= arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        System.out.println(maxLength);
    }
}
