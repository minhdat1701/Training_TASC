package javacore_6;

public class CustomException {
    public static void main(String args[]) {
        try {
            validate(13);
        } catch (Exception m) {
            System.out.println("Exception occured: " + m);
        }

        System.out.println("rest of the code...");
    }
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("not valid");
        } else {
            System.out.println("welcome to vote");
        }
    }
}
//Tạo class ngoại lệ kế thừa từ class Exception để tạo custom checked exception.
class InvalidAgeException extends Exception {
    InvalidAgeException(String s) {
        super(s);
    }
}
//Tạo class ngoại lệ kế thừa từ class RuntimeException để tạo custom unchecked exception.
//class InvalidAgeException extends RuntimeException {
//    InvalidAgeException(String s) {
//        super(s);
//    }
//}