package bishi;

import java.util.Scanner;

/**
 * 小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。
 * 虽然小希并不知道密码具体是什么，
 * 但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。
 * 下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
 * 例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。
 * 8  5 1 6 8 2 4 5 10    5
 *
 */
public class test2 {
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
        if(arr==null){
              return 0;
          }
          if(arr.length<1){
              return 1;
          }
          int[] res = new int[arr.length];
          int r = 0;
          for(int i =0;i<arr.length;i++){
              res[i] = process(arr,i);
          }
          for(int m =0;m<res.length;m++){
              r = Math.max(res[m],r);
          }
          return  r;

    }

    private static int process(int[] arr, int i) {
        int count = 0;
        for(int j =i;j<arr.length-1;j++){
            if(arr[j]<arr[j+1]){
                count++;
            }
        }
        return count;
    }
}
