package main.java.datastructure;

import java.util.Random;

public class BinaryTreeNode2 {

    private String val;

    private BinaryTreeNode2 leftChild;

    private BinaryTreeNode2 rightChild;

    public static BinaryTreeNode2 generateBinaryTreeNode(){
       return initBinaryTreeNode();
    }

    public BinaryTreeNode2(String val, BinaryTreeNode2 leftChild, BinaryTreeNode2 rightChild){
                this.val = val;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
    }



    private static BinaryTreeNode2 initBinaryTreeNode() {
        BinaryTreeNode2 node5 = new BinaryTreeNode2(getRandomAZ(), null, null);
        BinaryTreeNode2 node2 = new BinaryTreeNode2(getRandomAZ(), node5, null);
        BinaryTreeNode2 node4 = new BinaryTreeNode2(getRandomAZ(), null, null);
        BinaryTreeNode2 node3 = new BinaryTreeNode2(getRandomAZ(), null, null);
        BinaryTreeNode2 node1 = new BinaryTreeNode2(getRandomAZ(), node3, node4);
        BinaryTreeNode2 root = new BinaryTreeNode2(getRandomAZ(), node1, node2);
        return root;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public BinaryTreeNode2 getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode2 leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode2 getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode2 rightChild) {
        this.rightChild = rightChild;
    }

    private static String getRandomAZ(){
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] c = s.toCharArray();
        Random random = new Random();

        return c[random.nextInt(c.length)]+"";
    }
}
