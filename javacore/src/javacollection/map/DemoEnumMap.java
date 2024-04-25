package javacollection.map;

import java.util.EnumMap;
import java.util.Map;

public class DemoEnumMap {
    enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK;
    }
    public static void main(String[] args) {
        Map<Color, String> enumMap = new EnumMap<>(Color.class);

        // Thêm các phần tử vào EnumMap
        enumMap.put(Color.RED, "apple");
        enumMap.put(Color.GREEN, "lime");
        enumMap.put(Color.BLUE, "sky");
        enumMap.put(Color.YELLOW, "banana");
        enumMap.put(Color.BLACK, "shadow");

        System.out.println("EnumMap:");
        for (Map.Entry<Color, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nPhương thức của EnumMap:");
        System.out.println("Size: " + enumMap.size());
        System.out.println("Contains key GREEN: " + enumMap.containsKey(Color.GREEN));
        System.out.println("Contains value 'apple': " + enumMap.containsValue("apple"));
        enumMap.remove(Color.RED);
        System.out.println("After removing key RED, EnumMap:");
        for (Map.Entry<Color, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
