/*!
 * ## Solution
 * we can explore everywhere in maze by following instruction
 * 
 * 
*/

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in); 
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; ++i) {
            char[] tmp = scanner.next().toCharArray();
            for (int j = 0; j < m; ++j) {
                maze[i][j] = tmp[j];
            }
        }
        scanner.close();

        // solve

    }
}
