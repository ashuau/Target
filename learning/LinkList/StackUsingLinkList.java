package learning.LinkList;

public class StackUsingLinkList {

    static Node node = null;
   static Node stack = null;

    public static void main(String[] args) {


        node = new Node(10);
        push(node);
        node = new Node(20);
        push(node);

        System.out.println(pop());
        System.out.println(pop());

        System.out.println(pop());

       // node = new Node(30);
        push(node);
        System.out.println("peek::"+peek());

        while (stack != null) {
            System.out.println(stack.data);
            stack = stack.next;
        }

    }


   static void push(Node node) {

        if(stack == null) {
            stack = node;
        }
        else {
            node.next = stack;
            stack = node;
        }

    }

    static int pop() {

        if (stack != null) {

            int data =  stack.data;
            stack = stack.next;
            return data;
        }
        return -1;

    }

   static int peek() {

        return stack.data;

    }
}
