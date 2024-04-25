package javacollection.set;

import java.util.EnumSet;
import java.util.Iterator;

public class DemoEnumSet {
    enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
    public static void main(String[] args) {
        //Tạo EnumSet dùng allOf
        EnumSet<Size> sizes = EnumSet.allOf(Size.class);
        System.out.println("EnumSet: " + sizes);
        // tạo EnumSet dùng noneOf()
        EnumSet<Size> sizes2 = EnumSet.noneOf(Size.class);
        System.out.println("Empty EnumSet: " + sizes2);
        sizes2.add(Size.MEDIUM);
        System.out.println("EnumSet Using add(): " + sizes2);
        sizes2.addAll(sizes);
        System.out.println("EnumSet Using addAll(): " + sizes2);
        //truy cập EnumSet
        Iterator<Size> iterate = sizes.iterator();

        System.out.print("EnumSet: ");
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
        System.out.println();
        //xóa 1 phần tử
        // Using remove()
        boolean value = sizes.remove(Size.MEDIUM);
        System.out.println("Is MEDIUM removed? " + value);
        System.out.println("EnumSet: " + sizes);
    }
}
