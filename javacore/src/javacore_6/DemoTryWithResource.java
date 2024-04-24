package javacore_6;

import java.io.*;
import java.util.*;

public class DemoTryWithResource {
    public static void main(String[] args) {
        // Khai báo và khởi tạo một đối tượng Scanner trong khối try-with-resources
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            // Đọc dữ liệu từ tệp và in ra màn hình
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // Xử lý ngoại lệ nếu không tìm thấy tệp
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
