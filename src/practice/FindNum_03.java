package practice;

import java.util.Scanner;


/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *  那么选取右上角或者左下角的元素a[row][col]与target进行比较，
 *  当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
 *  即col--；
 *  当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
 *  即row++；
 */
public class FindNum_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hang = in.nextInt();
        int lie = in.nextInt();
        int sercherNum = in.nextInt();
        int[][] arr = new int[hang][lie];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        boolean flog = LookupAlarrayProcess(arr, sercherNum);
        System.out.println(flog);
    }

    private static boolean LookupAlarrayProcess(int[][] array, int target) {
        int col = array.length - 1;
        int lie = array[0].length - 1;
        int Num = target;
        int hangIndex = col;
        int row = 0;
        while (hangIndex>=0 && row <= lie){
            target = array[hangIndex][row];
            if (target > Num) {
                hangIndex--;
            }
            if (target < Num) {
                row++;
            }
            if (target == Num) {
                return true;
            }
        }
        return false;
    }
}
