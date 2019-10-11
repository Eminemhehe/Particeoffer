package bishi;

import java.util.Scanner;

/**
 * Created by wz on 2019/8/27.
 */
public class DDtest {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.trim().split(" ");
        String[] res = process(str);
        printstr(res);
    }

    private static void printstr(String[] res) {
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    private static String[] process(String[] str) {
        if(str==null||str.length<1){
            return str;
        }
        String[] res = new String[str.length];
        int index = 1;
        while (index<str.length-2){
            res[index]=str[index];
            res[index+1]=str[index+1];
            if(res[index].equals("+")){
                if(Integer.valueOf(str[index+1])<Integer.valueOf(str[index-1])){
                    swap(res,index+1,index-1);
                }
            }
            if(str[index].equals("*")){
                if(Integer.valueOf(str[index+1])<Integer.valueOf(str[index-1])){
                    swap(res,index+1,index-1);
                }
            }
            index++;
        }
        return res;
    }

    private static void swap(String[] res, int i, int j) {
        String temp = res[i];
        res[i]=res[j];
        res[j]=temp;
    }
}
