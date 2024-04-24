//Nếu phương thức của lớp cha không khai báo một exception
package javacore_6;

public class ExceptionHandleOverriding extends Parent {
    public static void main(String args[]) {
        Parent p = new ExceptionHandleOverriding();
        p.msg();
    }
    //Trong ví dụ này, phương thức msg() của lớp cha Parent không khai báo exception nào,
    // nhưng phương thức msg() của lớp con ExceptionHandleOverriding cố gắng khai báo IOException (một checked exception).
    // Điều này dẫn đến lỗi tại thời điểm biên dịch.
//    void msg() throws IOException { // Compile Time Error: Cannot throw more general exception
//        System.out.println("ExceptionHandleOverriding");
//    }
    //Trong trường hợp này, lớp con có thể khai báo Unchecked Exception, như ArithmeticException.
    void msg() throws ArithmeticException { // OK to throw Unchecked Exception
        System.out.println("child");
    }
}
class Parent {
    void msg() {
        System.out.println("parent");
    }
}
