package javacollection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class DemoPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        // Thêm các phần tử vào PriorityQueue
        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(3);
        System.out.println(pq);
        // Hiển thị các phần tử của PriorityQueue theo thứ tự ưu tiên
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
