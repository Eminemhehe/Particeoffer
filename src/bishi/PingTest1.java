package bishi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by wz on 2019/8/11.
 */
public class PingTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        prcesson(arr);

    }

    private static void prcesson(int[] arr) {
        if(arr.length<3||arr==null){
            return;
        }
        int[] res= new int[3];
        int[] index = new int[3];
        int mini = Integer.MAX_VALUE;
        int start = 0;
        while(start<arr.length-1){
            for(int i =start+1;i<arr.length;i++){
                if(Math.abs(arr[start]-arr[i])<mini){
                    mini=Math.abs(arr[start]-arr[i]);
                    res[0]=arr[start];
                    res[1]=arr[i];
                    index[0]=start;
                    index[1]=i;
                }
            }
            start++;
        }
        int he = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
                if(Math.abs((res[0]-arr[i])+(res[1]-arr[i]))<he&&(arr[i]!=res[0]||arr[i]!=res[1])){
                    he =Math.abs((res[0]-arr[i])+(res[1]-arr[i]));
                     res[2]=arr[i];
                }
            }
        System.out.println(res[0]+" "+res[1]+" "+res[2]);
        double d = 0;
        Integer r1 = res[0]; Double d1 = Double.valueOf(r1.toString());
        Integer r2 = res[1]; Double d2 = Double.valueOf(r2.toString());
        Integer r3 = res[2];  Double d3 = Double.valueOf(r3.toString());
        double avg= (d1+d2+d3)/3;
        System.out.println(avg);
        d = ((d1-avg)*(d1-avg)+(d2-avg)*(d2-avg)+(d3-avg)*(d3-avg))/3;
        String jieguo = String.format("%.2f",d);
        System.out.println(jieguo);
    }
}
    /*double d =0;
    DecimalFormat df = new DecimalFormat("##.000000");
    Integer i1 = geshu;
    Integer i2 = score.length;
    Double d1 = Double.valueOf(i1.toString());
    Double d2 = Double.valueOf(i2.toString());
        d= (d1)/(d2);
                String res = String.format("%.6f",d*100);
                System.out.println(res);*/