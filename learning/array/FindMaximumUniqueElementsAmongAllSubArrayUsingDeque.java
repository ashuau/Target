package learning.array;


import java.util.*;

public class FindMaximumUniqueElementsAmongAllSubArrayUsingDeque {
    public static void main(String[] args) {
        final Deque<Integer> deque = new ArrayDeque<>();
        final Map<Integer, Integer> map = new HashMap<>();
        final int m = 3; //subarray size
        int [] arr = {5,3, 5, 2, 3, 2};
        final int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            final int num = arr[i];
            deque.addLast(num);
            if (map.containsKey(num)) {
                map.put(num, map.get(num).intValue() + 1);
            } else {
                map.put(num, 1);
            }

            if (deque.size() == m + 1) {
                final int key = deque.removeFirst();
                final int v = map.get(key);
                if (v == 1) {
                    map.remove(key);
                } else {
                    map.put(key, v - 1);
                }
            }

            final int cnt = map.size();
            if (cnt > res) {
                res = cnt;
            }
        }
        System.out.println(res);
    }

}
