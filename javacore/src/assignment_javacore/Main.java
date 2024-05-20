package assignment_javacore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "customers.dat";
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        loadCustomers();
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Xem thông tin danh sách khách hàng");
            System.out.println("2. Thêm danh sách khách hàng");
            System.out.println("3. Tìm kiếm khách hàng theo số điện thoại");
            System.out.println("4. Chỉnh sửa thông tin khách hàng");
            System.out.println("5. Xóa thông tin khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viewCustomersList();
                    break;
                case 2:
                    addCustomer();
                    saveCustomers();
                    break;
                case 3:
                    searchCustomerByPhoneNumber();
                    saveCustomers();
                    break;
                case 4:
                    updateCustomer();
                    saveCustomers();
                    break;
                case 5:
                    deleteCustomer();
                    saveCustomers();
                    break;
                case 0:
                    saveCustomers();
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời chọn lại");
            }
        }
    }

    private static void viewCustomersList() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống");
        }
        else {
            System.out.println("Danh sách khách hàng:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Nhập số lượng khách hàng muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = "";
            String email = "";
            String phoneNumber = "";
            boolean validName = false;
            boolean validEmail = false;
            boolean validPhoneNumber = false;
            while (!validName) {
                System.out.printf("Nhập tên khách hàng thứ %d: ", i + 1);
                name = scanner.nextLine();
                if (isValidName(name)) {
                    System.out.println("Tên không được để trống. Mời nhập lại.");
                } else {
                    validName = true;
                }
            }
            while (!validEmail) {
                System.out.printf("Nhập email khách hàng thứ %d: ", i + 1);
                email = scanner.nextLine();
                if (!isValidEmail(email)) {
                    System.out.println("Định dạng email không hợp lệ. Hãy nhập lại địa chỉ email");
                } else {
                    validEmail = true;
                }
            }
            while (!validPhoneNumber) {
                System.out.printf("Nhập số điện thoại khách hàng thứ %d: ", i + 1);
                phoneNumber = scanner.nextLine();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Định dạng số điện thoại không hợp lệ. Hãy nhập lại số điện thoại có 10 số.");
                } else if (phoneNumberExists(phoneNumber)) {
                    System.out.println("Số điện thoại đã tồn tại. Hãy nhập lại số điện thoại.");
                } else {
                    validPhoneNumber = true;
                }
            }
            customers.add(new Customer(name, email, phoneNumber));
        }
        System.out.println("Thêm khách hàng thành công!");
    }
    private static boolean phoneNumberExists(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
    private static void searchCustomerByPhoneNumber() {
        System.out.print("Nhập số điện thoại cần tìm kếm: ");
        String phoneNumber = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.printf("Khách hàng với số điện thoại %s tìm kiếm được là: \n", phoneNumber);
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng có số điện thoại " + phoneNumber);
    }

    private static void updateCustomer() {
        System.out.print("Nhập số điện thoại khách hàng cần cập nhật thông tin: ");
        String phoneNumber = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Khách hàng cần cập nhật thông tin:");
                System.out.println(customer);
                boolean validName = false;
                boolean validEmail = false;
                while (!validName) {
                    System.out.print("Nhập tên mới (Nhấn Enter nếu không thay đổi): ");
                    String newName = scanner.nextLine();
                    if (newName.isEmpty()) {
                        validName = true; // Không cập nhật tên nếu người dùng nếu không nhập gì
                    } else if (!isValidName(newName)) {
                        System.out.println("Tên không hợp lệ. Mời nhập lại.");
                    } else {
                        customer.setName(newName);
                        validName = true;
                    }
                }
                while (!validEmail) {
                    System.out.print("Nhập email mới (Nhấn Enter nếu không thay đổi): ");
                    String newEmail = scanner.nextLine();
                    if (!isValidEmail(newEmail)) {
                        System.out.println("Định dạng email không hợp lệ. Hãy nhập lại địa chỉ email");
                    } else {
                        customer.setEmail(newEmail);
                        validEmail = true;
                    }
                }
                System.out.println("Cập nhật thông tin khách hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng");
    }

    private static void deleteCustomer() {
        System.out.print("Nhập số điện thoại của khách hàng cần xóa: ");
        String phoneNumber = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                customers.remove(i);
                System.out.println("Xóa thông tin khách hàng thành công");
                found= true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    private static void loadCustomers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            customers = (List<Customer>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void saveCustomers() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private static boolean isValidName(String name) {
        return name != null && !name.isEmpty() && name.matches("[a-zA-Z]");
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}
