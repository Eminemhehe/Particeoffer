package bishi;

import java.util.Scanner;

/**
 * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，
 * 那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
 * 第一行N，表示参赛人数（2<=N<=10^5）
 * 第二行N个正整数表示体重（0<体重<=10^8）
 */
public class Test3 {
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
        if(arr.length<2||arr==null){
            return;
        }
        int count = 0;
        for(int i =arr.length-1;i>=0;i--){
           for(int j=0;j<i;j++){
               int mini = Math.min(arr[i],arr[j]);
               if(mini>=arr[i]*0.9&&mini>=arr[j]*0.9){
                   count++;
               }
      }
        System.out.println(count);
    }
    }
}
 /*  int index =0;

        while (index<arr.length){
            for(int i =index+1;i<arr.length-1;i++){
                int mini = Math.min(arr[index],arr[i]);
                if(mini>=arr[index]*0.9&&mini>=arr[i]*0.9){
                    count++;
                }

            }
            index++;
        }*/