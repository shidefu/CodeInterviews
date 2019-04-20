package Chapter3;

/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class CodeInterviews23_LoopLinkedList {

	public static ListNode meet = null;

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (!hasLoop(pHead)) {
			return null;
		}
		ListNode p = pHead;
		ListNode q = meet;
		while (p != q) {
			p = p.next;
			q = q.next;
		}
		return p;
	}

//	public static ListNode EntryNodeOfLoop(ListNode pHead){
//        if(!hasLoop(pHead)) {
//            return null;
//        }
//        if(pHead == meet) {
//            return pHead;
//        }
//        while(pHead != meet) {         
//            ListNode pos = meet.next;
//            if(pos == meet) {
//                return pos;
//            }
//            while(pos != meet) {
//                if(pos == pHead) {
//                    return pos;
//                }
//                pos = pos.next;
//            }
//            pHead = pHead.next;
//        }
//        return null;
//    }      

	private static boolean hasLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null || pHead.next.next == null) {
			return false;
		}
		ListNode fast = pHead.next.next;
		ListNode slow = pHead.next;
		while (fast != slow) {
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else {
				return false;
			}
		}
		meet = fast;
		return true;
	}

}
