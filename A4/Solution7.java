//****
import java.util.*;

public class Solution7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        boolean[][] board = new boolean[N + 1][M + 1];
        int[][] knights = new int[K][2];

        for(int i = 0; i < K; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            knights[i][0] = x;
            knights[i][1] = y;
            board[x][y] = true;
        }

        int[] dx = {2,2,-2,-2,1,1,-1,-1};
        int[] dy = {1,-1,1,-1,2,-2,2,-2};

        for(int i = 0; i < K; i++){
            int x = knights[i][0];
            int y = knights[i][1];

            for(int j = 0; j < 8; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(board[nx][ny]){
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }

        System.out.println("NO");
       
    }
}