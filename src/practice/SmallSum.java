package practice;

/**
 * 小和问题，一个数组中，当前数比其左边数小得类加起来，小和
 * 4+2=6，4+2+5+1=12，1+2=3，4+2+1+3+5=15
 */
public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {4,2,5,1,7,3,6};
        int a = smallSum(arr);
        System.out.println(a);
    }

    public static int smallSum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length < 2) {
            return arr[0];
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    private static int sortProcess(int[] arr, int leftIndex, int rigthIndex) {
        //base case
        if (leftIndex == rigthIndex) {
            return 0;
        }

        int mid = leftIndex + ((rigthIndex - leftIndex) / 2);
        int left = sortProcess(arr, leftIndex, mid);
        int right = sortProcess(arr, mid + 1, rigthIndex);
        int merge = merge(arr, leftIndex, mid, rigthIndex);
        return left + right + merge;
    }

    private static int merge(int[] arr, int leftIndex, int mid, int rigthIndex) {
        int[] help = new int[rigthIndex - leftIndex + 1];
        int i = 0;
        int p1 = leftIndex;
        int p2 = mid + 1;
        int res = 0;

        while (p1 <= mid && p2 <= rigthIndex) {
            // 如果左边小于右边，那就有(r - p2 + 1)个arr[p1]元素的和是最小和
            // 如果大于右边，返回0
            res += arr[p1] < arr[p2] ? (rigthIndex-p2+1) * arr[p1] : 0;
            // sum += arr[p1] > arr[p2]?(mid - p1 + 1):0; //求逆序对
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= rigthIndex) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[leftIndex + i] = help[i];
        }
        return res;
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
