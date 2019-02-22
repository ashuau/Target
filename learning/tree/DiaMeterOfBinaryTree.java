/*The diameter of a tree T is the largest of the following quantities:

        * the diameter of T’s left subtree
        * the diameter of T’s right subtree
        * the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

*/
package learning.tree;

/* Class to print the Diameter */
public class DiaMeterOfBinaryTree
{
    //Node root;

    // here in improved solution, we calculate the height and diameter for every
    // node in same iteration
    // every Node will return 2 values, diameter and height wrt to the
    // particular node
    public int[] Diameter(Node root) {
        int [] diameterAndHeight = { 0, 0 }; // initialize the height (diameterAndHeight[0]) and diameter
        // as 0 (diameterAndHeight[1])
        if (root != null) {

            int[] leftResult = Diameter(root.left);
            int[] rightResult = Diameter(root.right);

            int height = Math.max(leftResult[0], rightResult[0]) + 1;
            int leftDiameter = leftResult[1];
            int rightDiameter = rightResult[1];
            int rootDiameter = leftResult[0] + rightResult[0] + 1;
            int finalDiameter = getMax(leftDiameter, rightDiameter,
                    rootDiameter);
            // prepare the diameterAndHeight[]
            diameterAndHeight[0] = height; // update the height
            diameterAndHeight[1] = finalDiameter;
            return diameterAndHeight;
        }
        return diameterAndHeight;
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        DiaMeterOfBinaryTree tree = new DiaMeterOfBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(5);
        root.left.right.left.right = new Node(5);
      /*  root.right.right = new Node(3);
        root.right.right.right = new Node(3);
        root.right.right.right.left = new Node(3);
        root.right.right.right.left.right = new Node(3);

        root.right.right.right.right = new Node(3);*/



        System.out.println("The diameter of given binary tree is : "
                + tree.Diameter(root)[1]);
    }
}
