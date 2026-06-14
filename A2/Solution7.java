import java.util.*;

public class Solution7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        while (q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int left = lowerBound(a, x);
            int right = upperBound(a, y);
            System.out.println(right - left);
        }
    }

    static int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] < key) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upperBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] <= key) l = m + 1;
            else r = m;
        }
        return l;
    }
}