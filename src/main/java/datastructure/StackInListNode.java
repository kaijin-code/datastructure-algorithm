package main.java.datastructure;

import main.java.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/***
 * 输入一个链表，从尾到头打印链表每个节点的值
 * 借助栈实现，或使用递归的方法
 */
public class StackInListNode {

    /*输入一个链表，从尾到头打印链表每个节点的值*/
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

    /*定义两个栈，一个存放入的值。另一个存最小值*/
    public static void push(Stack<Integer> stack, Stack<Integer> stack2, int node){
        stack.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else{
            if(stack2.peek() > node){
                stack2.push(node);
            }
        }
    }

    public static int min(Stack<Integer> stack2) {
        return stack2.peek();
    }

    /*用栈来压入弹出元素，相等则出栈*/
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int pushlen = pushA.length;
        for(int i = 0; i < pushlen; i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return  stack.isEmpty();
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        push(stack, stack2, 1);
        push(stack, stack2, 4);
        push(stack, stack2, 2);


        int min =  min(stack2);
        System.out.println(min);

        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};

        System.out.println(IsPopOrder(a, b));

        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        //listNode.print();

        ArrayList<Integer> list = printListFromTailToHead(listNode);
        //list.forEach(e-> System.out.println(e));
    }
}
