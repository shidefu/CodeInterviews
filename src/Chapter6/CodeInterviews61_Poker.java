package Chapter6;

/**
 * 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌,判断是不是一个顺子,即这5张牌是不是连续的.
 * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
 */

import java.util.Arrays;

public class CodeInterviews61_Poker {

	public boolean isContinuous(int[] a) {
		if (a == null || a.length == 0)
			return false;
		Arrays.sort(a);
		int zeros = 0;
		int interval = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == 0) {
				zeros++;
				continue;
			}
			if (a[i] == a[i + 1])
				return false;
			interval += a[i + 1] - a[i] - 1;
		}
		return interval <= zeros ? true : false;
	}

}
