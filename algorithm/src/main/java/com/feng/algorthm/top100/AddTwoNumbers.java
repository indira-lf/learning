package com.feng.algorthm.top100;

/**
 * @author
 * @time 2022/10/29 22:28
 * @Description- 2、两数相加
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int temp = 0;
        ListNode currNode = new ListNode(0);
        ListNode preNode = currNode;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0:l1.val;
            int y = l2 == null ? 0:l2.val;
            currNode.next = new ListNode((x+y+temp) % 10);
            temp = (x+y+temp) / 10;
            currNode = currNode.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            if (temp == 1){
                currNode.next = new ListNode(1);
            }
        }
        return preNode.next;
    }
}
