import java.util.*;
import java.util.stream.IntStream;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        sc.close();

        // Trivial cases
        if (N == 1) {
            System.out.println("YES");
            System.out.println(0);
            return;
        }
        if (N == 2) {
            if (A[0] <= A[1]) {
                System.out.println("YES");
                System.out.println(0);
            } else {
                System.out.println("NO");
            }
            return;
        }

        // For N >= 3, check parity condition
        int[] B = A.clone();
        Arrays.sort(B);

        // Odd positions (1-indexed) -> indices 0,2,4,... in 0-based
        List<Integer> oddOrig = new ArrayList<>();
        List<Integer> oddSort = new ArrayList<>();
        for (int i = 0; i < N; i += 2) {
            oddOrig.add(A[i]);
            oddSort.add(B[i]);
        }
        Collections.sort(oddOrig);
        Collections.sort(oddSort);
        if (!oddOrig.equals(oddSort)) {
            System.out.println("NO");
            return;
        }

        // Even positions (1-indexed) -> indices 1,3,5,... in 0-based
        List<Integer> evenOrig = new ArrayList<>();
        List<Integer> evenSort = new ArrayList<>();
        for (int i = 1; i < N; i += 2) {
            evenOrig.add(A[i]);
            evenSort.add(B[i]);
        }
        Collections.sort(evenOrig);
        Collections.sort(evenSort);
        if (!evenOrig.equals(evenSort)) {
            System.out.println("NO");
            return;
        }

        // Feasible – build the moves
        int[] arr = A.clone();
        List<int[]> moves = new ArrayList<>();

        // Sort odd positions
        int[] oddIdx = IntStream.range(0, N).filter(i -> i % 2 == 0).toArray();
        int[] oddTarget = new int[oddIdx.length];
        for (int i = 0; i < oddIdx.length; i++) oddTarget[i] = B[oddIdx[i]];

        for (int pos = 0; pos < oddIdx.length; pos++) {
            int i = oddIdx[pos];
            int target = oddTarget[pos];
            if (arr[i] == target) continue;

            // find the element further right
            for (int k = pos + 1; k < oddIdx.length; k++) {
                int j = oddIdx[k];
                if (arr[j] == target) {
                    while (j > i) {
                        // reverse subarray [j-2, j] (0?based)
                        moves.add(new int[]{j - 2 + 1, j + 1}); // 1?based start and end
                        // swap ends
                        int tmp = arr[j - 2];
                        arr[j - 2] = arr[j];
                        arr[j] = tmp;
                        j -= 2;
                    }
                    break;
                }
            }
        }

        // Sort even positions
        int[] evenIdx = IntStream.range(0, N).filter(i -> i % 2 == 1).toArray();
        int[] evenTarget = new int[evenIdx.length];
        for (int i = 0; i < evenIdx.length; i++) evenTarget[i] = B[evenIdx[i]];

        for (int pos = 0; pos < evenIdx.length; pos++) {
            int i = evenIdx[pos];
            int target = evenTarget[pos];
            if (arr[i] == target) continue;

            for (int k = pos + 1; k < evenIdx.length; k++) {
                int j = evenIdx[k];
                if (arr[j] == target) {
                    while (j > i) {
                        moves.add(new int[]{j - 2 + 1, j + 1});
                        int tmp = arr[j - 2];
                        arr[j - 2] = arr[j];
                        arr[j] = tmp;
                        j -= 2;
                    }
                    break;
                }
            }
        }

        // Output
        System.out.println("YES");
        System.out.println(moves.size());
        for (int[] m : moves) {
            System.out.println(m[0] + " " + m[1]);
        }
    }
}