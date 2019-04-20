package Chapter1;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */

import java.util.Scanner;

public class CodeInterviews05_ReplaceSpace {

	public String replaceSpace(StringBuffer str) {
		// 计算空格数
		int numOfSpace = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				numOfSpace++;
		}
		// 替换前的str下标
		int indexOfOld = str.length() - 1;
		// 计算空格转换成%20之后的str长度
		int newLength = str.length() + numOfSpace * 2;
		// 替换后的str下标
		int indexOfNew = newLength - 1;
		// 使str的长度扩大到转换成%20之后的长度,防止下标越界
		str.setLength(newLength);
		for (; indexOfOld >= 0 && indexOfOld < newLength; indexOfOld--) {
			if (str.charAt(indexOfOld) == ' ') { //
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			} else {
				str.setCharAt(indexOfNew--, str.charAt(indexOfOld));
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		CodeInterviews05_ReplaceSpace ins = new CodeInterviews05_ReplaceSpace();
		Scanner sc = new Scanner(System.in);
		StringBuffer str = new StringBuffer(sc.nextLine());
		sc.close();
		System.out.println(ins.replaceSpace(str));
	}
}
