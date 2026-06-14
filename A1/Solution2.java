import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  

        for (int i = 0; i < T; i++) {

            String word = sc.next();   
            double a = sc.nextDouble();
            String op = sc.next();
            double b = sc.nextDouble();

            double result = 0;

            if (op.equals("+")) {
                result = a + b;
            } 
            else if (op.equals("-")) {
                result = a - b;
            } 
            else if (op.equals("*")) {
                result = a * b;
            } 
            else if (op.equals("/")) {
                result = a / b;
            }

            System.out.printf("%.6f\n", result);
        }

        sc.close();
    }
}
