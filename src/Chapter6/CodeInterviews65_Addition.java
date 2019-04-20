package Chapter6;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class CodeInterviews65_Addition {

	/**
	 * 求加法运算
	 * 
	 * @param num1 当前位之和
	 * @param num2 进位值
	 * @return 两数之和
	 */
	public int Add(int num1, int num2) {
		while (num1 != 0) {
			int tmp = num1 ^ num2;
			num1 = (num1 & num2) << 1;
			num2 = tmp;
		}
		return num2;
	}

}
