/**
 * HW5.2 by OPersian.
 *
 * Find an error using debugger.
 *
 * This is a fixed version of code.
 */

public class HW5Debug {

    public static void main(String[] args) {
        int[][] triangle = new int[4][];

        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        // triangle[4] = new int[5];

        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }

        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {  // Fixed. Version with error: `for (int j = 0; i < triangle[i].length; j++`
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

    }
}

