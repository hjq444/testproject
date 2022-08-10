package com.shadow.springdemo.proxy;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-23 9:43
 */
public class App {
    public static void main(String[] args) throws Throwable {
        ITestService userStudy = new TestServiceImpl();
        ITestService jdkProxyUserStudy = TestJdkProxy.getJdkProxyUserService(userStudy);
        System.out.println("代理出来的对象是" + jdkProxyUserStudy);
        jdkProxyUserStudy.getName();
    }
}
