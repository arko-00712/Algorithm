import java.util.*;

public class Solution3easy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        for (int i = 0; i < n; i++) {

            map.clear();

            for (int j = i + 1; j < n; j++) {

                long needed = x - arr[i] - arr[j];

                if (map.containsKey(needed)) {
                    System.out.println((i + 1) + " " + (map.get(needed) + 1) + " " + (j + 1));
                    return;
                }

                map.put(arr[j], j);
            }
        }

        System.out.println(-1);
    }
}