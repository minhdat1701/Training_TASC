package javacore_4;

public class JavaCore4 {
    public static void main(String[] args) {
        // Tạo đối tượng Dog từ lớp Dog (thể hiện instance)
        Dog myDog = new Dog("Buddy"); // Instance của lớp Dog
        // Overriding: Ghi đè phương thức eat() của class cha
        myDog.eat(); // Output: Dog Buddy is eating bones
        // Overloading: Phương thức eat() với tham số khác nhau
        myDog.eat("meat"); // Output: Dog Buddy is eating meat

        // Tạo đối tượng Cat từ lớp Cat (thể hiện instance)
        Cat myCat = new Cat("Whiskers"); // Instance của lớp Cat
        // Overriding phương thức eat() của class cha Animal
        myCat.eat(); // Output: Whiskers is eating
        // Gọi phương thức makeSound() của interface AnimalSound
        myCat.makeSound(); // Output: Cat Whiskers meows
    }
}

// Class cha Animal thể hiện Inheritance và Encapsulation
class Animal {
    // Thuộc tính
    private String name;

    // Constructor sử dụng 'this' để tham chiếu tới thuộc tính của class hiện tại
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức
    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Class con Dog kế thừa từ class cha Animal
class Dog extends Animal {
    // Constructor
    public Dog(String name) {
        super(name); // Sử dụng `super` để gọi constructor của class cha
    }

    // Overriding: Ghi đè phương thức eat() của class cha Animal
    @Override
    public void eat() {
        System.out.println("Dog " + super.getName() + " is eating bones");
    }

    // Overloading: Ghi đè phương thức eat() với tham số khác nhau
    public void eat(String food) {
        System.out.println("Dog " + super.getName() + " is eating " + food);
    }
}

// Interface AnimalSound định nghĩa một phương thức trừu tượng (Abstraction)
interface AnimalSound {
    // Phương thức trừu tượng
    void makeSound();
}

// Class Cat kế thừa từ class Animal và implements interface AnimalSound
class Cat extends Animal implements AnimalSound {
    // Constructor
    public Cat(String name) {
        // Dùng 'super' gọi constructor của class cha Animal
        super(name);
    }

    // Implement phương thức makeSound() của interface AnimalSound
    @Override
    public void makeSound() {
        System.out.println("Cat " + super.getName() + " meows");
    }
}
