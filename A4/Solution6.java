import java.util.*;

public class Solution6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        int[][] res = new int[8][2];
        int count = 0;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                res[count][0] = nx;
                res[count][1] = ny;
                count++;
            }
        }

        System.out.println(count);

        for(int i = 0; i < count; i++){
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}