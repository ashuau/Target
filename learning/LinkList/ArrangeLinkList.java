package learning.LinkList;


/**
 * It does like below
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 */
public class ArrangeLinkList {

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
       // head.next.next.next.next.next.next = new Node(70);

        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data+"=>");
            temp = temp.next;
        }
        rearrange(head);
        System.out.println();
        while (head != null)
        {
            System.out.print(head.data+"=>");
            head = head.next;
        }

    }

    static Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    static void rearrange(Node node) {

        // 1) Find the middle point using tortoise and hare method
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverselist(node2);

        // 4) Merge alternate nodes
        node = new Node(0); // Assign dummy Node

        // curr is the pointer to this dummy Node, which will
        // be used to form the new list
        Node curr = node;
        while (node1 != null || node2 != null) {

            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Assign the head of the new list to head pointer
        node = node.next;
    }

}
