package Chapter3;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配。
 */

public class CodeInterviews19_RegexMatching {

	public static void main(String[] args) {
		char[] str = { 'a', 'a', 'a' };
		char[] pattern1 = { 'a', '.', 'a' };
		char[] pattern2 = { 'a', 'b', '*', 'a', 'c', '*', 'a' };
		char[] pattern3 = { 'a', 'a', '.', 'a' };
		char[] pattern4 = { 'a', 'b', '*', 'a' };
		// 递归方法
		System.out.println(match(str, pattern1));
		System.out.println(match(str, pattern2));
		System.out.println(match(str, pattern3));
		System.out.println(match(str, pattern4));
		// DP方法
		System.out.println(matchDP(str, pattern1));
		System.out.println(matchDP(str, pattern2));
		System.out.println(matchDP(str, pattern3));
		System.out.println(matchDP(str, pattern4));

	}

	public static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str, pattern, 0, 0);
	}

	private static boolean matchCore(char[] str, char[] pattern, int i, int j) {
		// 如果模式先遍历完，则一定不匹配；如果同时遍历完，则一定匹配；
		if (j == pattern.length) {
			return i == str.length;
		}
		// 注意防止数组索引OutOfBounds;
		if (j < pattern.length - 1 && pattern[j + 1] == '*') {
			// 如果模式下一个为'*'，且当前匹配；
			if (i < str.length && (str[i] == pattern[j] || (pattern[j] == '.'))) {
				// 模式后移两位，或者模式不变，字符串后移一位；
				return matchCore(str, pattern, i, j + 2) || matchCore(str, pattern, i + 1, j);
			} else {
				// 当前不匹配，模式后移两位；
				return matchCore(str, pattern, i, j + 2);
			}
		}
		// 模式下一个不为'*'，且当前匹配，则往后匹配；
		if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
			return matchCore(str, pattern, i + 1, j + 1);
		}
		return false;
	}

	public static boolean matchDP(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
		dp[0][0] = true;
		for (int i = 0; i <= str.length; i++) {
			for (int j = 1; j <= pattern.length; j++) {
				if (j > 1 && pattern[j - 1] == '*') {
					if (i > 0 && (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.')) {
						// 模式的'*'前一位字符与字符串的上个字符匹配
						dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
					} else {
						// 模式的'*'前一位字符与字符串的上个字符不匹配
						dp[i][j] = dp[i][j - 2];
					}
				} else if (i > 0 && (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')) {
					// 模式的前一位字符与字符串的上个字符匹配
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}
		return dp[str.length][pattern.length];
	}

}
