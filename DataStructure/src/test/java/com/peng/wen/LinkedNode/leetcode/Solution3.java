package com.peng.wen.LinkedNode.leetcode;

/**
 * 递归方法
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
       if (head == null){
           return null;
       }
       ListNode result = removeElements(head.next, val);
       if (head.val == val){
           return result;
       }else{
           head.next = result;
           return head;
       }
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements1(head.next, val);
//        if (head.val == val){
//            return head.next;
//        }else{
//            return head;
//        }
        return head.val == val ? head.next : head;
    }
}
