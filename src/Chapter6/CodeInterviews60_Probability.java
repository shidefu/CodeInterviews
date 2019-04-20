package Chapter6;

/**
 * n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和记为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 */

import java.util.Scanner;

public class CodeInterviews60_Probability {

	public static final int MAX_VALUE = 6;

	public void printProbability(int n) {
		if (n < 1)
			return;
		// 在一轮循环中，第一个数组中的第n个数表示和为n出现的次数；
		// 在下一轮循环中，加上一个新骰子，此时和为n出现的次数等于上轮循环中和为n-1,n-2,…,n-6的次数总和；
		int[][] dp = new int[2][MAX_VALUE * n + 1];
		for (int i = 0; i < MAX_VALUE * n + 1; i++) {
			dp[0][i] = 0;
			dp[1][i] = 0;
		}
		int flag = 0;
		for (int i = 1; i <= MAX_VALUE; i++)
			dp[flag][i] = 1;
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < k; i++)
				dp[1 - flag][i] = 0;
			for (int i = k; i <= MAX_VALUE * k; i++) {
				dp[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= MAX_VALUE; j++)
					// dp[1][i] = dp[0][i-1] + dp[0][i-2] + ... + dp[0][i-6];
					dp[1 - flag][i] += dp[flag][i - j];
			}
			flag = 1 - flag;
		}
		double total = Math.pow((double) MAX_VALUE, n);
		for (int i = n; i <= MAX_VALUE * n; i++) {
			double ratio = (double) dp[flag][i] / total;
			System.out.println(i + ", " + ratio);
		}
	}

	public static void main(String[] args) {
		CodeInterviews60_Probability ins = new CodeInterviews60_Probability();
		Scanner sc = new Scanner(System.in);
		ins.printProbability(sc.nextInt());
		sc.close();
	}

}
