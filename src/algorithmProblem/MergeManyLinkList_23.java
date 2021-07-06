package algorithmProblem;

/**
 * @Author fengshuoa
 * @Description ${}
 * @Date 2021/7/5 17:33
 * @Version 1
 **/
public class MergeManyLinkList_23 {
    public static void mainMergeManyLinkList() {
        ListNode oneListNode = new ListNode(0);
        int i = 0;
        while(i<3){
            oneListNode.add(i);
            i++;
        }
        ListNode twoListNode = new ListNode(0);
        int j=3;
        while(j<=6){
            twoListNode.add(j);
            j++;
        }
        ListNode[] list = new ListNode[]{oneListNode,twoListNode};
        ListNode result = new MergeManyLinkList_23().mergeKLists(list);
        while (result != null){
            System.out.println("值为："+result.val);
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        //生成一个空的头部节点以便传递
        ListNode head = new ListNode(0);
        //赋值
        ListNode tail = head, aPtr = a, bPtr = b;
        //比较交换
        while (aPtr != null && bPtr != null){
            if(aPtr.val < bPtr.val){
                //如果a链表当前节点的值小于b链表当前节点的值，则
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                //反之，则
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            //获取tail下一个节点
            tail = tail.next;
        }
        //最后如果a或者B链表还剩余，则取剩余的所有接到返回链表的最后面
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
