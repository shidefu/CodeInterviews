package Chapter7;

/**
 * 把字符串转换成整数 
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */

import java.util.Scanner;

public class CodeInterviews67_StrToInt {

	public static boolean flag;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(StrToInt(new String(in.next())));
		in.close();
	}

	public static int StrToInt(String str) {
		flag = false;
		if (str == null || str.length() == 0) {
			flag = true;
			return 0;
		}
		long s = 0;
		int length = str.length();
		char[] a = str.toCharArray();
		// 先检测a[0]是否合法
		if (!(a[0] == '+' || a[0] == '-' || (a[0] >= '0' && a[0] <= '9'))) {
			flag = true;
			return 0;
		} else {// a[0]合法
			for (int i = 1; i < length; i++) {
				if (!(a[i] >= '0' && a[i] <= '9')) {
					flag = true;
					return 0;
				}
			}
			// 字符串合法
			if (a[0] != '+' && a[0] != '-') {
				for (int i = 0; i < length; i++) {
					s = s * 10 + a[i] - '0';
				}
				// 判断是否溢出
				if (s >= Integer.MIN_VALUE && s <= Integer.MAX_VALUE)
					return (int) s;
				else {
					flag = true;
					return 0;
				}
			}
			if (a[0] == '+' || a[0] == '-') {
				for (int i = 1; i < length; i++) {
					s = s * 10 + a[i] - '0';
				}
				if (a[0] == '-') {
					s = -s;
					// 判断是否下溢；
					if (s >= Integer.MIN_VALUE)
						return (int) s;
				}
				// 判断是否上溢；
				if (a[0] == '+' && s <= Integer.MAX_VALUE) {
					return (int) s;
				} else {
					flag = true;
					return 0;
				}
			}
		}
		return 0;
	}
}
