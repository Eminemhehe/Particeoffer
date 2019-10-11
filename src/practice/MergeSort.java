package practice;

/**
 * Created by wz on 2019/6/11.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, -2, -8, 5, 10, 69, 0, 9, -1, 0};
        mergeSort(arr);
        printArray(arr);
    }

    /*private static void mergeSort1(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        //初始左右序列得长度为1
        int length = 1;
        while (length<arr.length){
            int start,mid,end;
            for(int i = 0;1<arr.length;i+=length*2){
                start =i;
                end =start+2*length-1;
                mid = start+length-1;
                if(end>arr.length-1){
                    end=arr.length-1;
                }
                if(mid>arr.length-1){
                    mid =arr.length-1;
                }
                merge(arr,start,mid,end);
            }
            length *=2;
        }
    }*/

    private static void mergeSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        mergeSortProcess(arr,0,arr.length-1);
    }

    private static void mergeSortProcess(int[] arr, int leftindex, int rigttindex) {
        //递归什么什么停止，basecase
        if(leftindex==rigttindex){
            return;
        }
        int mid = leftindex+(rigttindex-leftindex)/2;
        mergeSortProcess(arr,leftindex,mid);
        mergeSortProcess(arr,mid+1,rigttindex);
        merge(arr,leftindex,mid,rigttindex);
    }

    private static void merge(int[] arr, int leftindex, int mid, int rigttindex) {
        //注意help数组得大小
        int[] help = new int[rigttindex-leftindex+1];
        int indexleft = leftindex;
        //注意有边界得取值
        int indexright = mid+1;
        int corrent = 0;
        while(indexleft<=mid&&indexright<=rigttindex){
            help[corrent++]=arr[indexleft]<arr[indexright]?arr[indexleft++]:arr[indexright++];
        }
         while(indexleft>mid&&indexright<=rigttindex){
             help[corrent++]=arr[indexright++];
         }
        while(indexright>rigttindex&&indexleft<=mid){
            help[corrent++]=arr[indexleft++];
        }
        for(int i = 0;i<help.length;i++){
            arr[leftindex+i]=help[i];
        }
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
