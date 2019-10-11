package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class duplicateNum_02 {
    static int[]  duplicateNum = {0};
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = stdin.readLine();
            String[] strArr = str.split(" ");
            int[] arr = new int[strArr.length];
            for(int i =0;i<strArr.length;i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            boolean res = process(arr,duplicateNum);
            System.out.println(res);
            System.out.println(duplicateNum[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean process(int[] arr,int[] duplicateNum) {
        if(arr.length<=0||arr==null){
            return false;
        }
        for(int i =0;i<arr.length;i++){
            if (arr[i]<0||arr[i]>arr.length-1){
                return false;
            }
        }
        /**
        首先比较i位置的数字是不是等于i，是继续，不是就将i与下标为i的数字进行交换
        例如 2 3 1 0 2 3 5，0位置得数字为2不等于0，那么0位置得数字就与2位置的数字进行交换，知道0位置的数字为0；
        当进行到4位置时，他的数字为2，不等于4，那么在比较下2位置是不是数字也为2，如果为2，那么4位置得2就重复了
        */
        for(int i =0;i<arr.length;i++){
            while (arr[i]!=i){
                if(arr[i]==arr[arr[i]]){
                    duplicateNum[0] = arr[i];
                    return true;
                }
                swap(arr,i,arr[i]);
            }
        }
       return  false;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
