//Nếu phương thức lớp cha khai báo một exception
//Nếu phương thức lớp cha khai báo một exception, thì phương thức ghi đè của lớp con có thể khai báo cùng exception đó,
// exception của lớp con, hoặc không khai báo exception nào. Nhưng nó không thể khai báo exception cha.
package javacore_6;

public class ExceptionHandleOverriding1 extends Parent{
    public static void main(String args[]) {
        Parent p = new ExceptionHandleOverriding1();
        try {
            p.msg();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Phương thức ghi đè của lớp con khai báo exception cha
//    void msg() throws Exception { // Compile Time Error: Exception is broader than ArithmeticException
//        System.out.println("Phương thức ghi đè của lớp con khai báo exception cha");
//    }
    //Phương thức ghi đè của lớp con khai báo exception của lớp con
//    void msg() throws ArithmeticException {
//        System.out.println("Phương thức ghi đè của lớp con khai báo exception của lớp con");
//    }
    //Phương thức ghi đè của lớp con không khai báo exception nào
    void msg() {
        System.out.println("Phương thức ghi đè của lớp con không khai báo exception nào");
    }
}
