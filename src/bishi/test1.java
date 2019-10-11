package bishi;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * 给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字，如果有差的绝对值相同的，则输出最前面的一对数。
 *
 * 2<n<=100，正整数都在10^16范围内
 *
 * 输入包含2行，第一行为n，第二行是n个用空格分隔的正整数。
 *
 * 输出
 * 输出包含一行两个正整数，要求按照原来的顺序输出
 *
 *
 * 样例输入
 * 9
 * 1 3 4 7 2 6 5 12 32
 * 样例输出
 * 3 4
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i =0;i<arr.length;i++){
            arr[i]=in.nextInt();
            if(arr[i]<0){
                return;
            }
        }
        if(arr.length<2||arr==null){
            return;
        }
        int[] res = new int[2];
        process(arr,res);
    }

    private static void process(int[] arr, int[] res) {
        int mini = Integer.MAX_VALUE;
        for(int i =0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1])<mini){
                  mini=Math.abs(arr[i]-arr[i+1]);
                  res[0]=arr[i];
                  res[1]=arr[i+1];
            }
        }
        for(int i =0;i<2;i++){
            System.out.print(res[i]+" ");
        }

    }
}
