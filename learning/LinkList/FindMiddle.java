package learning.LinkList;


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;

    }
}
public class FindMiddle {

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);


        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.data);

    }
}
