package learning.LinkList;

public class ReverseLinkList {

    private static class Node{
        int data;
         Node next;
    }


    public static void main(String [] args) {
        ReverseLinkList ob = new ReverseLinkList();
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;
        head.next.next.next = new Node();
        head.next.next.next.data = 4;
        head.next.next.next.next = null;
        ob.printReverseLinkList(head);
    }

    private void printReverseLinkList(Node head) {

        Node prev = null,current = head,next;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }

    }

}
