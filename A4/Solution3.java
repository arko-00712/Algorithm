import java.util.*;

public class Solution3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        for(int i = 0; i < N; i++){
            int k = sc.nextInt();

            for(int j = 0; j < k; j++){
                int v = sc.nextInt();
                matrix[i][v] = 1;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(matrix[i][j]);
                if(j < N-1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}