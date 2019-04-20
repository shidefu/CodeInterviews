package Chapter6;

/**
 * 圆圈中最后剩下的数字
 * 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 */

import java.util.ArrayList;

public class CodeInterviews62_JosephusProblem {

	public int LastRemaining_Solution(int n, int m) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int p = 0;
		while (list.size() > 1) {
			p = (p + m - 1) % list.size();
			list.remove(p);
		}
		return list.size() == 1 ? list.get(0) : -1;
	}

}
