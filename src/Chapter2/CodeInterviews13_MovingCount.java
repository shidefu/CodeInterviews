package Chapter2;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7=18。 但是，它不能进入方格（35,38），因为3+5+3++8=19。
 * 请问该机器人能够达到多少个格子？
 */

public class CodeInterviews13_MovingCount {

	public static int movingCount(int threshold, int rows, int cols) {
		boolean[] flag = new boolean[rows * cols];
		flag[0] = false;
		return movingCountCore(threshold, 0, 0, rows, cols, flag);
	}

	public static int movingCountCore(int threshold, int i, int j, int rows, int cols, boolean[] flag) {
		int index = i * cols + j;
		if (i < 0 || j < 0 || i >= rows || j >= cols || threshold < numSum(i) + numSum(j) || flag[index] == true)
			return 0;
		flag[index] = true;
		int s1 = movingCountCore(threshold, i - 1, j, rows, cols, flag);
		int s2 = movingCountCore(threshold, i + 1, j, rows, cols, flag);
		int s3 = movingCountCore(threshold, i, j - 1, rows, cols, flag);
		int s4 = movingCountCore(threshold, i, j + 1, rows, cols, flag);
		return 1 + s1 + s2 + s3 + s4;
	}

	public static int numSum(int a) {
		int num = 0;
		while (a > 0) {
			num += a - a / 10 * 10;
			a /= 10;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(movingCount(3, 3, 2));
	}

}
