package Chapter6;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayDeque;

public class CodeInterviews59_SlidingWindow {

	public ArrayList<Integer> list = new ArrayList<>();

	/**
	 * 队列法:维持一个长度=size的队列
	 * 
	 * @param num  输入数组
	 * @param size 滑动窗口长度
	 * @return 滑动窗口最大值集合
	 */
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < num.length; i++) {
			queue.offer(num[i]);
			if (queue.size() == size) {
				list.add(Collections.max(queue));
				queue.poll();
			}
		}
		return list;
	}

	/**
	 * 双端队列法:把过期的和小于进队元素的元素淘汰掉,注意进队的是数组元素的下标!
	 * 
	 * @param num  输入数组
	 * @param size 滑动窗口长度
	 * @return 滑动窗口最大值集合
	 */
	public ArrayList<Integer> maxInWindowsDeque(int[] num, int size) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < num.length; i++) {
			// 滑动窗口起始位置；
			int begin = i - size + 1;
			if (queue.isEmpty()) {
				queue.offer(i);
			}
			// 最大元素过期；
			if (begin > queue.peekFirst()) {
				queue.pollFirst();
			}
			// 队尾小于当前元素的全部弹出；
			while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {
				queue.pollLast();
			}
			queue.offer(i);
			// 开始滑动窗口；
			if (begin >= 0) {
				list.add(num[queue.peekFirst()]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int size = sc.nextInt();
		sc.close();
		String[] arr = str.split(",");
		int[] num = new int[arr.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		ArrayList<Integer> list1 = new CodeInterviews59_SlidingWindow().maxInWindows(num, size);
		ArrayList<Integer> list2 = new CodeInterviews59_SlidingWindow().maxInWindowsDeque(num, size);
		System.out.println("Solution by a queue: " + list1);
		System.out.println("Solution by a dequeue: " + list2);
	}

}
