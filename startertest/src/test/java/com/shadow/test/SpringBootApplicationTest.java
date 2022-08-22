package com.shadow.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test1.StudentService;

@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    private StudentService studentService;



}
