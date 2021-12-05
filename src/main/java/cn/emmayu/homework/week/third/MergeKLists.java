package cn.emmayu.homework.week.third;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return  rec(0, lists.length - 1, lists);
    }

    public ListNode rec(int i, int length, ListNode[] lists) {
        if (i == length) {
            return lists[i];
        }
        if (i > length) {
            return null;
        }
        int mid = (i + length) / 2;
        return mergeTwoLists(rec(i, mid, lists), rec(mid + 1, length, lists));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode tmp = head;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
