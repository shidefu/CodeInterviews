package Chapter5;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'的字符。
 * 例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是”acfr“，长度为4.
 */

import java.util.Arrays;
import java.util.Scanner;

public class CodeInterviews48_LongestSubstring {

	public int longestSubstringWithoutDuplication(String str) {
		/**
		 * dp[i] 以字符串中第i个字符为结尾的不含重复字符子串的最大长度；
		 * index[i] 存储26个字符上次出现在字符串中位置的下标；
		 */
		int[] dp = new int[str.length()];
		dp[0] = 1;
		int[] index = new int[26];
		for (int i = 0; i < 26; i++) {
			index[i] = -1;
		}
		for (int i = 0; i < dp.length; i++) {
			int preIndex = index[str.charAt(i) - 'a'];
			if (i > 0) {
				int d = i - preIndex;
				if (preIndex < 0 || d > dp[i - 1])
					dp[i] = dp[i - 1] + 1;
				else
					dp[i] = d;
			}
			index[str.charAt(i) - 'a'] = i;
		}
		Arrays.sort(dp);
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		CodeInterviews48_LongestSubstring ins = new CodeInterviews48_LongestSubstring();
		Scanner sc = new Scanner(System.in);
		int length = ins.longestSubstringWithoutDuplication(sc.next());
		sc.close();
		System.out.println(length);
	}
}
