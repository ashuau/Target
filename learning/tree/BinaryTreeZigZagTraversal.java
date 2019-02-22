package learning.tree;

import java.util.Stack;

public class BinaryTreeZigZagTraversal {

    static class Node{
        int data;
        Node left,right;
        Node(int val)
        {
            this.data = val;
            left = right = null;
        }

    }
 // Spiral order traversal
    public static void main(String[] args) {
        BinaryTreeZigZagTraversal tree = new BinaryTreeZigZagTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        tree.printZigZagTraversal(root);

    }

    private void printZigZagTraversal(Node root) {

        Stack s1 = new Stack();
        Stack s2 = new Stack();
        boolean lefttoright = false;
        s1.push(root);
        while (!s1.isEmpty())
        {
            Node temp = (Node) s1.pop();
            System.out.print(temp.data+"\t");
            if(lefttoright){
                if (temp.right != null){
                    s2.push(temp.right);
                }
                if (temp.left != null){
                    s2.push(temp.left);
                }
            }
            else{
                if (temp.left != null){
                    s2.push(temp.left);
                }
                if (temp.right != null){
                    s2.push(temp.right);
                }
            }
            if (s1.isEmpty())
            {
                lefttoright = true;
                Stack stemp = s1;
                s1 = s2;
                s2 = stemp;

            }
        }
    }
}
