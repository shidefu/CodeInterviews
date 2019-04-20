package Chapter5;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 */

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

/**
 * 找出两个链表的长度m,n（m>=n），遍历长链表至（m-n）处的节点，则从该节点开始的子链表与短链表等长,可同时遍历；
 * 此方法不需要辅助空间，时间复杂度为O(m+n)。
 */

public class CodeInterviews52_FirstCommonNode {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int length1 = getLength(pHead1);
		int length2 = getLength(pHead2);
		if (length1 >= length2)
			return FirstCommonNode(pHead1, length1, pHead2, length2);
		else
			return FirstCommonNode(pHead2, length2, pHead1, length1);
	}

	public ListNode FirstCommonNode(ListNode pHead1, int m, ListNode pHead2, int n) {
		if (m < n)
			return null;
		int margin = m - n;
		while (margin > 0) {
			pHead1 = pHead1.next;
			margin--;
		}
		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}

	public int getLength(ListNode node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
}
