package main.java.datastructure;

import java.util.ArrayList;

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

    /*快指针走K步，然后慢指针开始走，快指针到尾时,慢指针就找到了倒数第K个节点*/
    public static ListNode FindKthToTail(ListNode head, int k){
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

    /*定义两个指针，反向输出*/
    public static ListNode ReverseList(ListNode head) {
        if(head == null){
             return null;
        }

        ListNode temp = null;
        while(head !=null){
            ListNode p = head.next;
            head.next = temp;
            temp = head;
            head = p;
        }
        return temp;
    }

    /*递归与非递归求解，小数放在前面*/
    public static ListNode Merge(ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead = null;
        if(list1.val <= list2.val) {
            newHead = list1;
            newHead.next = Merge(list1.next, list2);
        }else{
            newHead = list2;
            newHead.next = Merge(list2.next, list1);
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(4);
        listNode.add(7);
        ListNode listNode2 = new ListNode(2);
        listNode2.add(5);
        listNode2.add(6);

        listNode.print();
        System.out.println();
        listNode2.print();
        System.out.println();
       // ListNode resultNode = FindKthToTail(listNode, 3);
       //ListNode resultNode =  ReverseList(listNode);
       ListNode resultNode =  Merge(listNode, listNode2);
        resultNode.print();
       // list.forEach(e-> System.out.println(e));
    }

}
