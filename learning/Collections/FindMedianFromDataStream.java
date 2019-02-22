package learning.Collections;

import java.util.*;
public class FindMedianFromDataStream {

        PriorityQueue<Integer> maxHeap;//lower half
        PriorityQueue<Integer> minHeap;//higher half

        public FindMedianFromDataStream(){
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            minHeap = new PriorityQueue<Integer>();
        }

        // Adds a number into the data structure.
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(Objects.requireNonNull(maxHeap.poll()));

            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if(maxHeap.size()==minHeap.size()){
                return (double)(maxHeap.peek()+(minHeap.peek()))/2;
            }else{
                return maxHeap.peek();
            }
        }

    public static void main(String[] args) {
        FindMedianFromDataStream data = new FindMedianFromDataStream();
        data.addNum(5);
        data.addNum(2);
        data.addNum(3);
        data.addNum(4);
        data.addNum(7);
        data.addNum(6);

        System.out.println(data.findMedian());

    }
}

