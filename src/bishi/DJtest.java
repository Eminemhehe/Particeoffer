package bishi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 4 4
 * ZuoZhuan TurnLeft
 * YouZhuan TurnRight
 * QianJin Forward
 * HouTui Backward
 * ZuoZhuan
 * QianJin
 * QianJin
 * HouTui
 * 1 1
 * SDFlkjdf LNCIls
 * SDFlkjdf
 */
public class DJtest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int yinshe = in.nextInt();
            int chaxun = in.nextInt();
            if(yinshe==0||chaxun==0){
                return;
            }
            HashMap<String,String> hash = new HashMap<String,String>();
            for(int i = 0;i<yinshe;i++){
                hash.put(in.next(),in.next());
            }
            if(hash.size()!=yinshe){
                return;
            }
            String[] str = new String[chaxun];
            for(int i=0;i<chaxun;i++){
                str[i]=in.next();
            }
            for(int i =0;i<str.length;i++){
                    System.out.println(hash.get(str[i]));
            }
        }
    }
}