package javacore_2;

public class JavaCore2 {
    public static void main(String[] args) {
        //1. Đặc điểm của String
        // Khởi tạo một đối tượng String
        String str1 = "Hello";
        // Tạo một đối tượng String mới thông qua phương thức concat()
        String str2 = str1.concat(" World");
        // In ra giá trị của str1 và str2
        System.out.println("str1: " + str1); // str1: Hello
        System.out.println("str2: " + str2); // str2: Hello World
        // Chuyển đối tượng Integer thành chuỗi thông qua phương thức toString()
        Integer num = 123;
        String numString = num.toString();
        // In ra giá trị của numString
        System.out.println("numString: " + numString); // numString: 123
        // Định dạng chuỗi bằng phương thức format()
        String formattedString = String.format("The value of num is %d", num);
        // In ra chuỗi được định dạng
        System.out.println("formattedString: " + formattedString); // formattedString: The value of num is 123

        // Sử dụng regular expressions để tách chuỗi
        String text = "apple orange banana";
        String[] fruits = text.split(" ");
        for (String i : fruits) {
            System.out.print(i + " ");
        }
        //2. Tạo 1 biến String
        // Sử dụng literal
        String str11 = "Hello";
        System.out.println("str1: " + str1);
        // Sử dụng constructor
        String str21 = new String("My name is D");
        System.out.println("str2: " + str2);
        //3. String pool
        String str31 = "hello";
        String str32 = "hello";
        String str33 = new String("hello");
        // Kiểm tra xem str1 và str2 có tham chiếu đến cùng một đối tượng không
        System.out.println("str31 == str32: " + (str31 == str32)); // true
        // Kiểm tra xem str1 và str3 có tham chiếu đến cùng một đối tượng không
        System.out.println("str31 == str33: " + (str31 == str33)); // false
        // Sử dụng phương thức intern() để chuyển str3 thành chuỗi trong string pool
        str33 = str33.intern();
        // Kiểm tra xem str1 và str3 có tham chiếu đến cùng một đối tượng không sau khi intern()
        System.out.println("str1 == str3 (after intern()): " + (str31 == str33)); // true
        //4. So sánh 2 chuỗi
        String str4 = "hello";
        String str5 = "hello";
        if (str4.equals(str5)) {
            System.out.println("Hai chuỗi giống nhau");
        } else {
            System.out.println("Hai chuỗi khác nhau");
        }
        if (str4 == str5) {
            System.out.println("Hai chuỗi giống nhau");
        } else {
            System.out.println("Hai chuỗi khác nhau");
        }
        String str41 = "Hello";
        String str42 = "hello";
        if (str41.equalsIgnoreCase(str42)) {
            System.out.println("Hai chuỗi giống nhau (không phân biệt chữ hoa và chữ thường)");
        } else {
            System.out.println("Hai chuỗi khác nhau");
        }
        String str51 = "hello";
        String str52 = "world";
        int result = str51.compareTo(str52);
        if (result < 0) {
            System.out.println("str51 đứng trước str52 trong từ điển");
        } else if (result > 0) {
            System.out.println("str51 đứng sau str52 trong từ điển");
        } else {
            System.out.println("str51 và str52 giống nhau");
        }

    }
}
