package Chapter3;

/**
 * 打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数99.
 */

import java.util.Scanner;

public class CodeInterviews17_Print1ToMaxNDigits {

	public void Print1ToMaxNDigits(int n) {
		if (n <= 0)
			return;
		char[] number = new char[n + 1];
		number[0] = '0';

		for (int i = 0; i < 10; i++) {
			number[0] = Character.forDigit(i, 10);
			Print1ToMaxNDigitsCore(number, n, 0);
		}
	}

	private void Print1ToMaxNDigitsCore(char[] number, int length, int index) {
		if (index == length - 1) {
			PrintNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index + 1] = Character.forDigit(i, 10);
			Print1ToMaxNDigitsCore(number, length, index + 1);
		}
	}

	public void PrintNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; i++) {
			if (isBeginning0 && number[i] != '0')
				isBeginning0 = false;
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CodeInterviews17_Print1ToMaxNDigits ins = new CodeInterviews17_Print1ToMaxNDigits();
		Scanner sc = new Scanner(System.in);
		ins.Print1ToMaxNDigits(sc.nextInt());
		sc.close();
	}

}
