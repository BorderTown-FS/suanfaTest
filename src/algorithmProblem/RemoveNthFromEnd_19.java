package algorithmProblem;


/**
 * 19.删除链表的第N个节点
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd_19 {
    public static void mainRemoveNthFromEnd() {
        ListNode oneListNode=new ListNode(1);
        int i=2;
        while(i<=5){
            oneListNode.next = new ListNode(i);
            oneListNode = oneListNode.next;
            i++;
        }
        ListNode result = new RemoveNthFromEnd_19().removeNthFromEnd(oneListNode,3);
        while(result != null){
            System.out.println("结果为："+result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode oneListNode, int n) {
        ListNode dummy = new ListNode(0, oneListNode);
        int length = getLength(oneListNode);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
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