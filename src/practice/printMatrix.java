package practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 选择矩阵的4个角，特殊情况1行或者1列
 * 按照4个角，打印4个边
 */
public class printMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        ArrayList<Integer> list = Matrix(matrix);
    }

    private static ArrayList<Integer> Matrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int leftx = matrix.length - 1;
        int lefty = 0;
        int rightx = 0;
        int righty = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList();
        process(matrix, leftx, lefty, rightx, righty, list);
        return list;
    }

    private static void process(int[][] matrix, int leftx, int lefty, int rightx, int righty, ArrayList list) {

        if (leftx < rightx || lefty > righty) {
            return;
        } else if (leftx == rightx) {
            for (int i = lefty; i <= righty; i++) {
                System.out.println(matrix[leftx][i]);
                list.add(matrix[leftx][i]);
            }
        } else if (lefty == righty) {
            for (int i = rightx; i <= leftx; i++) {
                System.out.println(matrix[i][righty]);
                list.add(matrix[i][righty]);
            }
        } else {
            for (int i = lefty; i <= righty; i++) {
                System.out.println(matrix[rightx][i]);
                list.add(matrix[rightx][i]);
            }
            for (int i = rightx + 1; i <= leftx; i++) {
                System.out.println(matrix[i][righty]);
                list.add(matrix[i][righty]);
            }
            for (int i = righty - 1; i >= lefty; i--) {
                System.out.println(matrix[leftx][i]);
                list.add(matrix[leftx][i]);
            }
            for (int i = leftx - 1; i > rightx; i--) {
                System.out.println(matrix[i][lefty]);
                list.add(matrix[i][lefty]);
            }
            leftx--;
            lefty++;
            rightx++;
            righty--;
            process(matrix, leftx, lefty, rightx, righty, list);
        }
        return;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
