package bishi;

import java.util.Scanner;

/**
 * 输入一个字符串。包含空格和可见字符。长度<=10000。
 * 样例输入
 * the sky is            blue!
 * 样例输出
 * blue! is sky the
 */
public class charre {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] temp = s.trim().split(" ");
        for (int i = temp.length - 1; i >= 0; i--) {
            char[] chars = temp[i].toCharArray();
            if (chars==null) {
                return;
            }
            System.out.print(temp[i] + " ");
        }
    }

}


