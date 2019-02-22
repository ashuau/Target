package learning.LinkList;

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
        head =    reverse(head,k);

        System.out.println();

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

        if (next != null) {

            head.next = reverse(next,k);
        }

        return prev;
    }
}
