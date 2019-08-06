package com.peng.wen.LinkedNode.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode newHead = null;
        ListNode cur = null;
        int count = 0;
        while(node != null){
            if (node.val != val){
                if (count == 0){
                    newHead = node;
                    cur = node;
                }else{
                    cur.next = node;
                    cur = node;
                }
                count ++;
            }
            node = node.next;
            if (node != null && node.next == null && node.val == val && cur!=null){
                cur.next = null;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
//        a.next = b;
//        b.next = e;
//        e.next = c;
//        c.next = d;
//        d.next = f;
        d.next=e;
        ListNode node = d;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        node = removeElements(d,4);
        System.out.println();
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}