package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
 * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
 * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
 */
public class Space_04 {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = stdin.readLine();
            StringBuffer stringBuffer = new StringBuffer(str);
            String res = proces(stringBuffer);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String proces(StringBuffer str) {
        if(str==null||str.length()<1){
            return str.toString();
        }
        int count = 0;//spacenum为计算空格数
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        //indexold为替换前的str下标
        int indexold=str.length()-1;
        //计算空格转换成%20之后的str长度
        int newlength=str.length()+count*2;
        //indexold为把空格替换为%20后的str下标
        int indexnew=newlength-1;
        //使str的长度扩大到转换成%20之后的长度,防止下标越界
        str.setLength(newlength);
        while(indexold>0&&indexold<newlength){
            if(str.charAt(indexold)==' '){
                str.setCharAt(indexnew--,'0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }
            else{
                str.setCharAt(indexnew--,str.charAt(indexold));
            }
            --indexold;
        }
        return str.toString();
    }
}
