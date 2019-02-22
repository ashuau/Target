package learning.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    int size;
    int [] heap;

    public KthLargestElement(int[] arr) {
        this.size = arr.length;
        this.heap = Arrays.copyOf(arr, size);
    }

    // using Direct java API
/*int getKthLargest(int arr[], int k){
    PriorityQueue pq = new PriorityQueue(k);
    for (int i : arr) {
        pq.offer(i);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    return (int) pq.peek();

}*/

    public static void main(String[] args) {
        int arr [] = {10,5,12,50,36,9,32};
        KthLargestElement heap = new KthLargestElement(arr);
        heap.printHeap();
        heap.buildMaxHeap();
        heap.printHeap();
        System.out.println(heap.extractMax(1));
        heap.printHeap();

       // System.out.println(obj.getKthLargest(arr,3));
       // System.out.println(0>>1);
    }
    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    public void maxHeapify(int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && heap[largest] < heap[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < size && heap[largest] < heap[rightIndex]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }
    private void swap(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }
    public int extractMax(int k) {
        if (size == 0) return -1;
        int min = 0;
        for (int i = 0; i < k; i++)
        {
            min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            maxHeapify(0);

        }
        return min;
    }

    private void printHeap() {
        if (heap == null)
            System.out.print("null");
        int iMax = size - 1, i;
        if (iMax == -1)
            System.out.print("[]");

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (i = 0; i < iMax; i++) {
            b.append(heap[i]);
            b.append(", ");
        }
        System.out.println(b.append(heap[i]).append(']').toString());
    }
}
