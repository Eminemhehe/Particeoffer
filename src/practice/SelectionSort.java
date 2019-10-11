package practice;

/**
 * Created by wz on 2019/6/11.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, -2, -8, 5, 10, 69, 0,9,-1,0};
        selectionSort(arr);
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        //每一次遍历选择出最小得数进行交换
        for(int i = 0;i<arr.length;i++){
            int miniindex = i;
            for(int j =i+1;j<arr.length;j++){
                miniindex = arr[j]<arr[miniindex]?j:miniindex;
            }
            swap(arr,i,miniindex);
        }
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
