import java.util.Scanner;
public class Solution1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        while (T-- > 0) {
            int N = sc.nextInt();
            if(N%2 == 0){
              System.out.println(N+" is an Even number.");
            }
            else{
              System.out.println(N+" is an Odd number.");
            }
        }
    }
}