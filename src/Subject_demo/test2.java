package Subject_demo;

import java.util.Scanner;

/**
 * Created by wz on 2019/8/6.
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int num = in.nextInt();
            int[] numAll=new int[num];
            for(int i =0;i<numAll.length;i++){
                int g = in.nextInt();
                int timeAll = in.nextInt();
                int[] g_v = new int[g];
                int[] g_t =new int[g];
                for(int j=0;j<g;j++){
                    g_v[j]=in.nextInt();
                    g_t[j]=in.nextInt();
                }
                numAll[i]=prcess(timeAll,g_t,g_v);
            }

        }
    }

    private static int prcess(int timeAll, int[] g_t, int[] g_v) {
        int n = g_t.length-1;
        int[] str = new int[timeAll+1];
        for(int i =1;i<=n;i++){
            for(int j =timeAll;j>=g_t[i];j--){
                if(str[j-g_t[i]]+g_v[i]>str[j]){
                    str[j]=str[j-g_t[i]+g_t[i]];
                }
            }
        }
        return str[timeAll];
    }
}
