package javacore_6;

public class DemoThrows {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int divide(int dividend, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            // Ném một ngoại lệ khi chia cho 0
            throw new ArithmeticException("Cannot divide by zero");
        }
        return dividend / divisor;
    }
}
