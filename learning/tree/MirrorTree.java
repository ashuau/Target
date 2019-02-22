package learning.tree;

public class MirrorTree {
    static class Node {
        int data;
        Node left,right;
        Node(int val)
        {
            data = val;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.left.left = new Node(9);
        tree.printInOrder(root);

        tree.mirrorTree(root);
        System.out.println("Mirror");
        tree.printInOrder(root);

    }

    private void printInOrder(Node root) {

        if (root != null)
        {
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }
    }

    private void mirrorTree(Node root) {

        if (root != null)
        {

            mirrorTree(root.left);
            mirrorTree(root.right);
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }


    }
}
