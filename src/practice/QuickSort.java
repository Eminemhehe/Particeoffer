package practice;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 10, 69, 0, 9, -1,0,5,5,6,8,-2};
        quickSort(arr);
        printArray(arr);

    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //quickSortProcess(arr, 0, arr.length - 1);
        sort(arr,0,arr.length-1);
    }

    //快排的非递归实现，压栈
    public static void sort(int[] arr, int left, int right){
        Stack<Integer> stack = new Stack<>();
        if (left < right) {
            stack.push(right);
            stack.push(left);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int[] index = partition(arr, l, r);
                int indexstart = index[0];
                if (l <index[0] - 1) {
                    stack.push(index[0]-1);
                    stack.push(l);
                }
                if (r >index[1] + 1) {
                    stack.push(r);
                    stack.push(index[1]+1);
                }
            }
        }
    }



    public static void quickSortProcess(int[] arr, int l, int r) {
        if (l < r) {
            //随机一个数，将其放置在数组最后一位作为划分值
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr,l,r);
            quickSortProcess(arr,l,p[0]-1);
            quickSortProcess(arr,p[1]+1,r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
