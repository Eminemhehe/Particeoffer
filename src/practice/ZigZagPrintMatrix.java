package practice;

/**宏观思路：寻找对角线；设置标记位:从什么方向打印
 * */


public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int enr = matrix.length - 1;
        int enc = matrix[0].length - 1;
        boolean b = true;
        while (ar <= enr && bc <= enc) {
            printLevel(matrix, ar, ac, br, bc, b);
            ar = ac == enc ? ar+1 : ar;
            ac = ac == enc ? ac : ac+1;
            bc = br == enr ? bc+1 : bc;
            br = br == enr ? br : br+1;
            b = !b;
        }

    }

    public static void printLevel(int[][] m, int ar, int ac, int br, int bc,
                                  boolean f) {
        if (f == true) {
            while (ar <= br && ac >= bc) {
                System.out.print(m[ar][ac] + " ");
                ar++;
                ac--;
            }
        }
        if (f == false) {
            while (br>=ar&&bc<=ac) {
                System.out.print(m[br][bc] + " ");
                br--;
                bc++;
            }

        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

}
