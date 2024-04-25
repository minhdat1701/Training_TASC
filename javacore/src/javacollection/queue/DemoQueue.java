package javacollection.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DemoQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // thêm phần tử vào hàng đợi add() hoặc offer()
        //add(): thành công trả về true, nếu không nó sẽ ném ra một ngoại lệ .
        //Offer():thành công trả về true, nếu không thì trả về false.
        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");

        // in hàng đợi
        System.out.println("Queue: " + queue);
        //trả về phần tử đầu của hàng đợi, nếu trống thì ném ra ngoại lệ
        System.out.println(queue.element());
        //xóa phần tử hàng đợi
        String front = queue.remove(); // trả về và xóa phần tử đầu tiên của hàng đợi
        //có thể dùng pool() thay remove(), nếu queue trống thì remove() ném ra ngoại lệ, pool() trả về null
        System.out.println("Removed element: " + front);

        // print the updated queue
        System.out.println("Queue after removal: " + queue);

        queue.add("date");

        // nhìn trộm phần tử đầu tiên của hàng đợi
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);

        // in ra hàng đợi đã cập nhật
        System.out.println("Queue after peek: " + queue);

        queue.offer("orange");
        queue.offer("watermelon");

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
