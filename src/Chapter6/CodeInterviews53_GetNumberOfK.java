package Chapter6;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */

import java.util.Arrays;
import java.util.Scanner;

public class CodeInterviews53_GetNumberOfK {

	public int GetNumberOfK(int[] array, int k) {
		int length = array.length;
		if (length == 0)
			return 0;
		else {
			int firstK = getFirstK(array, 0, length - 1, k);
			int lastK = getLastK(array, 0, length - 1, k);
			if (firstK == -1 || lastK == -1)
				return 0;
			else
				return lastK - firstK + 1;
		}
	}

	public int getFirstK(int[] array, int start, int end, int k) {
		if (start > end)
			return -1;
		int mid = start + ((end - start) >> 1);
		if (array[mid] > k)
			return getFirstK(array, start, mid - 1, k);
		else if (array[mid] < k)
			return getFirstK(array, mid + 1, end, k);
		else if (mid - 1 >= start && array[mid - 1] == k)
			return getFirstK(array, start, mid - 1, k);
		else
			return mid;
	}

	public int getLastK(int[] array, int start, int end, int k) {
		if (start > end)
			return -1;
		int mid = start + ((end - start) >> 1);
		if (array[mid] > k)
			return getLastK(array, start, mid - 1, k);
		else if (array[mid] < k)
			return getLastK(array, mid + 1, end, k);
		else if (mid + 1 <= end && array[mid + 1] == k)
			return getLastK(array, mid + 1, end, k);
		else
			return mid;
	}

	public static void main(String[] args) {
		CodeInterviews53_GetNumberOfK ins = new CodeInterviews53_GetNumberOfK();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int k = sc.nextInt();
		sc.close();
		String[] arr = str.split(",");
		int[] array = new int[arr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(array);
		System.out.println(ins.GetNumberOfK(array, k));
	}

}
