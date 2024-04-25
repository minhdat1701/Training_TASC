package javacollection.list;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        //Khởi tạo
        List<Integer> numbers = new ArrayList<>();
        //Thêm phần tử vào list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        //in list
        System.out.println("List: " + numbers);
        //lặp qua các phần tử của list
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            System.out.print(" - ");
        }
        System.out.println();
        //truy cập phần tử
        int number = numbers.get(2);
        System.out.println("Accessed Element: " + number);
        //xóa phần tử
        int removedNumber = numbers.remove(1);
        System.out.println("Removed Element: " + removedNumber);
        System.out.println("ArrayList after removing element: " + numbers);
        //kích thước list
        int size = numbers.size();
        System.out.println("Size of ArrayList: " + size);
        //thay đổi phần tử
        numbers.set(2, 5);
        System.out.println("Modified ArrayList: " + numbers);
        //tìm vị trí đầu tiên của phần tử
        int index = numbers.indexOf(3);
        System.out.println("Position of 3 is " + index);
        // Xóa toàn bộ phần tử của list
        numbers.clear();
        System.out.println("ArrayList after clearing all elements: " + numbers);
    }
}
