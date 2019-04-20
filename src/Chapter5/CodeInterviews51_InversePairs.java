package Chapter5;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007。
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 *         对于%50的数据,size<=10^4；
 *         对于%75的数据,size<=10^5；
 *         对于%100的数据,size<=2*10^5；
 * 示例1：
 * 输入：{1,2,3,4,5,6,7,0}，输出：7
 */

import java.util.Scanner;

public class CodeInterviews51_InversePairs {

	int count;

	// 采用分治法，归并排序思想，时间复杂度O(nlogn)，但需要长度为n的辅助数组，空间复杂度0(n)，空间换时间
	public int InversePairs(int[] array) {
		count = 0;
		if (array == null || array.length == 0)
			return 0;
		MergeSort(array, 0, array.length - 1);
		return count;
	}

	public void MergeSort(int[] array, int start, int end) {
		if (end <= start)
			return;
		int mid = (start + end) / 2;
		MergeSort(array, start, mid);
		MergeSort(array, mid + 1, end);
		Merge(array, start, mid, end);
	}

	public void Merge(int[] array, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		int[] tmp = new int[end - start + 1];
		while (i <= mid && j <= end) {
			if (array[i] <= array[j])
				tmp[k++] = array[i++];
			else {
				tmp[k++] = array[j++];
				count += mid - i + 1;
				count %= 1000000007;
			}
		}
		while (i <= mid)
			tmp[k++] = array[i++];
		while (j <= end)
			tmp[k++] = array[j++];
		for (int n = 0; n < k; n++)
			array[start + n] = tmp[n];
	}

	public static void main(String[] args) {
		CodeInterviews51_InversePairs ins = new CodeInterviews51_InversePairs();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		String[] arr = str.split(",");
		int[] array = new int[arr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		// int[] array = { 7, 5, 6, 4 };
		System.out.println(ins.InversePairs(array));
		// 一共有5对逆序对，即(7, 6),(7, 5),(7, 4),(6, 4),(5, 4);
	}

}
