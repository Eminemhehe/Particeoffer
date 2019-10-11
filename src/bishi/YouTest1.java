package bishi;

import java.util.Scanner;

/**
 * Created by wz on 2019/8/20.
 */
public class YouTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.trim().split("|");
        String[] s1 = str[0].trim().split(",");
        String[] s2 = str[1].trim().split(",");
        int[] arr1 = new int[s1.length];
        int[] arr2 = new int[s2.length];
        for(int i =0;i<s1.length;i++){
            arr1[i]= Integer.valueOf(s1[i]);
            arr2[i]= Integer.valueOf(s2[i]);
        }
         int[] res = process(arr1,arr2);
         System.out.print("[");
         printArray(res);
        System.out.print("]");

    }

    private static int[] process(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 =arr2.length;
        int[] res = new int[len1+len2];
        int lndex1 =0;int lndex2 =0;int le =0;
        while (lndex1<len1&&lndex2<len2){
            if(arr1[lndex1]<arr1[lndex2]){
                res[le++]=arr1[lndex1++];
            }else {
                res[le++]=arr2[lndex2++];
            }
        }
        while (lndex1<len1){
            res[le++]=arr1[lndex1++];
        }
        while (lndex2<len1){
            res[le++]=arr1[lndex2++];
        }
        return res;
    }
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
