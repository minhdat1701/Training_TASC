package javacollection.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class DemoLinkedHashSet {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Thêm các phần tử vào LinkedHashSet
        linkedHashSet.add("apple");
        linkedHashSet.add("banana");
        linkedHashSet.add("orange");
        linkedHashSet.add("apple"); // LinkedHashSet không chấp nhận các phần tử trùng lặp

        System.out.println("\nLinkedHashSet:");
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }
        System.out.println("\nPhương thức của LinkedHashSet:");
        System.out.println("Size: " + linkedHashSet.size());
        System.out.println("Contains 'banana': " + linkedHashSet.contains("banana"));
        linkedHashSet.remove("banana");
        System.out.println("After removing 'banana', LinkedHashSet:");
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }
    }
}
