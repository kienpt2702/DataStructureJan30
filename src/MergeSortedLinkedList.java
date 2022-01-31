public class MergeSortedLinkedList {
    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null) return list2;
            if(list2 == null) return list1;

            ListNode head = new ListNode();
            ListNode node = head;
            while(list1 != null || list2 != null){
                if(list1 == null){
                    node.next = list2;
                    break;
                }
                if(list2 == null){
                    node.next = list1;
                    break;
                }
                if(list1.val <= list2.val){
                    node.next = list1;
                    node = node.next;
                    list1 = list1.next;
                }
                else{
                    node.next = list2;
                    node = node.next;
                    list2 = list2.next;
                }
            }
            return head.next;
        }
    }
}
