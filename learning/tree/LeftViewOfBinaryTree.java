package learning.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    static class Node {
        Node left,right;
        int data;
        Node (int  val)
        {
            this.data = val;
            left = right = null;
        }
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(10);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(9);

        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.printLeftView(root);
        System.out.println();
        // Method 2 for left view
        tree.method2(root);
        System.out.println();
        // Method 3 for left view
        tree.method3(root,1);

    }
    static int currentLevel = 0;
    private void method3(Node root, int nextLevel) {

        if (root == null){
            return;
        }
        if (currentLevel < nextLevel)
        {
            System.out.print(root.data+"\t");
            currentLevel = nextLevel;
        }
        method3(root.left,nextLevel+1);
        method3(root.right,nextLevel+1);
    }

    static int level;
    private void method2(Node root){
        int height = getHeight(root);
        for (int i =1; i <= height; i++){
            level = 1;
            printmethod2(root,i);
        }

    }

    private void printmethod2(Node root, int h) {

        if (root == null)
        {
            return;
        }
        if (level == 1 && h == 1){
            System.out.print(root.data+"\t");
            level++;
        }
        else
        {
            printmethod2(root.left, h-1);
            printmethod2(root.right,h-1);
        }
    }

    private void printLeftView(Node root){


        Queue <Node> q = new LinkedList<>();
        q.add(root);
        boolean check;
        while(!q.isEmpty())
        {
           // Node node = (Node) q.peek();
            check = true;
            int count = q.size();
            while (count-- > 0 )
            {
                if (check)
                {
                    System.out.print(root.data + " ");
                    check = false;
                }
                if (root.left != null)
                {
                    q.add(root.left);
                }
                if (root.right != null)
                {
                    q.add(root.right);
                }
                q.poll();
                root = q.peek();
            }
        }


    }


    int getHeight(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(getHeight(root.left),getHeight(root.right));
        }
    }
}
