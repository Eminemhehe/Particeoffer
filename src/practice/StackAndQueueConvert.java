package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1、栈实现队列：
 *    poll时有两个原则
 * 		1、pop栈里有东西，push不能向pop栈里导数据
 * 		2、push栈要导数据，一次要导完；
 * 2、队列实现栈结构
 *    1、2个队列 data help
 *    2、进队列正常进，出队列时，保留1个数字，其他数字进入help栈，将data栈中唯一的数弹出
 *    3、将data栈和help栈交换，数据只进data栈
 * */
public class StackAndQueueConvert {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}


		//poll时有两个原则
		//1、pop栈里有东西，push不能向pop栈里导数据
		//2、要导数据，一次要导完；
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		}

		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}

}
