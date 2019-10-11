package bishi;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wz on 2019/8/31.
 */
public class YYtest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.trim().split(",");
        char[] pre=s[0].toCharArray();
        char[] mid = s[1].toCharArray();
        TreeNode head = preInToTree(pre, mid);
        posOrderUnRecur(head);
    }
    public static class TreeNode {
        public char value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char data) {
            this.value = data;
        }
    }
    public static TreeNode preInToTree(char[] pre, char[] mid) {
        if (pre == null || mid == null) {
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < mid.length; i++) {
            map.put(mid[i], i);
        }

        return preIn(pre, 0, pre.length - 1, mid, 0, mid.length - 1, map);
    }

    public static TreeNode preIn(char[] pre, int preStart, int preEnd, char[] mid, int midStart, int midEnd, HashMap<Character, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        int index = map.get(pre[preStart]);
        head.left = preIn(pre, preStart + 1, preStart + index - midStart, mid, midStart, midEnd, map);
        head.right = preIn(pre, preStart + index - midStart + 1, preEnd, mid, index + 1, midEnd, map);
        return head;
    }
    public static void posOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value);
            }
        }
    }
}

