import java.util.*;

public class Solution6 {

    static void build(long[] arr, int l, int r) {
        if (l > r) return;

        int mid = (l + r) / 2;

        System.out.print(arr[mid] + " ");

        build(arr, l, mid - 1);
        build(arr, mid + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        build(arr, 0, n - 1);
    }
}