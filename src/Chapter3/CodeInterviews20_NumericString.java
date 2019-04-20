package Chapter3;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class CodeInterviews20_NumericString {

	public static void main(String[] args) {
		String[] s1 = { "+100", "5e2", "-123", "3.1416", "-1E-16" };
		String[] s2 = { "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3" };
		for (int i = 0; i < s1.length; i++) {
			char[] str1 = s1[i].toCharArray();
			System.out.println(isNumeric(str1));
		}

		for (int i = 0; i < s2.length; i++) {
			char[] str2 = s2[i].toCharArray();
			System.out.println(isNumeric(str2));
		}
	}

	public static boolean isNumeric(char[] str) {
		if (str == null) {
			return false;
		}

		boolean hasEe = false;
		boolean sign = false;
		boolean hasPoint = false;
		for (int i = 0; i < str.length; i++) {
			if (isEe(str[i])) {
				if (i == str.length - 1)
					return false;
				if (hasEe)
					return false;
				hasEe = true;
			} else if (isSign(str[i])) {
				if (sign && !isEe(str[i - 1]))
					return false;
				if (!sign && i > 0 && !isEe(str[i - 1]))
					return false;
				sign = true;
			} else if (str[i] == '.') {
				if (hasPoint || hasEe)
					return false;
				hasPoint = true;
			} else if (!isNum(str[i]))
				return false;
		}
		return true;
	}

	private static boolean isNum(char a) {
		return a >= '0' && a <= '9';
	}

	private static boolean isEe(char a) {
		return a == 'E' || a == 'e';
	}

	private static boolean isSign(char a) {
		return a == '+' || a == '-';
	}
}
