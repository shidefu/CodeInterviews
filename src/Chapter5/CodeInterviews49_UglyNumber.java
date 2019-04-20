package Chapter5;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

import java.util.ArrayList;

public class CodeInterviews49_UglyNumber {

	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int i, j, k;
		i = j = k = 0;
		while (list.size() < index) {
			int p2 = list.get(i) * 2;
			int p3 = list.get(j) * 3;
			int p5 = list.get(k) * 5;
			int min = Math.min(p2, Math.min(p3, p5));
			list.add(min);
			if (min == p2)
				i++;
			if (min == p3)
				j++;
			if (min == p5)
				k++;
		}
		return list.get(list.size() - 1);
	}

}
