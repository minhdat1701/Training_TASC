package javacollection.list;

import java.util.Stack;

public class DemoStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Thêm phần tử vào Stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Xem phần tử ở đỉnh của Stack
        System.out.println("Phần tử ở đỉnh của Stack: " + stack.peek());
        //Tìm kiếm phần tử
        int position = stack.search(3);
        System.out.println("Position of 3: " + position);

        // Lấy ra và hiển thị các phần tử từ Stack
        System.out.println("Các phần tử của Stack:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
