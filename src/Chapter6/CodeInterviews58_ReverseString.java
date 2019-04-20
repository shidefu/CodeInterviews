package Chapter6;

/**
 * 翻转字符串
 * 1.翻转单词顺序：
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串“I am a student."，则输出“student. a am I".
 * 2.左旋转字符串：
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现左旋转操作的功能。
 * 例如输出字符串“abcdefg"和数字2，返回左旋转两位得到的结果“cdefgab”.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CodeInterviews58_ReverseString {

	/**
	 * 翻转单词顺序
	 * 
	 * @param str 输入字符串
	 * @return 旋转后的字符串
	 */
	public String ReverseSentence(String str) {
		if (str == null)
			return null;
		if (str.trim().equals(""))
			return str;

		String[] strArr = str.split(" ");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArr));
		Collections.reverse(list);

		String[] arr = new String[strArr.length];
		list.toArray(arr);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length - 1; i++) {
			sb.append(arr[i] + " ");
		}
		sb.append(arr[arr.length - 1]);

		return sb.toString();
	}

	/**
	 * 左旋转字符串
	 * 
	 * @param str 输入字符串
	 * @param n   左旋转位数
	 * @return 左旋转后的字符串
	 */
	public String LeftRotateString(String str, int n) {
		if (str.length() <= n)
			return str;
		return str.substring(n, str.length()) + str.substring(0, n);
	}

	public static void main(String[] args) {
		CodeInterviews58_ReverseString ins = new CodeInterviews58_ReverseString();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		sc.close();
		System.out.println("Reverse Sentence: " + ins.ReverseSentence(str));
		System.out.println("Left Rotate String with " + n + ":" + ins.LeftRotateString(str, n));
	}
}
