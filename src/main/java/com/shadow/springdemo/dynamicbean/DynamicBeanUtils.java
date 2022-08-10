package com.shadow.springdemo.dynamicbean;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-04 10:01
 */
public class DynamicBeanUtils {

    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        //得到原对象的属性
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class<?>> propertyMap = new HashMap<>();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        //构建新的对象
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        for (Map.Entry<String, Class<?>> entry : propertyMap.entrySet()) {
            try {
                if (!addProperties.containsKey(entry.getKey())) {//原来的值
                    dynamicBean.setValue(entry.getKey(), propertyUtilsBean.getNestedProperty(dest, entry.getKey()));
                }else {//新增的值
                    dynamicBean.setValue(entry.getKey(), addProperties.get(entry.getKey()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dynamicBean.getTarget();
    }
}
