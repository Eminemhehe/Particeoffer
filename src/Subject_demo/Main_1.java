package Subject_demo;
/*牛牛有一些字母卡片,每张卡片上都有一个小写字母,所有卡片组成一个字符串s。牛牛一直认为回文这种性质十分优雅,于是牛牛希望用这些卡片拼凑出一些回文串,但是有以下要求:
        1、每张卡片只能使用一次
        2、要求构成的回文串的数量最少
        牛牛想知道用这些字母卡片,最少能拼凑出多少个回文串。
        例如: s = "abbaa",输出1,因为最少可以拼凑出"ababa"这一个回文串
        s = "abc", 输出3,因为最少只能拼凑出"a","b","c"这三个回文串
        输入描述:
        输入包括一行,一个字符串s,字符串s长度length(1 ≤ length ≤ 1000).
        s中每个字符都是小写字母
        输出描述:
        输出一个整数,即最少的回文串个数。
        示例1
        输入
        abc
        输出
        3*/
import java.util.Scanner;

public class Main_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            int[] ch = new int[256];
            for(int i=0;i<str.length();i++){
                ch[str.charAt(i)] ++;
            }
            int res = getNum(ch);
            System.out.println(res);
        }
    }

    private static int getNum(int[] c){    //获取字符串中有多少个字符出现的次数为奇数
        int res = 0;
        int len = c.length;
        for(int i=0;i<256;i++){
            if((c[i] & 1) ==1){
                res ++;
            }
        }
        return res == 0 ? 1: res;
    }

}
