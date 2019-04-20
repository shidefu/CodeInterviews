package Chapter2;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class CodeInterviews15_NumberOfOne {

	public int NumberOf1(int n) {
		int numOf1 = 0;
		while (n != 0) {
			numOf1++;
			n = n & (n - 1);
		}
		return numOf1;
	}

}
