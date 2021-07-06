package algorithmProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengshuoa
 * @Description ${}
 * @Date 2021/7/6 14:04
 * @Version 1
 **/
public class TwoBetweenChange_24 {
    public static void mainTwoBetweenChange() {
        ListNode twoListNode = new ListNode(0);
        int j=0;
        while(j<=6){
            twoListNode.add(j);
            j++;
        }
        ListNode result = new TwoBetweenChange_24().merge(twoListNode);
        while (result != null){
            System.out.println("值为："+result.val);
            result = result.next;
        }
    }

    public ListNode merge(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = merge(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
