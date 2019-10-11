package practice;

/**
 * Created by wz on 2019/6/11.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, -2, -8, 5, 10, 69, 0};
        insertionSort(arr);
        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //将后一个数插入到前面有序排列得数中
        for(int i =1;i<arr.length;i++){
            for(int j =i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
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
