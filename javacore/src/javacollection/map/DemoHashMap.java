package javacollection.map;

import java.util.HashMap;
import java.util.Map;

public class DemoHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Basic java");
        map.put(2, "OOP");
        map.put(3, "Collection");

        // show map using method keySet()
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " - " + value);
        }

        System.out.println("----------");

        // show map using method keySet()
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
