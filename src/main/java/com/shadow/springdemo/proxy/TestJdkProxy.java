package com.shadow.springdemo.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Huajq
 * @description:
 * @date: 2022-06-23 9:38
 */
public class TestJdkProxy{
    public static ITestService getJdkProxyUserService(ITestService testService) throws Throwable {
        //1.类加载器
        ClassLoader classLoader = testService.getClass().getClassLoader();
        //2.获得所有接口
        Class[] interfaces = testService.getClass().getInterfaces();
        Method[] methods = testService.getClass().getMethods();
        TestHandler testHandler =new TestHandler();
        for (Method method : methods) {
            System.out.println(method);
            if (method.getName().equals("public void com.shadow.springdemo.proxy.TestServiceImpl.getName()")) {
            Object getName = testHandler.invoke(null, method, null);
            System.out.println(getName);
            }
        }

        ITestService o = (ITestService) Proxy.newProxyInstance(classLoader, interfaces, testHandler);
        //返回一个代理对象
        return o;
    }
}
