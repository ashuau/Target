package learning.tree;

/**
 * using parent pointer
 */
public class LCAInBinaryTree {

    static class Node{
        int data;
        Node left,right,parent;
        Node(int val)
        {
            this.data = val;
            left = right = parent =null;
        }
    }
   Node root;
    public static void main(String[] args) {
        LCAInBinaryTree tree = new LCAInBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        /*Node root = new Node(1);
        root.parent = null;
        root.left = new Node(2);
        root.left.parent = root;
        root.right = new Node(3);
        root.right.parent = root;
        root.left.left = new Node(4);
        root.left.left.parent = root.left;
        root.left.right = new Node(5);
        root.left.right.parent = root.left;
        root.right.left = new Node(6);
        root.right.left.parent = root.right;
        root.right.right = new Node(7);
        root.right.right.parent = root.right;*/

        Node lcaNode = tree.findLCA(tree.root,4,5);
        if (lcaNode == null) {
            System.out.print("Keys are not present");
        } else {
            System.out.println(lcaNode.data);
        }

         lcaNode = tree.findLCA(tree.root,4,10);
        if (lcaNode == null) {
            System.out.print("Keys are not present");
        } else {
            System.out.println(lcaNode.data);
        }
    }

    /**
     * To find without recursion
     * @param root
     * @param first
     * @param second
     * @return
     */
   /* private  Node findLCA(Node root, int first, int second)
    {
        if (root.data == first || root.data == second)
        {
            return root;
        }
        int d1 = findDistanceFromRoot(root,first);
        int d2 = findDistanceFromRoot(root,second);
        int diff = Math.abs(d2 - d1);

        int count = 0;
        if (d1 > d2)
        {
            Node temp = getNode(root,first);
            Node temp1 = getNode(root,second);
            while (count < diff)
            {
                temp = temp.parent;
                count++;
            }
            if (temp == temp1)
            {
                return temp;
            }
            while (temp.parent != temp1.parent)
            {
                temp = temp.parent;
                temp1 = temp1.parent;
            }
            return temp.parent;

        }
        else
        {
            Node temp = getNode(root,first);
            Node temp1 = getNode(root,second);
            while (count < diff)
            {
                temp1 = temp1.parent;
                count++;
            }
            if (temp == temp1)
            {
                return temp;
            }
            while (temp.parent != temp1.parent)
            {
                temp = temp.parent;
                temp1 = temp1.parent;
            }
            return temp.parent;

        }
    }
    private Node getNode(Node node, int val)
    {
        if (node == null)
        {
            return  null;
        }
        if (node.data == val)
        {
            return node;
        }
       Node rnode =  getNode(node.left,val);
        if (rnode != null)
        {
            return rnode;
        }
       rnode = getNode(node.right,val);
        if (rnode != null)
        {
            return rnode;
        }
        return null;
    }

    private int findDistanceFromRoot(Node root, int val)
    {
       if (root == null)
        {
            return -1 ;
        }
        if (root.data == val)
        {
            return 0;
        }

        int left = findDistanceFromRoot(root.left,val);
        int right = findDistanceFromRoot(root.right,val);
       if (left == -1 && right == -1)
        return -1;
       return 1 + Math.max(left,right);
        //return 1 + Math.max(findDistanceFromRoot(root.left,val) , findDistanceFromRoot(root.right,val));
    }
*/
/**
 *  using recursion
 */
   static boolean v1 = false, v2 = false;
    private Node findLCA(Node root, int first, int second) {

            v1 = false; v2 = false;
        Node lcaNode = findLCAUtil(root, first, second);
        if (v1 && v2 /*|| (v1 && find(lcaNode,second)) || (v2 && find(lcaNode,first))*/)
        {
            return lcaNode;
        }
        return null;
    }

    private boolean find(Node lcaNode, int val) {
        if (lcaNode == null)
        {
            return false;
        }
        if (lcaNode.data == val)
        {
            return true;
        }
        boolean found;
        if (find(lcaNode.left, val)) found = true;
        else found = false;
        found = find(lcaNode.right,val);
        return found;
    }

    private Node findLCAUtil(Node root,int first, int second){

        if (root == null)
        {
            return null;
        }
        if (root.data == first)
        {
            v1 = true;
            return root;
        }
        if (root.data == second)
        {
            v2 = true;
            return root;
        }

        Node left = findLCAUtil(root.left,first,second);
        Node right = findLCAUtil(root.right,first,second);
        if (left != null && right != null)
        {
            return root;
        }
        return left != null ? left : right;


    }
}
