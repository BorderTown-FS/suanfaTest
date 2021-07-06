package algorithmProblem;

/**
 * LeetCode第二题
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。如果，我们将这两个数相加起来，则会返回一个新
 * 的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class ListNodeAddTwoNumbers_2{
    public static void mainListNodeAddTwoNumbers() {
        System.out.println("进入子方法开始");
        ListNode oneListNode=new ListNode(1);
        int i=1;
        while(i<=3){
            oneListNode.next = new ListNode(i);
            oneListNode = oneListNode.next;
            i++;
            System.out.println("进入第一循环");
        }
        ListNode twoListNode=new ListNode(1);
        int j=3;
        while(j>=1){
            twoListNode.next = new ListNode(j);
            twoListNode = twoListNode.next;
            j--;
            System.out.println("进入第二循环");
        }
        ListNode sumListNode=addTwoNumbers(oneListNode,twoListNode);
        while (sumListNode != null){
            System.out.print("数字为："+sumListNode.val+ " 原式1为："+oneListNode.val+" 原式2为："+twoListNode.val);
            if (sumListNode != null) sumListNode=sumListNode.next;
            if (oneListNode != null) oneListNode=oneListNode.next;
            if (twoListNode != null) twoListNode=twoListNode.next;
        }
    }

    /**
     * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
     * 并且它们的每个节点只能存储一位数字。如果，我们将这两个数相加起来，则会返回一个新
     * 的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1 给定的随机链表
     * @param l2 给定的随机链表
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //相加的新链表
        ListNode initListNode = new ListNode(0);
        ListNode oldOne=l1,oldTwo=l2,newSum=initListNode;
        int carryFlag = 0;
        while (oldOne != null && oldTwo != null ) {
            int one=  oldOne.val ;
            int two=  oldTwo.val ;
            //两数相加的和
            int sum = carryFlag + one + two ;
            //carryFlag表示要向前进位的数值
            carryFlag = sum / 10 ;
            //余数代表相加进位后的值
            newSum.next = new ListNode(sum % 10);
            newSum =newSum.next;

            //next表示指向该节点的下一个节点
            oldOne = oldOne.next;
            oldTwo = oldTwo.next;
        }
        //最后数位运算完如果这个值还是大于0，说明产生新的进位，如34+78=112. 其中1就是新进位
        if (carryFlag > 0) {
            newSum.next = new ListNode(carryFlag);
        }
        return initListNode.next;
    }
}
