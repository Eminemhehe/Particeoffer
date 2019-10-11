package practice;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 求金条长度花费
 *【10 20 30】一个金条长度位10+20+30，每次切金条的花费位90=40+50；那么花费位90；
 * 10 20 30 代表三个长度需求，求总花费最低
 * 将整体加入到一个小根堆（拿堆去解决贪心）
 *
 * */
public class Less_Money {

	public static int lessMoney(int[] arr) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();//优先级队列就是堆，系统实现
		for (int i = 0; i < arr.length; i++) {
			pQ.add(arr[i]);
		}
		int sum = 0;
		int cur = 0;
		//将小根堆最小的2个拿出来，合并之后，将其在放入小根堆；
		while (pQ.size() > 1) {
			cur = pQ.poll() + pQ.poll();
			sum += cur;
			pQ.add(cur);
		}
		return sum;
	}

	public static class MinheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2; // < 0  o1 < o2  负数
		}

	}

	public static class MaxheapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1; // <   o2 < o1
		}

	}

	public static void main(String[] args) {
		// solution
		int[] arr = { 6, 7, 8, 9 };
		System.out.println(lessMoney(arr));

		int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

		// min heap
		PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ1.add(arrForHeap[i]);
		}
		while (!minQ1.isEmpty()) {
			System.out.print(minQ1.poll() + " ");
		}
		System.out.println();

		// min heap use Comparator
		PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			minQ2.add(arrForHeap[i]);
		}
		while (!minQ2.isEmpty()) {
			System.out.print(minQ2.poll() + " ");
		}
		System.out.println();

		// max heap use Comparator
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
		for (int i = 0; i < arrForHeap.length; i++) {
			maxQ.add(arrForHeap[i]);
		}
		while (!maxQ.isEmpty()) {
			System.out.print(maxQ.poll() + " ");
		}

	}

}
