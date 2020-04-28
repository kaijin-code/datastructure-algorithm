package main.java.datastructure;

import main.java.datastructure.ListNode;

import java.util.Stack;

/***
 *  使用两个栈实现queue add poll
 *  一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中
 */
public class StacksToQueue {

    final static Stack<ListNode> stack1 = new Stack<>();

    final static Stack<ListNode> stack2 = new Stack<>();

      public static ListNode add(ListNode node){
         return stack1.push(node);
      }

    public static ListNode poll(ListNode node) throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return  stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        ListNode node = new ListNode(1);
        node.add(3);node.add(5);node.add(7);
        add(node);
        poll(node);
    }

}
