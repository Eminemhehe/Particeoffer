package practice;

/**
 * 冒泡排序：
 * 优先确定N个数种最大得数
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, -2, -8, 5, 10};
        bubbleSort(arr);
        printArray(arr);
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //优先确认最大得数
        for(int i =arr.length-1;i>=0;i--){
            //这里j<i,因为由j+1，实际全部考虑，不越界
             for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
             }
        }
        return arr;
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
