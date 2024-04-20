package javacore_4;

public class JavaCore4_1 {
    public static void main(String[] args) {
        // Tạo đối tượng Car
        Car myCar = new Car();
        myCar.startEngine(); // Output: Car's engine is starting
        myCar.vehicleType(); // Output: This is a vehicle (final method)

        // Che giấu phương thức staticMethod() của Vehicle
        Car.staticMethod(); // Output: Static method in Car

        // Không thể ghi đè phương thức private từ lớp cha
        // myCar.privateMethod(); // Lỗi: Không thể truy cập phương thức private

        // Tạo đối tượng Truck
        Truck myTruck = new Truck();
        myTruck.startEngine(); // Output: Truck's engine is starting
        myTruck.vehicleType(); // Output: This is a vehicle (final method)
    }
}
// Class Vehicle đại diện cho xe chung
class Vehicle {
    // Phương thức final có thể kế thừa, nhưng không thể ghi đè
    public final void vehicleType() {
        System.out.println("This is a vehicle");
    }

    // Phương thức bình thường có thể ghi đè
    public void startEngine() {
        System.out.println("Vehicle's engine is starting");
    }
    // Phương thức static không thể ghi đè, chỉ có thể che giấu
    public static void staticMethod() {
        System.out.println("Static method in Vehicle");
    }

    // Phương thức private không thể ghi đè hoặc truy cập từ lớp con
    private void privateMethod() {
        System.out.println("This is a private method in Vehicle");
    }
}

// Class Car đại diện cho ô tô, kế thừa từ Vehicle
class Car extends Vehicle {
    // Ghi đè phương thức startEngine()
    @Override
    public void startEngine() {
        System.out.println("Car's engine is starting");
    }

    // Che giấu phương thức static (hiding)
    public static void staticMethod() {
        System.out.println("Static method in Car");
    }

    // Phương thức vehicleType() không thể ghi đè vì là final
    /*
    @Override
    public void vehicleType() {
        System.out.println("This is a car");
    }
    */

    // Không thể ghi đè phương thức private
    /*
    @Override
    public void privateMethod() {
        System.out.println("This won't work");
    }
    */
}
// Class Truck đại diện cho xe tải, kế thừa từ Vehicle
class Truck extends Vehicle {
    // Ghi đè phương thức startEngine()
    @Override
    public void startEngine() {
        System.out.println("Truck's engine is starting");
    }
}