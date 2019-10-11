package bishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wz on 2019/8/19.
 */
public class stTest1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.trim().split(" ");
        Stack<String> res = new Stack<String>();
        res = process(str);
        while (!res.empty()){
            System.out.print(res.pop()+" ");
        }
    }

    private static Stack<String>  process(String[] str) {
        String[] p = {"+","-","*","/"};
        String a= "";String b ="";
        Stack<String> stack = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> res = new Stack<String>();
        for(String s :str){
            if(s.equals("+")){
                 a=stack.pop();
                 b=stack.pop();
                if(Integer.valueOf(a)>Integer.valueOf(b)){
                    stack2.add(b);
                    stack2.add("+");
                    stack2.add(a);
                }
            }
            else if(s.equals("*")){
                a=stack.pop();
                b=stack.pop();
                if(Integer.valueOf(a)>Integer.valueOf(b)){
                    stack2.add(b);
                    stack2.add("+");
                    stack2.add(a);
                }
            } else {
                stack.add(s);
            }
        }
        while(!stack2.empty()){
            res.push(stack2.pop());
        }
      return stack2;
    }
}
