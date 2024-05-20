package design_pattern.demo_singleton;
//Lazy Initialization
public class Singleton {
    private static Singleton instance;

    // Private constructor để ngăn việc tạo instance từ bên ngoài lớp.
    private Singleton() {
    }

    // Phương thức public static để truy cập instance duy nhất của lớp.
    public static Singleton getInstance() {
        // Nếu instance chưa được tạo, tạo mới nó.
        if (instance == null) {
            instance = new Singleton();
        }
        // Trả về instance đã tồn tại hoặc mới được tạo.
        return instance;
    }

    // Phương thức demo để kiểm tra việc hoạt động của Singleton.
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
