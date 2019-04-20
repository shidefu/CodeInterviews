package Chapter5;

/**
 * 礼物的最大价值
 * 在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */

import java.util.Scanner;

public class CodeInterviews47_MaxValue {

	public int getMaxValue(int[] values, int rows, int cols) {
		if (values == null || rows <= 0 || cols <= 0) {
			return 0;
		}
		int[] dp = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int up = 0;
				int left = 0;
				if (i > 0)
					up = dp[j];
				if (j > 0)
					left = dp[j - 1];
				dp[j] = Math.max(up, left) + values[i * cols + j];
			}
		}
		return dp[cols - 1];
	}

	public static void main(String[] args) {
		CodeInterviews47_MaxValue ins = new CodeInterviews47_MaxValue();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int[] values = new int[arr.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = Integer.parseInt(arr[i]);
		}
		//1 10 3 8 12 2 9 6 5 7 4 11 3 7 16 5
		//4x4矩阵，(1,12,5,7,7,16,5)路径最优，输出53；
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.close();
		int maxValue = ins.getMaxValue(values, rows, cols);
		System.out.println(maxValue);
	}
}
