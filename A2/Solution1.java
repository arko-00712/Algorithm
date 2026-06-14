import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long S = sc.nextLong();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        int left = 0;
        int right = N - 1;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (sum == S) {
                System.out.println((left + 1) + " " + (right + 1));
                return;
            } else if (sum < S) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(-1);
    }
}
