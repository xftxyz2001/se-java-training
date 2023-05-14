/**
 * Test160
 */
public class Test160 {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }

            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 != null) {
                l1 = headB;
            } else if (l1 != null && l2 == null) {
                l2 = headA;
            }
        }
        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1;
    }

    // 官方：
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = l1;
        new Test160().getIntersectionNode(l1, l2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}