package learning.LinkList;

public class MergeTwoSortedLinkList {

    public static void main(String[] args) {

        Node head1 = new Node(10);

        head1.next = new Node (20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);

        Node head2 = new Node(10);

        head2.next = new Node (13);
        head2.next.next = new Node(17);
        head2.next.next.next = new Node(25);
      //  head2.next.next.next.next = new Node(50);

        Node result;

        Node temp;


        if (head1.data <= head2.data) {

            temp = head1;

            head1 = head1.next;

        }
        else {
            temp = head2;
            head2 = head2.next;
        }

        result = temp;

        while (head1 != null && head2 != null) {

            if (head1.data <=  head2.data) {

                temp.next = head1;
                temp = head1;

                head1 = head1.next;
            }
            else  {
                temp.next = head2;

                temp = head2;

                head2 = head2.next;
            }

        }

        if (head1 == null){
            temp.next = head2;
        }
        else{
            temp.next = head1;
        }

        while (result != null) {

            System.out.print(result.data+"=>");
            result = result.next;
        }
    }
}
