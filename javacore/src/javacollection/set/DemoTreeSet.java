package javacollection.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DemoTreeSet {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        // Thêm các phần tử vào TreeSet
        treeSet.add("apple");
        treeSet.add("banana");
        treeSet.add("orange");
        treeSet.add("apple"); // TreeSet không chấp nhận các phần tử trùng lặp

        System.out.println("TreeSet:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }

        // Phương thức của TreeSet
        System.out.println("\nPhương thức của TreeSet:");
        System.out.println("Size: " + treeSet.size());
        System.out.println("Contains 'banana': " + treeSet.contains("banana"));
        treeSet.remove("banana");
        System.out.println("After removing 'banana', TreeSet:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }
    }
}
