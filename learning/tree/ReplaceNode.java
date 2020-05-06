package learning.tree;

/**
 * Replace the node with sum of inorder successor + inorder predecessor
 */


public class ReplaceNode {

    /*
    Input :          1
               /   \
              2     3
            /  \  /  \
           4   5  6   7


       inorder 4,2,5,1,6,3,7

       inorder[0] + inorder[2]

       resultant inorder = 2,9,3,11,4,13,3



       preorder 1,2,4,5,3,6,7
       postorder 4,5,2,6,7,3,1




Output :        11
              /    \
             9      13
            / \    /  \
           2   3   4   3



           Node {
            int val;
            Node left,right;
           }

           class counter {

           }


           public void modifyBT(Node node,List data, int x) {

            // implementation here

            if (node == null)
            return;
            modifyBT(node.left,data,x);

            node.val = data.get(x - 1 ) + data.get(x + 1);

            x = x + 1;
            modifyBT(node.right,data,x)
           }

           public void replaceNodeWithsum(Node node) {

           if (node == null)
           return;

           List data = new ArrayList();

           data.add(0); // leftmost

           getInorderTraversal(node,data);
           data.add(0);

           modifyBT(node,data,1);

           }

           public getInorderTraversal(Node node,List data) {

               getInorderTraversal(node.left,data);

               data.add(node.val);
               getInorderTraversal(node.right,data);

           }



           time complexity
           space complexity





     */
}
