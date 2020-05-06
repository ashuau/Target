package learning.LinkList;

public class FindLoop {
    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node (20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next =  head.next.next.next;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ) {
               break;
            }

        }
        slow = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;

            if (slow == fast){
                System.out.println("loop ::"+slow.data);
                break;
            }
        }
    }
}
