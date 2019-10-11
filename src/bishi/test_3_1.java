package bishi;

import java.util.Scanner;

/**
 * 输入薯券金额、商品分别价格输出，
 *
 * 例如： 10 [2,3,5]，10 与[2,3,5]中间有空格
 * 输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合
 */
public class test_3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long money = in.nextLong();
        String zuhe = in.next();
        //System.out.println(money+zuhe);
        String str = "";
        char de1 = ']';
        char de2 = '[';
        for(int i =0;i<zuhe.length();i++){
            if(zuhe.charAt(i)!=de1&&zuhe.charAt(i)!=de2){
                str +=zuhe.charAt(i);
            }
        }
        String[] temp = str.trim().split(",");
        long[] arr = new long[temp.length];
        for(int i = 0;i<temp.length;i++){
            arr[i]=Long.valueOf(temp[i]);
        }
        //System.out.println(money+str);
        process(arr,money);
    }

    private static void process(long[] arr, long money) {
        if(arr==null){
            System.out.println(0);
        }
       long[] dp = new long[(int) (money+1)];
        dp[0] = arr[0];
       for(long i = 0;i<arr.length-1;i++){
           for(long j = arr[(int) i]; j<money+1; j++){
               dp[(int) j] += dp[(int) (j-arr[(int)i])];
           }
       }
        System.out.println(dp[(int) money]);
    }
}
