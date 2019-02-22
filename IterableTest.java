/**
 * Created by Lenovo on 6/12/2017.
 */
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;

 class MyIterable<T> implements Iterable<T> {

    private List<T> list;

    public MyIterable(T [] t) {

        list = Arrays.asList(t);
        Collections.reverse(list);
    }

    @Override
    public Iterator<T> iterator() {

        return list.iterator();
    }
}
public class IterableTest {

    public static void main(String [] args) {

        Integer [] ints = {1, 2, 3};

        MyIterable<Integer> myList = new MyIterable<>(ints);

        for (Integer i : myList) {

            System.out.println(i);
        }
    }
}
