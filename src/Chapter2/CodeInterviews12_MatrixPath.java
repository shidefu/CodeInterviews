package Chapter2;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3x4矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class CodeInterviews12_MatrixPath {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (match(matrix, i, j, rows, cols, flag, str, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断矩阵中是否存在与字符串匹配的路径
	 * 
	 * @param matrix 输入字符矩阵
	 * @param i      行索引
	 * @param j      列索引
	 * @param rows   矩阵行数
	 * @param cols   矩阵列数
	 * @param flag   标记某个字符是否已经被访问过
	 * @param str    待匹配的字符串
	 * @param k      字符串索引
	 * 
	 * @return 是否匹配
	 */
	public boolean match(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
		int index = i * cols + j;
		if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true) {
			return false;
		}
		if (k == str.length - 1) {
			return true;
		}
		flag[index] = true;
		if (match(matrix, i - 1, j, rows, cols, flag, str, k + 1)
				|| match(matrix, i + 1, j, rows, cols, flag, str, k + 1)
				|| match(matrix, i, j - 1, rows, cols, flag, str, k + 1)
				|| match(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
			return true;
		}
		flag[index] = false;
		return false;
	}
}
