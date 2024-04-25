package javacollection.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DemoArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<String> animals= new ArrayDeque<>();
        // add() và offer() giống nhau
        //nếu deque đầy, add() ném throws IllegalStateException
        //offer() trả về false
        animals.add("Dog");
        animals.offer("Pig");
        // addFirst()
        animals.addFirst("Cat");
        animals.offerFirst("Tiger");
        // addLast()
        animals.addLast("Horse");
        animals.offerLast("Bird");
        System.out.println("ArrayDeque: " + animals);

        // lấy phần tử đầu tiên
        String firstElement = animals.getFirst();
        System.out.println("First Element: " + firstElement);
        // lấy phần tử cuối cùng
        String lastElement = animals.getLast();
        System.out.println("Last Element: " + lastElement);
        // peek() và peekFirst(): trả về phần tử đầu tiên
        String element = animals.peek();
        System.out.println("Head Element: " + element);
        // peekLast() trả về phần tử cuối cùng
        String lastElement1 = animals.peekLast();
        System.out.println("Last Element: " + lastElement);
        //remove() và pool(): xóa phần tử trong hàng đợi
        // Using removeFirst()
        String firstElement2 = animals.removeFirst();
        System.out.println("Removed First Element: " + firstElement);
        System.out.println(animals);
        // Using pollLast()
        String lastElement2 = animals.pollLast();
        System.out.println("Removed Last Element: " + lastElement);
        System.out.println(animals);

        //push() thêm phần tử vào đầu ngăn xếp
        animals.push("Lion");
        System.out.println(animals);
        //pop(): xóa phần tử khỏi đỉnh ngăn xếp
        String remElement = animals.pop();
        System.out.println("Removed element: " + remElement);
        System.out.println(animals);
    }
}
