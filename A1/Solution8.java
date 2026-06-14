import java.util.Scanner;

public class Solution8 {

    static String convert(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                result.append(c);
            } else {
                result.append((char)(c + 100));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] lines = new String[N];
        String[] names = new String[N];
        String[] converted = new String[N];
        String[] times = new String[N];

        // Input
        for (int i = 0; i < N; i++) {
            lines[i] = sc.nextLine();

            String[] parts = lines[i].split(" ");
            names[i] = parts[0];
            times[i] = parts[parts.length - 1];

            // Convert only once
            converted[i] = convert(names[i]);
        }

        // Bubble Sort
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {

                boolean swap = false;

                if (converted[j].compareTo(converted[j + 1]) > 0) {
                    swap = true;
                }
                else if (converted[j].equals(converted[j + 1])) {
                    // later time first
                    if (times[j].compareTo(times[j + 1]) < 0) {
                        swap = true;
                    }
                }

                if (swap) {
                    String temp;

                    temp = lines[j];
                    lines[j] = lines[j + 1];
                    lines[j + 1] = temp;

                    temp = converted[j];
                    converted[j] = converted[j + 1];
                    converted[j + 1] = temp;

                    temp = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(lines[i]);
        }

        sc.close();
    }
}
