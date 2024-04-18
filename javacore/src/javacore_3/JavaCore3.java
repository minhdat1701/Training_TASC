package javacore_3;

public class JavaCore3 {
    static int staticVariable = 10; // Biến static
    // Phương thức static: in giá trị của staticVariable
    static void printStaticVariable() {
        System.out.println("Giá trị của staticVariable: " + staticVariable);
    }
    public static void main(String[] args) {
        //1. Static
        System.out.println("Giá trị của staticVariable: " + staticVariable);
        // Gọi phương thức static
        printStaticVariable();
        // Có thể thay đổi giá trị của thuộc tính static
        staticVariable = 20;
        System.out.println("Giá trị của staticVariable sau khi thay đổi: " + staticVariable);
        //2. Final
        final int finalVariable = 20; // Biến final
        final int x; // Biến final không khởi tạo giá trị tại thời điểm khai báo
        x = 10; // Nhưng phải gán giá trị trước khi sử dụng
        System.out.println("x: " + x);
        final Person person1 = new Person("Minh");
        System.out.println("Tên person1: " + person1.getName()); // In ra: Tên person1: Minh
        // Thử gán lại biến final để tham chiếu đến một đối tượng khác (Sẽ bị lỗi)
        // person1 = new Person("Dat"); // Lỗi: Cannot assign a value to final variable 'person1'
        // Nhưng trạng thái của đối tượng có thể thay đổi
        person1.name = "Dat";
        System.out.println("Tên person1 sau khi thay đổi: " + person1.getName()); // In ra: Tên person1 sau khi thay đổi: Dat
    }
}
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}