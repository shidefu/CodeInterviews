package Chapter6;

/**
 * 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1).
 */

public class CodeInterviews56_NumsAppearOnce {

	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 9 };
		// int[] array = {1,2};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		findNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + " " + num2[0]);
	}

	/**
	 * 
	 * @param array 输入数组
	 * @param num1  长度为1的数组，传出参数，num1[0]为返回结果
	 * @param num2  长度为1的数组，传出参数，num2[0]为返回结果
	 */
	public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array.length == 2) {
			num1[0] = array[0];
			num2[0] = array[1];
			return;
		}
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result ^= array[i];
		}
		num1[0] = num2[0] = 0;
		int index = findFirst1(result);
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	/**
	 * 找到整数二进制中从左往右第一个1的位置
	 * 
	 * @param num 输入整数
	 * @return 从右往左第一个1的位置索引
	 */
	public static int findFirst1(int num) {
		int index = 0;
		while (((num & 1) == 0) && (index < 32)) {
			num >>= 1;
			index++;
		}
		return index;
	}

	/**
	 * 判断整数二进制的某位是否为1
	 * 
	 * @param num   输入整数
	 * @param index 索引
	 * @return num二进制从右往左第index位是否为1
	 */
	public static boolean isBit1(int num, int index) {
		return ((num >> index) & 1) == 1 ? true : false;
	}

}
