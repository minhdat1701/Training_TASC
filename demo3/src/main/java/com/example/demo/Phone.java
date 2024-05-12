package com.example.demo;

public class Phone {
    private Color color;

    public Phone(Color anything) {
        this.color = anything;
        color = new Yellow(); //Red coi là phụ thuộc của Phone
    }
}
