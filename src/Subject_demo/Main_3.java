package Subject_demo;

import java.util.Scanner;

/**
 * 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 * 牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1和或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
 *
 * 输入描述:
 *
 * 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成
 * 输出描述:
 *
 * 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解
 * 输入例子1:
 *
 * abaababaab
 * 输出例子1:
 *
 * 6

 */
public class Main_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();//判断
            if (n < 2) {
                System.out.println(n);
                break;
            }

            boolean[] visited = new boolean[n + 1];
            long count = 1;//合法提示个数
            for (int i = 2; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                int powernum = 2;//记录素数的最大幂次数，最大幂次数+1为此数及其幂的可能取值数目
                //普通和数不改变可能的合法提示个数
                for (int j = i + i; j <= n; j = j + i) {
                    visited[j] = true;
                }
                long power = i;//差别就在这里，应该为long型;n为int不代表power也为int，毕竟n是位数                     
                while (power * i <= n) {
                    powernum++;//又一个i的幂
                    power = power * i;
                }
                count = count * powernum % 1000000007;

            }

            count = count % 1000000007;

            System.out.println(count);

        }

    }

}
