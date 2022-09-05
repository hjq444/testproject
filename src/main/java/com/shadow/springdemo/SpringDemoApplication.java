package com.shadow.springdemo;

import com.shadow.springdemo.aopTest.Buy;
import com.shadow.springdemo.aopTest.BuyCat;
import com.shadow.springdemo.aopTest.Cat;
import com.shadow.springdemo.spiTest.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringDemoApplication.class, args);
//        BuyCat bean = run.getBean(BuyCat.class);
//        String[] beanNames = run.getBeanNamesForType(Buy.class);
//        for (String beanName : beanNames) {
//            Buy bean1 = (Buy)run.getBean(beanName);
//            bean1.buy(new Cat("asdasda",1));
//            System.out.println(bean1);
//        }
//        Cat cat = new Cat();
//        cat.setName("test");
//        String test = bean.buy(cat);
//        System.out.println(test);
//        Class<? extends BuyCat> aClass = bean.getClass();
//        System.out.println(aClass);


//        Annotation[] declaredAnnotations = BuyCat.class.getDeclaredAnnotations();
//        for (int i = 0; i < declaredAnnotations.length; i++) {
//            System.out.println(declaredAnnotations[i].annotationType());
//        }

        // 堆溢出demo
//        List<Object> objects = new ArrayList<>();
//        while (true){
//            Dog dog = new Dog();
//            objects.add(dog);
//            System.out.println(dog);
//        }


    }

}
