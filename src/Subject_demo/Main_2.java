package Subject_demo;

import java.util.Scanner;

/**
 * 牛牛和羊羊在玩一个有趣的猜数游戏。在这个游戏中,牛牛玩家选择一个正整数,羊羊根据已给的提示猜这个数字。第i个提示是"Y"或者"N",表示牛牛选择的数是否是i的倍数。
 *
 * 例如,如果提示是"YYNYY",它表示这个数使1,2,4,5的倍数,但不是3的倍数。
 *
 * 注意到一些提示会出现错误。例如: 提示"NYYY"是错误的,因为所有的整数都是1的倍数,所以起始元素肯定不会是"N"。此外,例如"YNNY"的提示也是错误的,因为结果不可能是4的倍数但不是2的倍数。
 *
 * 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
 *
 * 例如 n = 5:
 *
 * 合法的提示有:
 *
 * YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
 *
 * YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
 *
 * 所以输出12
 *
 * 输入描述:
 *
 * 输入包括一个整数n(1 ≤ n ≤ 10^6),表示已给提示的长度。
 * 输出描述:
 *
 * 输出一个整数,表示合法的提示个数。因为答案可能会很大,所以输出对于1000000007的模
 * 输入例子1:
 *
 * 5
 * 输出例子1:
 *
 * 12
 * 测试用例:
 *
 * 1000000
 *
 * 对应输出应该为:
 *
 * 677298706
 *
 * 1.素数的取值数与其他数无关，为2
 *
 * 2.非幂的和数由其因数唯一确定
 *
 * 3.素数及其幂的取值数目之和为素数最高次幂的次数+1
！
 */
    public class Main_2{
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String str=sc.next();
            System.out.println(getLenth(str));
        }

        private static int getLenth(String str) {

            int len=str.length();
            int i=1;
            int end=len-1;//字符串先删除最后一位；

            if(len<2 || len>200)
                return 0;

            while(end>1){
                String sub=str.substring(0, end);
                String str1=str.substring(0,end/2);
                String str2=str.substring(end/2, end);

                if(str1.equals(str2)){
                    return end;
                }else{
                    end=len-i;
                    i++;
                }
            }
            return 0;
        }
    }

