package learning.Collections;

/* We can use Java inbuilt Deque as a double
ended queue to store the cache keys, with
the descending time of reference from front
to back and a set container to check presence
of a key. But remove a key from the Deque using
remove() , it takes O(N) time. This can be
optimized by storing a reference (iterator) to
each key in a hash set. */
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
public class LRUCache {
    // store keys of cache
    static Deque<Integer> dq;
    // store references of key in cache
    static HashSet<Integer> set;
    //maximum capacity of cache
    static int csize;

    LRUCache(int n)
    {
        dq=new LinkedList<>();
        set =new HashSet<>();
        csize=n;
    }

    /* Refers key x with in the LRU cache */
    public void refer(int x)
    {
        if(!set.contains(x))
        {
            if(dq.size() == csize)
            {
                int last=dq.removeLast();
                set.remove(last);
            }
        }
        else
        {
            dq.remove(x);
        }
        dq.addFirst(x); // equivalent to push
        set.add(x);
    }

    // display contents of cache
    public void display()
    {
        for (Integer integer : dq) {
            System.out.print(integer + " ");
        }
    }


    public static void main(String[] args) {
        LRUCache ca=new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
