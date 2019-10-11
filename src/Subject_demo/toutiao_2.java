package Subject_demo;

import java.util.Scanner;


/**
 * Created by wz on 2019/7/7.
 */
public class toutiao_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<num;i++){
            arr[i]=in.nextInt();
        }
        int max = arr[0];
        for(int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

}
