package javacollection.map;

import java.util.Map;
import java.util.TreeMap;

public class DemoTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> treeMap = new TreeMap<>();

        // Thêm các phần tử vào TreeMap
        treeMap.put(3, "apple");
        treeMap.put(1, "banana");
        treeMap.put(2, "orange");
        treeMap.put(3, "apple"); // TreeMap không chấp nhận các khóa trùng lặp, ko cho phép khóa null
        System.out.println("TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Size: " + treeMap.size());
        System.out.println("Contains key 2: " + treeMap.containsKey(2));
        System.out.println("Contains value 'banana': " + treeMap.containsValue("banana"));
        treeMap.remove(2);
        System.out.println("After removing key 2, TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
