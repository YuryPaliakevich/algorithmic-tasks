package org.example;

import org.example.model.ListNode;

public class LinkedListSum {

    public static void main(String[] args) {
        final ListNode l1 = new ListNode();
        int[] arr1 = { 9,9,9,9,9,9,9 };
        ListNode curr = l1;
        for (int i = 0; i < arr1.length; i++) {
            curr.val = arr1[i];
            if (i != arr1.length - 1) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        final ListNode l2 = new ListNode();
        curr = l2;
        int[] arr2 = { 9,9,9,9 };
        for (int i = 0; i < arr2.length; i++) {
            curr.val = arr2[i];
            if (i != arr2.length - 1) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            final ListNode result = new ListNode();
            int addValue = 0;
            ListNode current = result, prev = current;
            while (l1 != null || l2 != null) {
                int sum = 0;

                if (l1 != null) {
                    sum += l1.val;
                }
                if (l2 != null) {
                    sum += l2.val;
                }
                sum += addValue;

                prev = current;
                if (sum > 9) {
                    current.val = sum % 10;
                    current.next = new ListNode();
                    current = current.next;
                    addValue = 1;
                } else {
                    current.val += sum;
                    current.next = new ListNode();
                    current = current.next;
                    addValue = 0;
                }

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if (addValue > 0) {
                current.val += addValue;
            } else {
                prev.next = null;
            }

            return result;
        }
    }

}
