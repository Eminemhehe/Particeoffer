package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wz on 2019/8/15.
 */
public class test_360 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();//位数
        int jinzhi = in.nextInt();//进制
        int[] arr1 = new int[num];
        int[] arr2 = new  int[num];
        for(int i =0;i< arr1.length;i++){
            arr1[i]=in.nextInt();
        }
        for(int i =0;i< arr1.length;i++){
            arr2[i]=in.nextInt();
        }
        int[] res = new int[num];
        process(jinzhi,arr1,arr2,res);
        printArray(res);
    }

    private static void process(int jinzhi, int[] arr1, int[] arr2, int[] res) {
        int count = arr1.length;
        int[]  arrindex =new int[arr1.length];
        int[] arrnew = new int[arr1.length];
        System.arraycopy(arrnew,0,arr2,0,arr2.length);
        while(count!=0){
            int max = Integer.MIN_VALUE;
            for(int i =0;i<arr1.length;i++){
                for(int j = 0;j< arrnew.length;j++){
                    if(arr1[i]+arr2[j]%5>=max){
                        max=arr1[i]+arr2[j]%5;
                        arrindex[i]=arr2[j];
                        arrnew = delete(j,arr2);
                    }
                }
            }
        }
        for(int i = 0;i<arr1.length;i++){
            res[i] = arr1[i]+arrindex[i];
            if(res[i]>jinzhi){
                res[i]=res[i]%jinzhi;
            }
        }
        Arrays.sort(res);

    }
    public static int[] delete(int index ,int[] arr){
        int[] arrNew = new int[arr.length-1];
        for(int i =index;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        System.arraycopy(arr,0,arrNew,0,arrNew.length);
        return arrNew;

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
