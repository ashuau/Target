package learning.LinkList;

/**
 *  rotate the link list in anti clock wise
 *  e.g  10->20->30->40->50->60 and k is 4,
 *  output 50->60->10->20->30->40
 */
public class RotateLinkListByKNode {

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);

        int k = 7;
        Node tmp = head;
        while (tmp != null) {

            System.out.print(tmp.data+"=>");
            tmp = tmp.next;
        }

        head = rotateByKNodes(head, k);
        System.out.println();
        while (head != null) {

            System.out.print(head.data+"=>");
            head = head.next;
        }

    }

  private   static Node rotateByKNodes(Node head, int k) {

        if (k == 0) {
            return head;
        }

        Node newHead;

        Node current = head;
        int count = 1;

        while ( count < k ) {

            count++;

            current = current.next;
            if (current == null)  // k is greater than no of nodes
                return head;
        }

        Node kthNode = current;

      while (current.next != null) {

          current = current.next;

      }
      current.next = head;
      newHead = kthNode.next;

        kthNode.next = null;
        return newHead == null ? head : newHead;
    }
}
