package main.java.datastructure;

import main.java.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/***
 * 输入一个链表，从尾到头打印链表每个节点的值
 * 借助栈实现，或使用递归的方法
 */
public class StackInListNode {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();

        if (listNode == null)
            return list;

        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        //listNode.print();

        ArrayList<Integer> list = printListFromTailToHead(listNode);
        list.forEach(e-> System.out.println(e));
    }
}
