package bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 输入字符串，获取其中数字
 */
public class keTest1 {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = stdin.readLine();
            str = str.trim();
            String res = "";
            if(str==""){
                return;
            }
            if(str!=null&&!"".equals(str)){
                for(int i =0;i<str.length();i++){
                    if(str.charAt(i)>=48 && str.charAt(i)<=57){
                        res +=str.charAt(i);
                    }
                }
            }
            if(res==null){
                System.out.println("-1");
            }else {
                char[] chars = res.toCharArray();
                Arrays.sort(chars);
                String newres = new String(chars);
                System.out.println(newres);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
