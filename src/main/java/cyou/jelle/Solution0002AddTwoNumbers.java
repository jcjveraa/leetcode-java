package cyou.jelle;

import cyou.jelle.leetcodehelpers.ListNode;

public class Solution0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode firstResultNode = new ListNode();
        ListNode currentNode = firstResultNode;
        int carryOver = 0;

        while (l1 != null) {

            currentNode.val += l1.val;
            currentNode.val += l2.val;

            if (currentNode.val >= 10) {
                carryOver = 1;
                currentNode.val = currentNode.val - 10;
            } else {
                carryOver = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

            if (l1 != null || l2 != null) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
                currentNode.val += carryOver;

                if (l1 == null) {
                    l1 = new ListNode();
                }
                if (l2 == null) {
                    l2 = new ListNode();
                }
            }
        }

        if (carryOver == 1) {
            currentNode.next = new ListNode(1);
        }

        return firstResultNode;
    }
}


