package Chapter4;

/** 
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;

public class CodeInterviews30_MinStack {

	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Integer tmp = null;

	public void push(int node) {
		if (tmp != null) {
			if (node <= tmp) {
				tmp = node;
				min.push(node);
			}
			data.push(node);
		} else {
			tmp = node;
			data.push(node);
			min.push(node);
		}
	}

	public void pop() {
		int num = data.pop();
		int num2 = min.pop();
		if (num != num2) {
			min.push(num2);
		}
	}

	public int top() {
		int num = data.pop();
		data.push(num);
		return num;
	}

	public int min() {
		int num = min.pop();
		min.push(num);
		return num;
	}

}
