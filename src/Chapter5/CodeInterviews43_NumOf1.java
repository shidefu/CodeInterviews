package Chapter5;

/**
 * 1~n整数中1出现的次数
 * 给定一个数组，返回它的最大连续子数组的和（子数组的长度至少是1）
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */

import java.util.Scanner;

public class CodeInterviews43_NumOf1 {

	// 非递归解法，复杂度O(logn)；
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;// 1的个数
		int i = 1;// 当前位
		int current = 0, after = 0, before = 0;
		while ((n / i) != 0) {
			current = (n / i) % 10; // 高位数字
			before = n / (i * 10); // 当前位数字
			after = n - (n / i) * i; // 低位数字
			// 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
			if (current == 0)
				count += before * i;
			// 如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
			else if (current == 1)
				count += before * i + after + 1;
			// 如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
			else {
				count += (before + 1) * i;
			}
			// 前移一位
			i = i * 10;
		}
		return count;
	}

	// 递归解法，复杂度O(logn)；
	public int NumberOf1Between1AndN_Solution2(int n) {
		if (n < 0) {
			return 0;
		}
		String str = Integer.toString(n);
		int result = getNumberOf1(str, 0);
		return result;
	}

	public static int getNumberOf1(String str, int index) {
		int length = str.length() - index;
		if (length == 1 && str.charAt(index) == '0') {
			return 0;
		}
		if (length == 1) {
			return 1;
		}
		// 计算最高位的1
		int first = str.charAt(index) - '0';
		int result = 0;
		if (first > 1) {
			result += exp(length - 1);
		} else if (first == 1) {
			result += 1 + Integer.parseInt(str.substring(index + 1));
		}
		// 计算除了最高位的其他位中1的数目
		result += first * (length - 1) * exp(length - 2);
		// 递归计算比如2345中0---345中1的个数
		result += getNumberOf1(str, index + 1);

		return result;
	}

	public static int exp(int n) {
		int result = 1;
		while (n >= 1) {
			result *= 10;
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		CodeInterviews43_NumOf1 ins = new CodeInterviews43_NumOf1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println("UnRecursive: " + ins.NumberOf1Between1AndN_Solution(n));
		System.out.println("Recursive: " + ins.NumberOf1Between1AndN_Solution(n));
	}

}
