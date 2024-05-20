package design_pattern.demo_singleton;

public class Main {
    public static void main(String[] args) {
        // Lấy instance của Singleton.
        Singleton singleton1 = Singleton.getInstance();
        // Gọi phương thức demo từ instance đầu tiên.
        singleton1.showMessage();

        // Lấy instance của Singleton một lần nữa.
        Singleton singleton2 = Singleton.getInstance();
        // Gọi phương thức demo từ instance thứ hai.
        singleton2.showMessage();

        // Kiểm tra xem cả hai instance có cùng một địa chỉ không.
        if (singleton1 == singleton2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
    }
}
