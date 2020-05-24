package com.danny.algo.learn;

import com.danny.algo.learn.S21.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }

        if (p.val < q.val) {
            p.next = mergeTwoLists(p.next, q);
            return p;
        } else {
            q.next = mergeTwoLists(p, q.next);
            return q;
        }
    }

    public static final class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
        }
    }
}