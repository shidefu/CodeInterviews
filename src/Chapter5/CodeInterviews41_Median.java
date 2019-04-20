package Chapter5;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 解法一：
 * 改写快速排序的Partition函数，每次执行Partition能够将数组按照枢纽元分成左右两部分，
 * 最终返回第k小的枢纽元所在的位置。
 * 对于长度为奇数的数组，k=length/2+1；
 * 对于长度为偶数的数组，则要求第length/2小的元素和第length/2+1小的元素的均值；
 */
public class CodeInterviews41_Median {

	public ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		CodeInterviews41_Median median = new CodeInterviews41_Median();
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			// Partition方法输入：
			int num = in.nextInt();
			median.Insert(num);
			//PriorityQueue方法输入：
			median.insert(num);
			// Partition方法输出：
			System.out.println("Median Sol 1:" + median.GetMedian());
			// PriorityQueue方法输出：
			System.out.println("Median Sol 2:" +median.getMedian());
		}
		in.close();
		// int[] arr = {2,4,3,1};
		// for(int i=0; i<arr.length; i++) {
		// median.list.add(arr[i]);
		// }
		// System.out.println(median.GetMedian());

	}

	public void Insert(Integer num) {
		list.add(num);
	}

	public Double GetMedian() {
		int length = list.size();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = list.get(i);
		}
		if (length % 2 == 1) {
			return (double) arr[Partition(arr, length / 2 + 1, 0, length - 1)];
		} else {
			return (double) (arr[Partition(arr, length / 2, 0, length - 1)]
					+ arr[Partition(arr, length / 2 + 1, 0, length - 1)]) / 2;
		}
	}

	/**
	 * Partition函数：求数组中第k小的数，并将其移动至arr[k-1]处，且左边均小于arr[k-1]，右边均大于arr[k-1]；
	 *
	 * @param arr:  待排数组
	 * @param k:    表示第k小
	 * @param low:  原数组开头索引
	 * @param high: 原数组末尾索引
	 * 
	 * @return 排序完成输出第k小的数的索引，一定为k-1；
	 */
	public int Partition(int[] arr, int k, int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[low];
		while (i < j) {
			while (i < j && pivot < arr[j])
				j--;
			while (i < j && pivot >= arr[i])
				i++;
			swap(arr, i, j);
		}
		swap(arr, i, low);
		if (i == k - 1) {
			return i;
		} else if (i < k - 1) {
			// 第k小的数还在arr[i]右边，因此对右半数组再次执行Partition函数；
			return Partition(arr, k, i + 1, high);
		} else {
			// 第k小的数在arr[i]左边，因此对左半数组再次执行Partition函数；
			return Partition(arr, k, low, i - 1);
		}

	}

	public void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * 解法二：
	 * 建立一个最小堆和一个最大堆，数据流交替进入这两个堆，但必须保证最小堆的堆顶元素不小于最大堆的堆顶元素；
	 * JDK1.8引入的新特性之一——lambda表达式，建立最大堆时不必再重写compare方法； 
	 * PriorityQueue：实现堆；
	 *
	 * @param arr:  待排数组
	 * @param k:    表示第k小
	 * @param low:  原数组开头索引
	 * @param high: 原数组末尾索引
	 * 
	 * @return 排序完成输出第k小的数的索引，一定为k-1；
	 */
	int length;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

	public void insert(Integer num) {
		length++;
		if (length % 2 == 1) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		} else {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
	}

	public Double getMedian() {
		if (length % 2 == 1) {
			return (double) (minHeap.peek());
		} else {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		}
	}

}
