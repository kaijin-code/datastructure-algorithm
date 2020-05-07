package main.java.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/***
 *   知道前序和中序 重构二叉树
 *  先找出根节点，然后利用递归方法构造二叉树
 *  二叉树 BinaryTreeNode
 */
public class BinaryTreeNode {

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int x) {
        val = x;
    }

    public static BinaryTreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if(pre == null || in == null){
            return null;
        }

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        if (pre.length != in.length) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(pre[0]);
        int len = pre.length;
        for(int i = 0; i < len; i++){

             if(pre[0] == in[i]){   //中序的根节点
                 root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                 root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
             }
        }
        return root;
    }

    /*输入两棵二叉树A，B，判断B是不是A的子结构*/
    public static boolean HasSubtree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;

        if (root2 != null && root1 != null) {

            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1,root2);
            }

            if (!result)
                return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(BinaryTreeNode node1, BinaryTreeNode node2){
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return doesTree1HaveTree2(node1.left,node2.left) &&
                doesTree1HaveTree2(node1.right,node2.right);
    }

    /*层序（深度优先）遍历二叉树*/
    public static ArrayList<Integer> printFromTopToBottom(BinaryTreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode  node = queue.poll();
            list.add(node.val);

            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return list;
    }

    /*前序*/
    public static void preOrderTraveral(BinaryTreeNode node){

        if(node != null){
            System.out.print(node.val+ "\t");

            preOrderTraveral(node.left);
            preOrderTraveral(node.right);
        }
    }

    /*中序*/
    public static void inOrderTraveral(BinaryTreeNode node){

        if(node != null){
            inOrderTraveral(node.left);

            System.out.print(node.val+ "\t");
            inOrderTraveral(node.right);
        }
    }

    /*后序*/
    public static void postOrderTraveral(BinaryTreeNode node){

        if(node != null){
            postOrderTraveral(node.left);

            postOrderTraveral(node.right);

            System.out.print(node.val+ "\t");
        }
    }

    public static void main(String[] args) {
       int[] pre =  {10, 6, 4, 8, 14, 12, 16};
       int[] in =  {4, 6, 8, 10, 12, 14, 16};
        BinaryTreeNode node = reConstructBinaryTree(pre, in);
        System.out.println(reConstructBinaryTree(pre, in));

        ArrayList list = printFromTopToBottom(node); //10 6 14 4 8 12 16
        //list.forEach(r -> System.out.print(r+"->"));

        preOrderTraveral(node);

        System.out.println();
       // inOrderTraveral(node);
        postOrderTraveral(node);
    }
}
