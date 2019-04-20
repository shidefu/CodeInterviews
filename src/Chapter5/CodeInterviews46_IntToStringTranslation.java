package Chapter5;

/**
 * 把数字翻译成字符串
 * 给定一个数字，按照如下规则把它翻译为字符串： 0翻译成"a"，1翻译成"b"，……，11翻译成"1"，……，25翻译成"z"。
 * 一个数字可能有多个翻译。例如，12258有5种不同的翻译，分别是"bccfi","bwfi","bczi","mcfi","mzi".
 * 请实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */

import java.util.Scanner;

public class CodeInterviews46_IntToStringTranslation {
	
	public int getTranslationCount(int n) {
		if (n < 0) {
			return 0;
		}
		String number = String.valueOf(n);
		return getTranslationCount(number);
	}
	
	public int getTranslationCount(String number) {
		int length = number.length();
		// dp[i]表示0~i位的子串的不同翻译方法数；
		int[] dp = new int[length];
		dp[0] = 1;
		for (int i = 1; i <length; i++) {
			int digit1 = number.charAt(i - 1) - '0';
			int digit2 = number.charAt(i) - '0';
			int converted = digit1 * 10 + digit2;
			if (converted >= 10 && converted <= 25) {
				if (i>2)
					dp[i] = dp[i - 1] + dp[i - 2];
				else
					dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[length-1];
	}

	public static void main(String[] args) {
		CodeInterviews46_IntToStringTranslation ins = new CodeInterviews46_IntToStringTranslation();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(ins.getTranslationCount(n));
		sc.close();
	}

}
