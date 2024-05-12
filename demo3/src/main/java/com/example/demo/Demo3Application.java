package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
//        SpringApplication.run(Demo3Application.class, args);
//        Color red = new Red();
//        Phone phone = new Phone(red);
        var context = SpringApplication.run(Demo3Application.class, args);
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1.hashCode());
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean2.hashCode());

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.hashCode());
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.hashCode());

    }

}
