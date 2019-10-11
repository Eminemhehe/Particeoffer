package bishi;

import java.util.Scanner;

/**
 * 递归2分
 */
public class keTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] res = change(s);
        //System.out.println(res);
        serch(res, 19, 0, res.length);
    }

    private static void serch(int[] res, int value, int leftIndex, int rigthIndex) {
        if(leftIndex==rigthIndex){
            System.out.println("-1");
            return;
        }
        int mid = leftIndex + (rigthIndex - leftIndex) / 2;
        if (leftIndex < rigthIndex) {
            if (res[mid] == value) {
                System.out.println(mid+1);
            } else if (res[mid] > value) {
                serch(res, value, leftIndex, mid - 1);
            } else if (res[mid] < value) {
                serch(res, value, mid + 1, rigthIndex);
            }
        }
        return;
    }

    private static int[] change(String s) {
        char c = '}';
        char c1 = '{';
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c && s.charAt(i) != c1) {
                res += s.charAt(i);
            }
        }
        String[] strArr = res.split(",");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.valueOf(strArr[i]);
        }
        return intArr;
    }
}
