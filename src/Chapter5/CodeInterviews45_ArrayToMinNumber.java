package Chapter5;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

import java.util.Arrays;
//import java.util.Comparator;

public class CodeInterviews45_ArrayToMinNumber {

	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return "";

		String[] str = new String[numbers.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		// 按照组成最小数的规则对数组“排序”；
//		Arrays.sort(str, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				String c1 = s1 + s2;
//				String c2 = s2 + s1;
//				return c1.compareTo(c2);
//			}
//		});

		// lambda表达式
		Arrays.sort(str, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		CodeInterviews45_ArrayToMinNumber ins = new CodeInterviews45_ArrayToMinNumber();
		int[] array = { 3, 32, 321 };
		System.out.println(ins.PrintMinNumber(array));
		// 输出321323；
	}

}
