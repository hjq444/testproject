package com.shadow.springdemo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaMethodAreaOOM {
    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(JavaMethodAreaOOM.OOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {

                @Override
                public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            JavaMethodAreaOOM.OOM oom = (JavaMethodAreaOOM.OOM) enhancer.create();
            oom.sayHello("Kevin LUAN");
            System.out.println(">.....");
        }
    }

    static class OOM {
        public String sayHello(String str) {
            return "HI " + str;
        }
    }
}
