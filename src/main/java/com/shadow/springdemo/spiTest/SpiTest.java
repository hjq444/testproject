package com.shadow.springdemo.spiTest;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.Map;

/**
 * @author: Huajq
 * @date: 2022-06-01 10:05
 */
public class SpiTest {
    public static void main(String[] args) {
        List<Animal> animals = SpringFactoriesLoader.loadFactories(Animal.class, null);
        animals.forEach(Animal -> {
            System.out.println(Animal);
            Animal.test();
        });

//        Map<String, String> getenv = System.getenv();
//        getenv.forEach((k, v) -> {
//            System.out.println(k + "=" + v);
//        });
    }
}
