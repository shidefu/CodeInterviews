package Chapter1;

/**
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同） ，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class CodeInterviews04_Find {

	public boolean Find(int target, int[][] array) {

		int rows = array.length;
		int cols = array[0].length;
		int i = rows - 1, j = 0;
		while (i >= 0 && j < cols) {
			if (target < array[i][j])
				i--;
			else if (target > array[i][j])
				j++;
			else
				return true;
		}
		return false;

	}
}
