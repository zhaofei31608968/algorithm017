package com.algorithm.practise;

import com.algorithm.practise.common.ListNode;

/**
 * 方法一：递归 时间复杂度：O(n+m)  空间复杂度：O(n + m)
 * 方法二：迭代 时间复杂度：O(n + m) 空间复杂度：O(1)
 */
public class TwoListMerge {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node111 = new ListNode(5);
        node1.setNext(node11);
        node11.setNext(node111);

        ListNode node2 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node222 = new ListNode(6);
        node2.setNext(node22);
        node22.setNext(node222);

        ListNode result = mergeSortedList2(node1,node2);
        while(result != null){
            System.out.println(result.getVal());
            result = result.getNext();
        }
    }

    public static ListNode mergeSortedList(ListNode sortedNode1,ListNode sortedNode2){
        if(sortedNode1 == null){
            return sortedNode2;
        }

        if(sortedNode2 == null){
            return sortedNode1;
        }

        if(sortedNode1.getVal() < sortedNode2.getVal()){
            sortedNode1.setNext(mergeSortedList(sortedNode1.getNext(),sortedNode2));
            return sortedNode1;
        }else {
            sortedNode2.setNext(mergeSortedList(sortedNode1,sortedNode2.getNext()));
            return sortedNode2;
        }
    }

    public static ListNode mergeSortedList2(ListNode sortedNode1,ListNode sortedNode2){
        ListNode preHeader = new ListNode(-1);
        ListNode pre = preHeader;
        while(sortedNode1 != null && sortedNode2 != null){
            if(sortedNode1.getVal() < sortedNode2.getVal()){
                pre.setNext(sortedNode1);
                sortedNode1 = sortedNode1.getNext();
            }else {
                pre.setNext(sortedNode2);
                sortedNode2 = sortedNode2.getNext();
            }
            pre = pre.getNext();
        }

        if(sortedNode1 == null){
            pre.setNext(sortedNode2);
        }

        if(sortedNode2 == null){
            pre.setNext(sortedNode2);
        }
        return preHeader.getNext();
    }
}
