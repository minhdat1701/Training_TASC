package javacore_5;

public class JavaCore5 {
    public static void main(String[] args) {
        // Cấp phát tĩnh trên stack
        int staticStackVar = 10;
        //staticStackVar là một biến nguyên cơ bản được cấp phát trực tiếp trên stack.
        //Biến này có một kích thước cố định và tồn tại trong phạm vi của phương thức main().

        // Cấp phát động trên heap
        Integer dynamicHeapVar = new Integer(20);
        //dynamicHeapVar là một đối tượng Integer được cấp phát trên heap bằng cách sử dụng toán tử new.
        // Đối tượng này có thể có kích thước thay đổi và tồn tại ngoài phạm vi của phương thức main().
        // In giá trị của biến staticStackVar và dynamicHeapVar
        System.out.println("Static stack variable: " + staticStackVar);
        System.out.println("Dynamic heap variable: " + dynamicHeapVar);
    }
}

