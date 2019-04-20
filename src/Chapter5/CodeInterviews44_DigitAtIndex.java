package Chapter5;

/**
 * 数字序列中的某一位数字
 * 数字以0123456789101112131415...的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */

import java.util.Scanner;

public class CodeInterviews44_DigitAtIndex {

	public int digitAtIndex(int index) {
		if (index < 0)
			return -1;
		int digits = 1;
		while (true) {
			int numbers = countOfIntegers(digits);
			if (index < numbers * digits)
				return digitAtIndex(index, digits);
			index -= digits * numbers;
			digits++;
		}
	}

	/**
	 * 求m位的数字总共的个数
	 * 
	 * @param digits 位数
	 * @return digits位十进制数的总个数
	 */
	private int countOfIntegers(int digits) {
		if (digits == 1)
			return 10;
		int count = (int) Math.pow(10, digits - 1);
		return count * 9;
	}

	/**
	 * 找某一位数字定位于某m位数之中，找到位于其中的第几位
	 * 
	 * @param index  要找的数字的位数
	 * @param digits 位数
	 * @return 数字序列第index位数字位于某个digits位数的位数
	 */
	private int digitAtIndex(int index, int digits) {
		int number = beginNumber(digits) + index / digits;
		int indexFromRight = digits - index % digits;
		for (int i = 1; i < indexFromRight; i++) {
			number /= 10;
		}
		return number % 10;
	}

	/**
	 * 求m位数的第一个数字
	 * 
	 * @param digits 位数
	 * @return digits位数的首位数字
	 */
	private int beginNumber(int digits) {
		if (digits == 1) {
			return 0;
		}
		return (int) Math.pow(10, digits - 1);
	}

	public static void main(String[] args) {
		CodeInterviews44_DigitAtIndex ins = new CodeInterviews44_DigitAtIndex();
		Scanner sc = new Scanner(System.in);
		System.out.println(ins.digitAtIndex(sc.nextInt()));
		sc.close();
	}

}
