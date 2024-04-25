package javacollection.set;

import java.util.HashSet;
import java.util.Set;

public class DemoHashSet {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // Thêm các phần tử vào HashSet
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("orange");
        hashSet.add("apple"); // HashSet không chấp nhận các phần tử trùng lặp

        System.out.println("HashSet:");
        for (String fruit : hashSet) {
            System.out.print(fruit + " ");
        }
        System.out.println("\nPhương thức của HashSet:");
        System.out.println("Size: " + hashSet.size());
        System.out.println("Contains 'banana': " + hashSet.contains("banana"));
        hashSet.remove("banana");
        System.out.println("After removing 'banana', HashSet:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }
    }
}
