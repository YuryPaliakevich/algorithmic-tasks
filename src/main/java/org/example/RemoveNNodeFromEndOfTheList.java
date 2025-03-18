package org.example;

import java.util.HashMap;
import java.util.Map;

import org.example.model.ListNode;

public class RemoveNNodeFromEndOfTheList {

    public static void main(String[] args) {
        final ListNode l1 = new ListNode();
        int[] arr1 = { 1,2,3,4,5,6,7,8 };
        ListNode curr = l1;
        for (int i = 0; i < arr1.length; i++) {
            curr.val = arr1[i];
            if (i != arr1.length - 1) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        ListNode listNode = new Solution().removeNthFromEnd(l1, 3);

        ListNode.print(listNode);
    }


    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode answer = head;
            ListNode current = head;
            final Map<Integer, ListNode> mapped = new HashMap<>();
            int totalCount = 0;

            while (current != null) {
                mapped.put(totalCount, current);
                totalCount++;
                current = current.next;
            }
            int indexToRemove = totalCount - n;
            if (totalCount == 1) {
                return null;
            }

            if (indexToRemove == 0) {
                answer = mapped.get(indexToRemove + 1);
            } else if (indexToRemove == totalCount - 1) {
                ListNode listNode = mapped.get(indexToRemove - 1);
                listNode.next = null;
            } else {
                ListNode prev = mapped.get(indexToRemove - 1);
                ListNode next = mapped.get(indexToRemove + 1);
                prev.next = next;
            }


            return answer;
        }
    }
}
