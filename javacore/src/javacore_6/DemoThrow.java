package javacore_6;

public class DemoThrow {
    public static void main(String[] args) {
        ageValid(20);
        System.out.println("------");
        ageValid(15);
    }
    public static void ageValid(int age){
        if(age < 18){
            throw new ArithmeticException("Age not valid!");
        }else{
            System.out.println("Age valid");
        }
    }
}
