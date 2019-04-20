package Chapter3;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class CodeInterviews18_DeleteDuplication {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode head = new ListNode(-1);
		head.next = pHead;
		ListNode pCur = pHead;
		ListNode pPre = head;
		ListNode pNext = pCur.next;
		while (pCur != null && pNext != null) {
			if (pCur.val == pNext.val) {
				int val = pCur.val;
				while (pCur != null && pCur.val == val) {
					pCur = pCur.next;
					if (pCur != null) {
						pNext = pCur.next;
					} else {
						pNext = null;
					}
				}
				pPre.next = pCur;
			} else {
				pPre = pCur;
				pCur = pNext;
				pNext = pNext.next;
			}

		}
		return head.next;
	}

}
