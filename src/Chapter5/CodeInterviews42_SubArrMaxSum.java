package Chapter5;

/**
 * 连续子数组的最大和
 * 给定一个数组，返回它的最大连续子数组的和（子数组的长度至少是1）
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */

public class CodeInterviews42_SubArrMaxSum {

	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int sum = 0;
		int result = array[0];
		for (int i = 0; i < array.length; i++) {
			if (sum >= 0) {
				sum += array[i];
			} else {
				sum = array[i];
			}
			if (sum > result)
				result = sum;
		}
		return result;
	}

	public static void main(String[] args) {
		CodeInterviews42_SubArrMaxSum ins = new CodeInterviews42_SubArrMaxSum();
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.print(ins.FindGreatestSumOfSubArray(array));
		// 子数组{3，10，-4，7，2}和最大，输出18
	}

}
