package Chapter5;

/**
 * 第一个只出现一次的字符
 * 1.字符串中第一个只出现一次的字符：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符，
 * 并返回它的位置，如果没有则返回-1（需要区分大小写）。
 * 2.字符流中第一个只出现一次的字符：
 * 请实现一个函数，用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CodeInterviews50_FirstNotRepeatingChar {

	public int FirstNotRepeatingChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		if (str == null)
			return -1;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(str.charAt(i))) {
				int value = map.get(str.charAt(i));
				map.put(str.charAt(i), value + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for (int i = 0; i < len; i++) {
			if (map.get(str.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static ArrayList<Character> list = new ArrayList<>();
	public static HashMap<Character, Integer> map = new HashMap<>();

	// Insert one char from stringstream
	public static void Insert(char ch) {
		list.add(ch);
		if (map.containsKey(ch)) {
			int value = map.get(ch);
			map.put(ch, value + 1);
		} else {
			map.put(ch, 1);
		}
	}

	// return the first appearence once char in current stringstream
	public static char FirstAppearingOnce() {
		for (Character character : list) {
			if (map.get(character) == 1)
				return character;
		}
		return '#';
	}

	// test the first appearence once char in current stringstream
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			char ch = in.nextLine().charAt(0);
			Insert(ch);
			System.out.println(FirstAppearingOnce());
		}
		in.close();
	}

}
