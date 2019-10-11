package bishi;

import java.util.*;

/**
 * 给定一个整数的数组，找出其中的pair(a,  b)，
 * 使得a+b=0，并返回这样的pair数目。（a,  b）和(b,  a)是同一组。
 *
 *
 样例输入
 -1,  2,   4,  5,  -2
 样例输出
 1
 */
public class vipTesi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for(int i =0;i<str.length;i++){
            arr[i]=Integer.valueOf(str[i].trim());
        }
        int[] res = quchong(arr);
        int jieguo = process(res);
        System.out.println(jieguo);
    }

    private static int[] quchong(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(!list.contains(i)){
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }


    private static int  process(int[] arr) {
        int res = 0;
        if(arr==null||arr.length<2){
            return 0;
        }
        for (int i =0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==0){
                    res+=1;
                }
            }
        }
        return res;
    }
}
