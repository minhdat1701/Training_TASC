package javacore_1;

public class JavaCore1 {
    public static void main(String[] args) {
        //1. Phân biệt Primitive and object data type
        // kiểu dữ liệu nguyên thủy có tính chất tham trị
        int a = 3;
        int b = a;
        b = b + 1;
        System.out.println(a); // 3
        System.out.println(b); // 4
        // kiểu dữ liệu đối tượng có tính chất tham chiếu
        Student sv1 = new Student("Nguyen Van A");
        Student sv2 = sv1;
        sv2.setName("Nguyen Van B");
        System.out.println("Student 1: " + sv1.getName());
        System.out.println("Student 2: " + sv2.getName());
        //2. Chuyển đổi (Boxing & Unboxing)
        //-- Autoboxing: Chuyển đổi từ kiểu dữ liệu nguyên thủy sang kiểu dữ liệu đối tượng
        int a1 = 10;
        Integer b1 = a1; // Tự động chuyển đổi
        System.out.println(a1 + " - " + b1);
        //-- Boxing: Chuyển đổi từ kiểu dữ liệu nguyên thủy sang kiểu dữ liệu đối tượng
        int a2 = 10;
        Integer b2 = Integer.valueOf(a2); // Boxing
        System.out.println(a2 + " - " + b2);
        //-- Unboxing: Chuyển đổi từ kiểu dữ liệu đối tượng sang kiểu dữ liệu nguyên thủy
        Integer a3 = new Integer(20);
        int b3 = a3.intValue();  // Unboxing
        System.out.println(a3 + " - " + b3);
        //3. So sánh 2 kiểu dữ liệu
        Long a4 = 1234512L;
        long b4 = 1234512;
        System.out.println("a equals b?: " + (a4 == b4));
        if (a4.equals(b4)) {
            System.out.println("a4 và b4 có giá trị bằng nhau.");
        } else {
            System.out.println("a4 và b4 có giá trị khác nhau.");
        }
        //4. Giá trị khởi tạo
        int x = 5;
        double y = 3.14;
        boolean isTrue = true;
        String str = "Hello";
        Integer num = new Integer(10);
        Student std = new Student();
    }
}
class Student{
    private String name;
    public Student(String name){
        this.name = name;
    }

    public Student() {
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}