package bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class test2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        int res = sort(arr);
        System.out.print(res);
    }

    private static int sort(int[] arr) {
        if(arr==null||arr.length<=0){
            return 0;
        }
        int len = arr.length;
        if(len==1){
            return 1;
        }
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i = len-1;i>=0;i--){
            if(i==len-1){
                dp[i]=1;
                continue;
            }
            for(int j =i+1;j<len;j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return  res;
    }
}
