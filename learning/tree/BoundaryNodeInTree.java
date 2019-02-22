package learning.tree;

public class BoundaryNodeInTree {
    static class Node{
        int data;
        Node left,right;
        Node (int val)
        {
            this.data = val;
            this.left = this.right = null;
        }

    }

    public static void main(String[] args) {
        BoundaryNodeInTree tree = new BoundaryNodeInTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(9);

        tree.printBoundaryNodes(root);

    }

    private void printBoundaryNodes(Node root) {
        if (root != null)
        {
            System.out.println(root.data + "\t");
            printLeftBoundaryNodes(root.left);
            printLeftLeafNodes(root.left);
            printRightLeafNodes(root.right);
            printRightBoundaryNodes(root.right);
                    
        }
    }

    private void printRightBoundaryNodes(Node right) {

        if (right != null)
        {
            if (right.right != null)
            {
                printRightBoundaryNodes(right.right);
                System.out.println(right.data + "\t");
            }
           else if (right.left != null)
            {
                printRightBoundaryNodes(right.left);
                System.out.println(right.data + "\t");
            }
        }
    }

    private void printRightLeafNodes(Node right) {

        if (right != null)
        {
            printRightLeafNodes(right.left);
            if (right.left == null && right.right == null)
            {
                System.out.println(right.data + "\t");
            }
            printRightLeafNodes(right.right);
        }
    }

    private void printLeftLeafNodes(Node left) {

        if (left != null)
        {
            printLeftLeafNodes(left.left);
            if (left.left == null && left.right == null)
            {
                System.out.println(left.data + "\t");
            }
            printRightLeafNodes(left.right);

        }
    }

    private void printLeftBoundaryNodes(Node left)
    {
        if (left != null)
        {
            if (left.left != null)
            {
                System.out.println(left.data + "\t");
                printLeftBoundaryNodes(left.left);
            }
            else if (left.right != null)
            {
                System.out.println(left.data + "\t");
                printLeftBoundaryNodes(left.right);
            }
        }
    }
}
