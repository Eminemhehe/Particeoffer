package practice;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class printListFromTailToHead_05 {
    static  ArrayList arrayList = new ArrayList();
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        printListFromTailToHead(node);
        for(int i =0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }

    }

    private static ArrayList printListFromTailToHead(Node node) {
        if(node != null) {
            printListFromTailToHead(node.next);
            arrayList.add(node.value);
        }
        return arrayList;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
