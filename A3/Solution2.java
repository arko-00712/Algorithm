import java.util.Scanner;

public class Solution2 {

    static long count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        mergeSort(arr, 0, n - 1);

        System.out.println(count);
    }

    static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);
    }

    static void countPairs(long[] arr, int left, int mid, int right) {

        for (int j = mid + 1; j <= right; j++) {

            long square = arr[j] * arr[j];

            int low = left;
            int high = mid;
            int firstGreater = mid + 1;

            // Binary search in left half
            while (low <= high) {
                int m = (low + high) / 2;
                if (arr[m] > square) {
                    firstGreater = m;
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            }

            count += (mid - firstGreater + 1);
        }
    }

    static void merge(long[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] L = new long[n1];
        long[] R = new long[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }
}