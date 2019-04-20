package Chapter3;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class CodeInterviews22_KthToTail {

	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode pNode = head;
		ListNode qNode = head;
		int i = 0;

		while (pNode != null) {
			if (i >= k) {
				qNode = qNode.next;
			}
			pNode = pNode.next;
			i++;
		}

		if (i < k)
			return null;
		else
			return qNode;
	}
}
