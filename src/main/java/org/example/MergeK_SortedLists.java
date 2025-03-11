package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.example.model.ListNode;

public class MergeK_SortedLists {

    public static void main(String[] args) {
        final ListNode l1 = new ListNode();
        int[] arr1 = {0};
        ListNode curr = l1;
        for (int j : arr1) {
            curr.val = j;
            curr.next = new ListNode();
            curr = curr.next;
        }

        final ListNode l2 = new ListNode();
        curr = l2;
        int[] arr2 = {-1};
        for (int j : arr2) {
            curr.val = j;
            curr.next = new ListNode();
            curr = curr.next;
        }

        final ListNode[] arr = {l1, l2};
        ListNode listNode = new Solution().mergeKLists(arr);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


    private static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            final Comparator<Value> comparator = Comparator.comparingInt(val -> val.value);
            final PriorityQueue<Value> queue = new PriorityQueue<>(comparator);

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.add(new Value(i, lists[i].val));
                }
            }

            if (queue.isEmpty()) {
                return null;
            }

            ListNode result = new ListNode();
            ListNode currentNode = result;
            ListNode prevNode = null;

            while (!queue.isEmpty()) {

                Value peek = queue.poll();
                currentNode.val = peek.value;
                currentNode.next = new ListNode();
                prevNode = currentNode;
                currentNode = currentNode.next;

                lists[peek.index] = lists[peek.index].next;

                if (lists[peek.index] != null) {
                    queue.add(new Value(peek.index, lists[peek.index].val));
                }
            }

            prevNode.next = null;

            return result;
        }
    }

    public static class Value {
        int index;
        int value;

        public Value(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}



















