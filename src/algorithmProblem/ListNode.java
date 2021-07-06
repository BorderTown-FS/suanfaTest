package algorithmProblem;

/**
 * @Author fengshuoa
 * @Description ${}
 * @Date 2021/7/6 10:58
 * @Version 1
 **/
public class ListNode {
     int val;
     ListNode next;
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     //添加结点
     public void add(int newdata){
          ListNode newNode = new ListNode(newdata);    //创建一个结点
          if(this.next == null){
               this.next = newNode;
          }
          else{
               this.next.add(newdata);
          }
     }

     //输出结点的值
     public void print(){
          System.out.println(this.val+"-->");
          if(this.next != null){
               this.next.print();
          }
     }

     //链表长度
     public int length(ListNode head) {
          ListNode curNode = head;
          int length = 0;
          while (curNode != null) {
               curNode = curNode.next;
               length ++;
          }
          return length;
     }
}
