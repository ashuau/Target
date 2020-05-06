package learning.LinkList;

/**
 *  input :: 10=>20=>30=>40=>50 and K = 3
 * Output :: 30=>20=>10=>50=>40
 */
public class ReverseInGroupOFK {

    public static void main(String[] args) {
        Node head = new Node(10);

        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
       /* head.next.next.next.next.next = new Node(60);
       head.next.next.next.next.next.next = new Node(70);*/

        int k = 3;

        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data+"=>");
            temp = temp.next;
        }
        // reversing in a group of K
        head =    reverse(head,k);

        System.out.println();
    // Printing the reversed list
     while (head != null) {
         System.out.print(head.data+"=>");
         head = head.next;
     }

    }

    private static Node reverse(Node head, int k) {

        Node prev = null, next = null;

        Node current = head;

        int count = 0;

        while (current != null && count < k) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        // reversing for next group of K
        if (next != null) {

            head.next = reverse(next,k);
        }

        return prev;
    }
}
