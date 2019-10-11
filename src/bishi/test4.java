package bishi;

import java.util.Scanner;

/**
 * 输入有两行，第一行是N (1≤n≤5000) ，代表请求队列中的请求数量。
 * 第二行有N个数字 a1,a2…an  (1≤ai≤10^9)。Ai是第i个请求的负荷值。
 * 5
 * 1 4 3 2 5
 * 6
 * 样例解释，此时合法队列为[1,4,5,6,5]，最小增加和为6
 */
public class test4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num =in.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        process(arr);
    }

    private static void process(int[] arr) {
    }
}
