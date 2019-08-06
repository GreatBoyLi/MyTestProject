package com.peng.wen.LinkedNode.leetcode;

public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            ListNode node = head;
            head = node.next;
            node.next = null;
        }
        if (head == null){
            return null;
        }
        ListNode prev = head;
        while(prev.next != null){
            if (prev.next.val == val){
                ListNode node = prev.next;
                prev.next = node.next;
                node.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}
