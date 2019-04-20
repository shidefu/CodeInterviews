package Chapter6;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16的时候卖出，则能收获最大利润11.
 */

import java.util.Scanner;

public class CodeInterviews63_StockMaxDiff {

	public int maxDiff(int[] array, int length) {
		if (array == null || length < 2) {
			return 0;
		}
		int min = array[0];
		int maxDiff = array[1] - min;

		for (int i = 2; i < length; i++) {
			min = Math.min(array[i - 1], min);
			int curDiff = array[i] - min;
			maxDiff = Math.max(curDiff, maxDiff);
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		CodeInterviews63_StockMaxDiff ins = new CodeInterviews63_StockMaxDiff();
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(ins.maxDiff(array, length));
	}

}
