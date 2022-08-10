package com.shadow.springdemo.dynamicbean;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.annotation.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.shadow.springdemo.dynamicbean.DynamicBeanUtils.getTarget;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-04 10:21
 */
public class App {

    public static void main(String[] args) {
        TestClass entity = new TestClass();
        entity.setAge(15);
        entity.setId(1);
        entity.setName("张三");
        //动态设置属性字段
        Map<String, Object> addProperties = new HashMap() ;
        addProperties.put("sex", "男");
        addProperties.put("telephone", (long)123456789);
        //获取实体中给属性的值
        Object target = getTarget(entity, addProperties);
        Field[] declaredFields = target.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println(getFieldValueByName("id", target));
        System.out.println(getFieldValueByName("name", target));
        System.out.println(getFieldValueByName("age", target));
        System.out.println(getFieldValueByName("sex", target));
        System.out.println(getFieldValueByName("telephone", target));
    }

    //获取实体中属性的值
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            //通过反射获取值
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void addAnnotation(String className, String attributeName, String typeName) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass ct = pool.get(className);
            CtField cf = ct.getField(attributeName);
            FieldInfo fieldInfo = cf.getFieldInfo();
            AnnotationsAttribute attribute = (AnnotationsAttribute) fieldInfo.getAttribute(AnnotationsAttribute.visibleTag);
            ConstPool cp = fieldInfo.getConstPool();
            Annotation annotation = new Annotation(typeName, cp);
            System.out.println("添加注解" + annotation);
            attribute.addAnnotation(annotation);
            System.out.println("添加后的所有注解" + Arrays.toString(attribute.getAnnotations()));
        } catch (NotFoundException e) {
            System.out.println("此类不存在" + e);
        }
    }
}
