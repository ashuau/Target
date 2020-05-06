package learning.LinkList;

public class FindKthNodeFromEnd {

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);

        int k = 7;
        int count = 0;
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (fast != null && count >=  k) {
                    slow = slow.next;
            }
        }
        System.out.println(slow.data);
    }
}
