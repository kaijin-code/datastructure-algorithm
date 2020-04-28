package main.java.datastructure;

/***
 *  listnode链表
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x){
        val = x;
    }

    public void add(int newval){
        ListNode newnode = new ListNode(newval);

        if(this.next == null) {
            this.next = newnode;
        }
        else
            this.next.add(newval);
    }

    public void print(){
        System.out.print(this.val);

        if(this.next != null){
            {
                System.out.print("-->");
                this.next.print();
            }
        }
    }

    /*O(1)时间删除链表节点,将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点*/
    public void deleteNode(ListNode head, ListNode deListNode){

        if (deListNode == null || head == null)
            return;

        if (head == deListNode) {
            head = null;
        } else{
            // 若删除节点是末尾节点，往后移一个
            if(deListNode.next == null){
                ListNode pointListNode = head;
                while(pointListNode.next.next!=null){
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            }else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }

    }

    public ListNode FindKthToTail(ListNode head, int k){
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (k-- > 1){
             if(fast.next!=null)
                 fast = fast.next;
             else
                 return null;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
