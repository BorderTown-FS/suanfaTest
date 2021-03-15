package algorithmProblem;


/**
 * 21.合并两个有序链表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists_21 {
    public static void mainMergeTwoLists() {
        ListNode oneListNode=new ListNode(1);
        ListNode twoListNode=new ListNode(1);
        int i=2;
        while(i<=10){
            twoListNode.next = new ListNode(i);
            twoListNode = twoListNode.next;
            if(i<=5){
                oneListNode.next = new ListNode(i);
                oneListNode = oneListNode.next;
            }
            i++;
        }

        ListNode result = new MergeTwoLists_21().mergeTwoLists(oneListNode,twoListNode);
        while(result != null){
            System.out.println("结果为："+result.val);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}