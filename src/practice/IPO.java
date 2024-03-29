package practice;

import java.util.Comparator;
import java.util.PriorityQueue;
/**n个项目，分别由花费和利润；  拿100块钱，1一个花费100，利润10的项目，收回110
 * */
public class IPO {
	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;  //升序  前-后   小根堆 升序排列
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p; //降序   后-前   大根堆 降序排解
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}
		//贪心策略：建立小根堆（所有项目），花费谁小，谁在头部；依次弹出头部，看初始资金，只要小<初始资金；然后将项目进入大根堆
		// 在大根堆（解锁的项目）按收益排，进行排序
		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		return W;
	}

	public static  void main(String[] arg ){
		int[] Profits ={1,2,3,4,5};//利润
		int[] Capital ={10,20,30,40,50};//花费
		int k = 4;//最多做的项目书
		int w = 20;//初始资金
		System.out.println(findMaximizedCapital(k,w,Profits,Capital));//求最终剩余钱树

	}

}
