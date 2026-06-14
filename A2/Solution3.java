import java.util.*;

public class Solution3 {
    static class Pair implements Comparable<Pair> {
        long value;
        int index;

        Pair(long v, int i) {
            value = v;
            index = i;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextLong(), i + 1);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[i].value + arr[left].value + arr[right].value;

                if (sum == x) {
                    System.out.println(arr[i].index + " " + arr[left].index + " " + arr[right].index);
                    return;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(-1);
    }
}
