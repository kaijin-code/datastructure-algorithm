package main.java.datastructure;

import java.util.Arrays;

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

    public static void main(String[] args) {
       int[] pre =  {4, 2, 1, 3, 6, 5, 7, 8, 10};
       int[] in =  {1, 2, 3, 4, 5, 6, 7, 8, 10};

        System.out.println(reConstructBinaryTree(pre, in));
    }
}
