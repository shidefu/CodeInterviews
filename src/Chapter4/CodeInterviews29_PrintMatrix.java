package Chapter4;

/** 
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4x4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;

public class CodeInterviews29_PrintMatrix {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0)
			return result;
		int row = matrix.length, col = matrix[0].length;
		if (col == 0)
			return result;
		int layers = (Math.min(row, col) + 1) / 2;// 层数
		for (int i = 0; i < layers; i++) {
			for (int k = i; k < col - i; k++)
				result.add(matrix[i][k]);// 左至右
			for (int j = i + 1; j < row - i; j++)
				result.add(matrix[j][col - i - 1]);// 右上至右下
			for (int k = col - i - 2; k >= i && row - i - 1 != i; k--)
				result.add(matrix[row - i - 1][k]);// 右至左
			for (int j = row - i - 2; j > i && col - i - 1 != i; j--)
				result.add(matrix[j][i]);// 左下至左上
		}
		return result;
	}

}
