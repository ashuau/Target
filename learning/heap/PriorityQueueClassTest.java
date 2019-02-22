package learning.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueClassTest {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeStreams(
                new int[][] { { 2, 4, 5, 6, 7, 8,9 },
                        { 32,64,96},
                        { 10, 11, 13, 14 } })));


        PriorityQueue pq = new PriorityQueue();
        pq.add(1);pq.add(4);pq.add(2);pq.add(3);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
    }

    private static int[] mergeStreams(int[][] is) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is[i].length; j++)
                pq.add(is[i][j]);
        }

        int[] result = new int[pq.size()];
        int counter = 0;
        Iterator<Integer> i = pq.iterator();
        while (i.hasNext()) {
            result[counter++] = pq.remove();
        }
        return result;
    }

}