package Chapter2;

/**
 * 剪绳子
 * 给定一根长度为n的绳子，把绳子剪成m段（m,n都是整数，n>1，m>1）,
 * 每段绳子的长度记为k[0],k[1],...,k[m]。求k[0]*k[1]*...*k[m]可能的最大乘积。
 * 例如，当绳子的长度为8时，把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */

import java.util.Scanner;

public class CodeInterviews14_CuttingRope {
	// 动态规划
	public int maxProductDP(int length) {
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;
		int[] dp = new int[length + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= length; i++) {
			int max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int product = dp[j] * dp[i - j];
				if (max < product)
					max = product;
				dp[i] = max;
			}
		}
		return dp[length];
	}

	// 贪婪算法
	public int maxProductGA(int length) {
		if (length < 2)
			return 0;
		if (length == 2)
			return 1;
		if (length == 3)
			return 2;
		if (length == 4)
			return 4;
		// 当绳长大于等于5时，应尽可能多地去剪长度为3的绳子段；
		int timesOf3 = length / 3;
		// 当绳子最后剩下的长度为4时，不能再剪去长度为3的绳子段，而应把绳子剪为长度为2的两段；
		if (length - timesOf3 == 1)
			timesOf3 = 1;
		int timesOf2 = (length - timesOf3 * 3) / 2;
		return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));

	}

	public static void main(String[] args) {
		CodeInterviews14_CuttingRope ins = new CodeInterviews14_CuttingRope();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("DP Sol: " + ins.maxProductDP(n));
		System.out.println("GA Sol: " + ins.maxProductGA(n));
		sc.close();
	}
}
