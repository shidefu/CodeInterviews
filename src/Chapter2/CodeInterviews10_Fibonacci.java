package Chapter2;

/** 
 * 斐波那契数列
 * 输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */

public class CodeInterviews10_Fibonacci {

	public int Fibonacci1(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci1(n - 1) + Fibonacci1(n - 2);
		}
	}

	public int Fibonacci2(int n) {
		return Fibonacci2Core(n, 0, 1);
	}

	private static int Fibonacci2Core(int n, int acc1, int acc2) {
		if (n == 0)
			return 0;
		if (n == 1)
			return acc2;
		else
			return Fibonacci2Core(n - 1, acc2, acc1 + acc2);
	}

	public int Fibonacci3(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int prePre = 0;
		int pre = 1;
		int cur = 0;
		int i = 1;
		while (i < n) {
			cur = prePre + pre;
			prePre = pre;
			pre = cur;
			i++;
		}
		return cur;
	}

}
