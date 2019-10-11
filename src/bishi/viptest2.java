package bishi;

import java.util.Scanner;

/**
 * 输入一个大于0的整数，求其二进制表示中1的个数。
 * 例如，输入3，它的二进制表示为11，其中1的个数为2，输出2。
 * 输入
 * 输入一个大于0的整数
 * 输出
 * 二进制中1的个数
 * 样例输入
 * 3
 * 样例输出
 * 2
 */
public class viptest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int res = process(num);
        System.out.print(res);
    }

    private static int process(int num) {
        if (num == 0) {
            return 0;
        }
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
