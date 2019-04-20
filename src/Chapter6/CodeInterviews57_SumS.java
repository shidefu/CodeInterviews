package Chapter6;

/**
 * 和为S的数字
 * 1.和为S的两个数字：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 2.和为S的连续正数序列：
 * 输入一个正数S，打印出所有和为S的连续正数序列（至少含有两个数）。例如，输入15，
 * 由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列1~5，4~6和7~8。
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CodeInterviews57_SumS {

	/**
	 * 和为S的两个数字
	 * 
	 * @param array 输入数组
	 * @param sum   和
	 * @return list 数组中和为S的两个数字
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array == null || array.length < 2)
			return list;
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
				// break;也可以
			} else if (array[i] + array[j] < sum)
				i++;
			else
				j--;
		}
		return list;
	}

	/**
	 * 和为S的连续正数序列
	 * 
	 * @param sum 和
	 * @return result 序列集和
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int low = 1;
		int high = 2;
		while (low < high) {
			int curSum = (low + high) * (high - low + 1) / 2;
			if (curSum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = low; i <= high; i++)
					list.add(i);
				result.add(list);
				// low++也可以
				high++;
			} else if (curSum < sum)
				high++;
			else
				low++;
		}
		return result;
	}

	public static void main(String[] args) {
		CodeInterviews57_SumS ins = new CodeInterviews57_SumS();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int sum = sc.nextInt();
		sc.close();
		String[] arr = str.split(" ");
		int[] array = new int[arr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		System.out.println("2 Numbers With Sum " + sum + " " + ins.FindNumbersWithSum(array, sum));
		System.out.println("All Continuous Sequences With Sum " + sum + " " + ins.FindContinuousSequence(sum));

	}

}
