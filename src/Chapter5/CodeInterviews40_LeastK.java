package Chapter5;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CodeInterviews40_LeastK {
	/** 堆排序
	 * 
	 * @param input 输入数组
	 * @param k     k<=input.length
	 * @return 最小k个数
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (input.length == 0 || input.length < k || input == null) {
			return result;
		}

		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(input, i, k - 1);
		}

		for (int i = k; i < input.length; i++) {
			int temp;
			if (input[0] > input[i]) {
				temp = input[0];
				input[0] = input[i];
				input[i] = temp;
				adjustHeap(input, 0, k - 1);
			}
		}

		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	/** 调整最大堆
	 * 
	 * @param input 输入数组
	 * @param i     数组元素索引
	 * @param k
	 */
	public void adjustHeap(int[] input, int i, int k) {
		int temp = input[i];
		for (int j = 2 * i + 1; j <= k; j = 2 * j + 1) {
			if (j < k && input[j] < input[j + 1]) {
				j++;
			}

			if (temp > input[j]) {
				break;
			} else {
				input[i] = input[j];
				i = j;
			}
		}
		input[i] = temp;
	}

	/** 直接用优先队列实现最大堆
	 * 
	 * @param input 输入数组
	 * @param k     k<=input.length
	 * @return 最小k个数
	 */
	public ArrayList<Integer> leastKNumbers(int[] input, int k) {
		ArrayList<Integer> leastK = new ArrayList<>();
		/*
		 * PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new
		 * Comparator<Integer>(){
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * o2.compareTo(o1); } });
		 */
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (o1, o2) -> o2.compareTo(o1));

		int length = input.length;
		for (int i = 0; i < length; i++) {
			if (i < k) {
				maxHeap.offer(input[i]);
			} else {
				if (maxHeap.peek() > input[i]) {
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
		}
		for (Integer integer : maxHeap) {
			leastK.add(integer);
		}
		return leastK;
	}

	public static void main(String[] args) {
		CodeInterviews40_LeastK ins = new CodeInterviews40_LeastK();
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.nextLine();
		String str = in.nextLine();
		in.close();
		String[] arr = str.split(" ");
		int[] input = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			input[i] = Integer.parseInt(arr[i]);
		}
		//手写堆排序输出结果
		System.out.println("Partition Sol:" + ins.GetLeastNumbers_Solution(input, k));
		//优先队列实现堆输出结果
		System.out.println("PriorityQueue Sol:" + ins.leastKNumbers(input, k));

	}

}
