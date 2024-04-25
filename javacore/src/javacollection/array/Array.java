package javacollection.array;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        // Khai báo mảng kiểu int và khởi tạo ngay sau đó
        int[] numbers = {1, 4, 3, 5, 2};

        // Khai báo mảng kiểu int mà không khởi tạo giá trị ban đầu
        int[] numbers1 = new int[5];

        // Gán giá trị cho mảng numbers3
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = i + 1;
        }
        //In ra kích thước mảng
        System.out.println("Kích thước mảng: " + numbers.length);
        // Truy cập phần tử và in ra các phần tử của mảng
        System.out.println("Các phần tử của mảng:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Phần tử thứ " + i + ": " + numbers[i]);
        }
        // Sắp xếp mảng
        Arrays.sort(numbers);
        System.out.print("Mảng numbers sau khi sắp xếp: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        Student[] students = {
                new Student("A"),
                new Student("B"),
                new Student("C"),
                new Student("D")
        };

        // Truy cập và in ra các phần tử của mảng
        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            System.out.print(student + " ");
        }
    }
}
class Student
{

    public String name;
    Student(String name)
    {
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}